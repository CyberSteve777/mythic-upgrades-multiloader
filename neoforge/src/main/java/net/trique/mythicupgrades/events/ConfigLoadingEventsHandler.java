package net.trique.mythicupgrades.events;


import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.networking.packet.config.*;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ConfigLoadingEventsHandler {
    @SubscribeEvent
    public static void updateValues(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec().equals(MUConfig.CONFIG_SPEC)) {
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
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server != null && server.isDedicatedServer()) {
                PacketDistributor.sendToAllPlayers(aquamarineConfigPacket);
                PacketDistributor.sendToAllPlayers(topazConfigPacket);
                PacketDistributor.sendToAllPlayers(peridotConfigPacket);
                PacketDistributor.sendToAllPlayers(rubyConfigPacket);
                PacketDistributor.sendToAllPlayers(sapphireConfigPacket);
                PacketDistributor.sendToAllPlayers(jadeConfigPacket);
                PacketDistributor.sendToAllPlayers(ametrineConfigPacket);
            }
        }
    }
}
