package net.trique.mythicupgrades.event;


import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.networking.packet.S2CConfigFilePayload;
import net.trique.mythicupgrades.platform.NeoForgePlatformHelper;

import java.io.IOException;
import java.nio.file.Files;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ServerConfigEventHandler {

    @SubscribeEvent
    private static void syncOnJoin(final PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof
                ServerPlayer player) {
            try {
                PacketDistributor.sendToPlayer(player, new S2CConfigFilePayload(NeoForgePlatformHelper.SYNCABLE_CONFIG.getFileName()
                , Files.readAllBytes(NeoForgePlatformHelper.SYNCABLE_CONFIG.getFullPath())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
