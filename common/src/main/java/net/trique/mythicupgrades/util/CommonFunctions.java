package net.trique.mythicupgrades.util;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.registry.EffectRegistry;

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
}