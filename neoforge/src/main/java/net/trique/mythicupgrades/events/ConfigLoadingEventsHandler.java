package net.trique.mythicupgrades.events;


import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.networking.packet.MUConfigPacket;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ConfigLoadingEventsHandler {
    @SubscribeEvent
    public static void updateValues(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec().equals(MUConfig.CONFIG_SPEC)) {
            MUConfigHelper.updateCurrentValuesOnChange(CONFIG);
            MUConfigPacket muConfigPacket = new MUConfigPacket(CONFIG);
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                PacketDistributor.sendToAllPlayers(muConfigPacket);
            }
        }
    }
}
