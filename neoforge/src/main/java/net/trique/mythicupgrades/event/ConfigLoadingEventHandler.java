package net.trique.mythicupgrades.event;


import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.platform.Services;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ConfigLoadingEventHandler {
    @SubscribeEvent
    public static void updateValues(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec().equals(MUConfig.CONFIG_SPEC)) {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                Services.PLATFORM.sendSyncedConfig(server);
            }
        }
    }
}
