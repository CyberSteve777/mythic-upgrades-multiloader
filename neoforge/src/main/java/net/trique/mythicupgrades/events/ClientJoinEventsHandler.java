package net.trique.mythicupgrades.events;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.networking.packet.config.*;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientJoinEventsHandler {

    @SubscribeEvent
    private static void sendClientValues(ClientPlayerNetworkEvent.LoggingIn event) {
        AmetrineConfigPacket ametrineConfigPacket = new AmetrineConfigPacket(
                CONFIG.tools_levitation_duration.get(),
                CONFIG.tools_levitation_amplifier.get(),
                CONFIG.arcane_aura_levitation_duration.get(),
                CONFIG.arcane_aura_amplifier.get()
        );
        JadeConfigPacket jadeConfigPacket = new JadeConfigPacket(
                CONFIG.tools_bouncer_jump_boost_duration.get(),
                CONFIG.tools_bouncer_amplifier.get(),
                CONFIG.speed_amplifier.get(),
                CONFIG.jump_boost_amplifier.get()
        );
        RubyConfigPacket rubyConfigPacket = new RubyConfigPacket(
                CONFIG.tools_haste_amplifier.get(),
                CONFIG.spelunker_amplifier.get()
        );
        SapphireConfigPacket sapphireConfigPacket = new SapphireConfigPacket(
                CONFIG.tools_percentage_damage_percent.get(),
                CONFIG.damage_deflection_amplifier.get()
        );
        TopazConfigPacket topazConfigPacket = new TopazConfigPacket(
                CONFIG.topaz_tools_fire_seconds.get(),
                CONFIG.item_mastery_amplifier.get()
        );
        AquamarineConfigPacket aquamarineConfigPacket = new AquamarineConfigPacket(
                CONFIG.tools_freeze_duration.get(),
                CONFIG.ice_shield_slowness_duration.get(),
                CONFIG.ice_shield_amplifier.get()
        );
        PeridotConfigPacket peridotConfigPacket = new PeridotConfigPacket(
                CONFIG.tools_effects_amplifier.get(),
                CONFIG.tools_poison_duration.get(),
                CONFIG.tools_nausea_duration.get(),
                CONFIG.poisonous_thorns_amplifier.get(),
                CONFIG.poisonous_thorns_poison_duration.get(),
                CONFIG.poisonous_thorns_nausea_duration.get()
        );
        PacketDistributor.sendToServer(peridotConfigPacket, aquamarineConfigPacket,
                topazConfigPacket, sapphireConfigPacket, rubyConfigPacket, jadeConfigPacket,
                ametrineConfigPacket);
    }
}
