package net.trique.mythicupgrades.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForgeConfig;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.attachments.CommonDataAttachments;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.config.MUConfigCache;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.networking.packet.S2CSpelunkerDataPacket;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.registry.EffectRegistry;
import net.trique.mythicupgrades.util.CommonFunctions;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;
import net.trique.mythicupgrades.util.spelunker.ChunkOres;
import net.trique.mythicupgrades.util.spelunker.SpelunkerEffectManager;

import java.util.*;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class CommonGameEventHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
        event.setAmount(CommonFunctions.getIncomingDamage(event.getAmount(),event.getEntity(),event.getSource()));
    }

    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
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
}
