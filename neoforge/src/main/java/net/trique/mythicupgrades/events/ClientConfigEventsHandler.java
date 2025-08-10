package net.trique.mythicupgrades.events;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfigHelper;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientConfigEventsHandler {

    @SubscribeEvent
    private static void cacheClientValues(ClientPlayerNetworkEvent.LoggingIn event) {
        MUConfigHelper.cachePlayerTopazValues();
        MUConfigHelper.cachePlayerAquamarineValues();
        MUConfigHelper.cachePlayerPeridotValues();
        MUConfigHelper.cachePlayerSapphireValues();
        MUConfigHelper.cachePlayerRubyValues();
        MUConfigHelper.cachePlayerJadeValues();
        MUConfigHelper.cachePlayerAmetrineValues();
    }


    @SubscribeEvent
    private static void loadClientValues(ClientPlayerNetworkEvent.LoggingOut event) {
        MUConfigHelper.updatePeridotValues(MUConfigHelper.getPlayerPeridotCache());
        MUConfigHelper.updateTopazValues(MUConfigHelper.getPlayerTopazCache());
        MUConfigHelper.updateAquamarineValues(MUConfigHelper.getPlayerAquamarineCache());
        MUConfigHelper.updateSapphireValues(MUConfigHelper.getPlayerSapphireCache());
        MUConfigHelper.updateRubyValues(MUConfigHelper.getPlayerRubyCache());
        MUConfigHelper.updateJadeValues(MUConfigHelper.getPlayerJadePacket());
        MUConfigHelper.updateAmetrineValues(MUConfigHelper.getPlayerAmetrinePacket());
    }
}
