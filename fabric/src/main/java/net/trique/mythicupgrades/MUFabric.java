package net.trique.mythicupgrades;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeModConfigEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.config.ModConfig;
import net.trique.mythicupgrades.networking.packet.config.*;
import net.trique.mythicupgrades.networking.packet.particle.PercentAnimationPacket;
import net.trique.mythicupgrades.util.MULootTableModifiers;
import net.trique.mythicupgrades.util.MUResourcePacks;
import net.trique.mythicupgrades.util.MinecraftServerInstance;
import net.trique.mythicupgrades.worldgen.MUFeatureGeneration;

import static net.trique.mythicupgrades.config.MUConfig.*;

public class MUFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, CONFIG_SPEC);

        Constants.LOGGER.info("Hello Fabric world!");
        MUCommon.init();
        MinecraftServerInstance.initialize();
        MUFeatureGeneration.generateFeatures();
        MULootTableModifiers.modifyLootTables();
        MUResourcePacks.addPacks();
        PayloadTypeRegistry.playS2C().register(PercentAnimationPacket.TYPE, PercentAnimationPacket.CODEC);

        PayloadTypeRegistry.playS2C().register(AquamarineConfigPacket.TYPE, AquamarineConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(TopazConfigPacket.TYPE, TopazConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(PeridotConfigPacket.TYPE, PeridotConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(SapphireConfigPacket.TYPE, SapphireConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(RubyConfigPacket.TYPE, RubyConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(AmetrineConfigPacket.TYPE, AmetrineConfigPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(JadeConfigPacket.TYPE, JadeConfigPacket.CODEC);

        setupSyncOnChange();
        setupSyncOnJoin();
    }

    public static void setupSyncOnChange() {
        NeoForgeModConfigEvents.reloading(Constants.MOD_ID).register((config) -> {
            if (config.getSpec().equals(CONFIG_SPEC)) {
                MinecraftServer server = MinecraftServerInstance.getInstance();
                if (server != null) {
                    for (ServerPlayer player: PlayerLookup.all(server)) {
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
                        ServerPlayNetworking.send(player, peridotConfigPacket);
                        ServerPlayNetworking.send(player, aquamarineConfigPacket);
                        ServerPlayNetworking.send(player, topazConfigPacket);
                        ServerPlayNetworking.send(player, sapphireConfigPacket);
                        ServerPlayNetworking.send(player, rubyConfigPacket);
                        ServerPlayNetworking.send(player, ametrineConfigPacket);
                        ServerPlayNetworking.send(player, jadeConfigPacket);
                    }
                }
            }
        });
    }

    public static void setupSyncOnJoin() {
        ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
            if (server != null) {
                ServerPlayer player = handler.getPlayer();
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
                ServerPlayNetworking.send(player, peridotConfigPacket);
                ServerPlayNetworking.send(player, aquamarineConfigPacket);
                ServerPlayNetworking.send(player, topazConfigPacket);
                ServerPlayNetworking.send(player, sapphireConfigPacket);
                ServerPlayNetworking.send(player, rubyConfigPacket);
                ServerPlayNetworking.send(player, ametrineConfigPacket);
                ServerPlayNetworking.send(player, jadeConfigPacket);
            }
        }));
    }
}
