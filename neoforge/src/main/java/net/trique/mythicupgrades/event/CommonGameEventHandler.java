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
import net.neoforged.neoforge.event.TagsUpdatedEvent;
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
        CommonFunctions.playerTickPre(player);
    }

    @SubscribeEvent
    public static void updateTags(TagsUpdatedEvent event) {
        MUConfig.clearCache();
    }
}
