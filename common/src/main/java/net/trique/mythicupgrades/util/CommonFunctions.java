package net.trique.mythicupgrades.util;

import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.attachments.CommonDataAttachments;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.registry.EffectRegistry;
import net.trique.mythicupgrades.util.spelunker.ChunkOres;
import net.trique.mythicupgrades.util.spelunker.SpelunkerEffectManager;

import java.util.*;

import static net.trique.mythicupgrades.Constants.RANDOM;

public class CommonFunctions {

    public static int getEnchantmentLevel(ResourceKey<Enchantment> key, Level world, ItemStack stack) {
        RegistryAccess drm = world.registryAccess();
        Registry<Enchantment> reg = drm.registryOrThrow(Registries.ENCHANTMENT);
        Optional<Holder.Reference<Enchantment>> optional = reg.getHolder(key);
        Holder<Enchantment> enchantmentEntry = optional.orElseThrow();
        return EnchantmentHelper.getItemEnchantmentLevel(enchantmentEntry, stack);
    }

    public static String arabicToRom(int num){
        num += 1;
        int [] a = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String [] r = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i = 12;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            while (a[i] > num){
                i--;
            }
            result.append(r[i]);
            num -= a[i];

        }
        return result.toString();
    }

    public static <B extends FriendlyByteBuf, V extends Enum<V>> StreamCodec<B, V> enumStreamCodec(final Class<V> enumClass) {
        return new StreamCodec<>() {
            @Override
            public V decode(B buf) {
                return buf.readEnum(enumClass);
            }

            @Override
            public void encode(B buf, V value) {
                buf.writeEnum(value);
            }
        };
    }

    public static  <T extends LivingEntity> boolean applyItemMasteryChance(T user) {
        if (user != null && user.hasEffect(EffectRegistry.ITEM_MASTERY)) {
            return RANDOM.nextFloat() <= 0.1f * (user.getEffect(EffectRegistry.ITEM_MASTERY).getAmplifier() + 1);
        }
        return false;
    }

    public static ResourceLocation getLoc(String key) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, key);
    }

    public static float getIncomingDamage(float original, LivingEntity target, DamageSource source) {
        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            ItemStack weapon = livingAttacker.getMainHandItem();
            if (weapon.getItem() instanceof TieredItem tieredItem && tieredItem.getTier() == MUToolMaterials.AQUAMARINE && target.isInWaterRainOrBubble()) {
                original += 2;
            }
        }
        return original;
    }

    public static void playerTickPre(Player player) {
        Level world = player.level();
        HashSet<BlockPos> spelunkerEffectChunks = Services.PLATFORM.getOrCreateAttachedValue(player, CommonDataAttachments.SPELUNKER_POS);
        boolean forceOreChunkUpdate = Services.PLATFORM.getOrCreateAttachedValue(player,CommonDataAttachments.FORCE_ORE_CHUNK_UPDATE);

        if(!player.hasEffect(EffectRegistry.SPELUNKER)) {
            if(!spelunkerEffectChunks.isEmpty())
                spelunkerEffectChunks.clear();
            Services.PLATFORM.setAttachedValue(player,CommonDataAttachments.FORCE_ORE_CHUNK_UPDATE,true);
            Services.PLATFORM.setAttachedValue(player, CommonDataAttachments.SPELUNKER_POS,spelunkerEffectChunks);
            return;
        }

        int cx = SectionPos.posToSectionCoord(player.getX());
        int cy = SectionPos.posToSectionCoord(player.getY());
        int cz = SectionPos.posToSectionCoord(player.getZ());

        Vec3i lastChunkSectionPos = Services.PLATFORM.getAttachedValue(player, CommonDataAttachments.LAST_CHUNK);

        // update if player crosses chunk border
        if (!new Vec3i(cx,cy,cz).equals(lastChunkSectionPos) || forceOreChunkUpdate) {
            Services.PLATFORM.setAttachedValue(player,CommonDataAttachments.FORCE_ORE_CHUNK_UPDATE,false);
            HashMap<BlockPos, LevelChunkSection> newChunks = SpelunkerEffectManager.getSurroundingChunkSections(world, player.position());

            // calc difference and find ores
            HashSet<BlockPos> remove = new HashSet<>();
            spelunkerEffectChunks.removeIf(p -> {
                if (!newChunks.containsKey(p)) {
                    remove.add(p);
                    return true;
                }
                return false;
            });
            ArrayList<ChunkOres> add = new ArrayList<>();
            for (Map.Entry<BlockPos, LevelChunkSection> section : newChunks.entrySet()) {
                BlockPos pos = section.getKey();
                if (!spelunkerEffectChunks.contains(pos)) {
                    add.add(SpelunkerEffectManager.findOresInChunk(world, pos));
                    spelunkerEffectChunks.add(pos);
                }
            }

            // handle new and removed chunk sections
            if(world.isClientSide()) {
                SpelunkerEffectRenderer.updateChunks(world, remove, add);
            }
        }
        Services.PLATFORM.setAttachedValue(player, CommonDataAttachments.SPELUNKER_POS,spelunkerEffectChunks);
        Services.PLATFORM.setAttachedValue(player, CommonDataAttachments.LAST_CHUNK,new Vec3i(cx,cy,cz));
    }

    public static String getTranslationKey(String key) {
        return Constants.MOD_ID + "." + key;
    }
}