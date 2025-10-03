package net.trique.mythicupgrades.event;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfigHelper;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientConfigEventHandler {

    @SubscribeEvent
    private static void cacheClientValues(ClientPlayerNetworkEvent.LoggingIn event) {
    }


    @SubscribeEvent
    private static void loadClientValues(ClientPlayerNetworkEvent.LoggingOut event) {
    }
}
