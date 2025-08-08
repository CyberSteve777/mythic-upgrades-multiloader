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
        AmetrineClientConfigPacket ametrineClientConfigPacket = new AmetrineClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_levitation_duration.get(),
                CONFIG.tools_levitation_amplifier.get(),
                CONFIG.arcane_aura_levitation_duration.get(),
                CONFIG.arcane_aura_amplifier.get()
        );
        JadeClientConfigPacket jadeClientConfigPacket = new JadeClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_bouncer_jump_boost_duration.get(),
                CONFIG.tools_bouncer_amplifier.get(),
                CONFIG.speed_amplifier.get(),
                CONFIG.jump_boost_amplifier.get()
        );
        RubyClientConfigPacket rubyClientConfigPacket = new RubyClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_haste_amplifier.get(),
                CONFIG.spelunker_amplifier.get()
        );
        SapphireClientConfigPacket sapphireClientConfigPacket = new SapphireClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_percentage_damage_percent.get(),
                CONFIG.damage_deflection_amplifier.get()
        );
        TopazClientConfigPacket topazClientConfigPacket = new TopazClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.topaz_tools_fire_seconds.get(),
                CONFIG.item_mastery_amplifier.get()
        );
        AquamarineClientConfigPacket aquamarineClientConfigPacket = new AquamarineClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_freeze_duration.get(),
                CONFIG.ice_shield_slowness_duration.get(),
                CONFIG.ice_shield_amplifier.get()
        );
        PeridotClientConfigPacket peridotClientConfigPacket = new PeridotClientConfigPacket(
                event.getPlayer().getUUID(),
                CONFIG.tools_effects_amplifier.get(),
                CONFIG.tools_poison_duration.get(),
                CONFIG.tools_nausea_duration.get(),
                CONFIG.poisonous_thorns_amplifier.get(),
                CONFIG.poisonous_thorns_poison_duration.get(),
                CONFIG.poisonous_thorns_nausea_duration.get()
        );
        PacketDistributor.sendToServer(peridotClientConfigPacket, topazClientConfigPacket,
                aquamarineClientConfigPacket, sapphireClientConfigPacket, rubyClientConfigPacket,
                ametrineClientConfigPacket, jadeClientConfigPacket);
    }
}
