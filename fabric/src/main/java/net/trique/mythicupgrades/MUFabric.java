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
import net.trique.mythicupgrades.networking.packet.MUConfigPacket;
import net.trique.mythicupgrades.networking.packet.PercentAnimationPacket;
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
        MinecraftServerInstance.registerLifecycleEvents();
        MUFeatureGeneration.generateFeatures();
        MULootTableModifiers.modifyLootTables();
        MUResourcePacks.addPacks();
        PayloadTypeRegistry.playS2C().register(PercentAnimationPacket.TYPE, PercentAnimationPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(MUConfigPacket.TYPE, MUConfigPacket.CODEC);
        setupSyncOnChange();
        setupSyncOnJoin();
    }

    public static void setupSyncOnChange() {
        NeoForgeModConfigEvents.reloading(Constants.MOD_ID).register((config) -> {
            if (config.getSpec().equals(CONFIG_SPEC)) {
                MinecraftServer server = MinecraftServerInstance.getInstance();
                if (server != null) {
                    for (ServerPlayer player: PlayerLookup.all(server)) {
                        MUConfigPacket packet = new MUConfigPacket(CONFIG);
                        ServerPlayNetworking.send(player, packet);
                    }
                }
            }
        });
    }

    public static void setupSyncOnJoin() {
        ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
            if (server != null) {
                ServerPlayer player = handler.getPlayer();
                MUConfigPacket packet = new MUConfigPacket(CONFIG);
                ServerPlayNetworking.send(player, packet);
            }
        }));
    }
}
