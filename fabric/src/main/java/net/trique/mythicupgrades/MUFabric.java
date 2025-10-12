package net.trique.mythicupgrades;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeModConfigEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.config.ModConfig;
import net.trique.mythicupgrades.attachments.CommonDataAttachments;
import net.trique.mythicupgrades.networking.packet.PacketHandler;
import net.trique.mythicupgrades.networking.packet.S2CConfigFilePayload;
import net.trique.mythicupgrades.platform.FabricPlatformHelper;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.util.MULootTableModifiers;
import net.trique.mythicupgrades.util.MUResourcePacks;
import net.trique.mythicupgrades.util.MinecraftServerInstance;
import net.trique.mythicupgrades.worldgen.MUFeatureGeneration;

import java.io.IOException;
import java.nio.file.Files;

import static net.trique.mythicupgrades.config.MUConfig.*;

public class MUFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.SERVER, CONFIG_SPEC);

        Constants.LOGGER.info("Hello Fabric world!");
        MUCommon.init();
        MinecraftServerInstance.registerLifecycleEvents();
        MUFeatureGeneration.generateFeatures();
        MULootTableModifiers.modifyLootTables();
        MUResourcePacks.addPacks();
        setupSyncOnChange();
        setupSyncOnJoin();
        CommonDataAttachments.init();
        PacketHandler.registerPackets();
    }

    public static void setupSyncOnChange() {
        NeoForgeModConfigEvents.reloading(Constants.MOD_ID).register((config) -> {
            if (config.getSpec().equals(CONFIG_SPEC)) {
                Services.PLATFORM.sendSyncedConfig(MinecraftServerInstance.getInstance());
            }
        });
    }

    public static void setupSyncOnJoin() {
        ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) -> {
            if (server != null) {
                ServerPlayer player = handler.getPlayer();
                try {
                    ServerPlayNetworking.send(player, new S2CConfigFilePayload(FabricPlatformHelper.SYNCABLE_CONFIG.getFileName()
                            , Files.readAllBytes(FabricPlatformHelper.SYNCABLE_CONFIG.getFullPath())));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
    }
}
