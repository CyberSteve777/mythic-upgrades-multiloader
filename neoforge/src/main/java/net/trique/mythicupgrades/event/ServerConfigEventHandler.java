package net.trique.mythicupgrades.event;


import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.networking.packet.MUConfigPacket;


import static net.trique.mythicupgrades.config.MUConfig.CONFIG;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ServerConfigEventHandler {

    @SubscribeEvent
    private static void syncOnJoin(final PlayerEvent.PlayerLoggedInEvent event) {
        MUConfigPacket muConfigPacket = new MUConfigPacket(CONFIG);
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null && event.getEntity() instanceof
                ServerPlayer player) {
            PacketDistributor.sendToPlayer(player, muConfigPacket);
        }
    }
}
