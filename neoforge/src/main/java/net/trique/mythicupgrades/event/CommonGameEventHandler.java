package net.trique.mythicupgrades.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.util.CommonFunctions;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class CommonGameEventHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
        event.setAmount(CommonFunctions.getIncomingDamage(event.getAmount(),event.getEntity(),event.getSource()));
    }
}
