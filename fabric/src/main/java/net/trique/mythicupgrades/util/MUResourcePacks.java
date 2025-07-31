package net.trique.mythicupgrades.util;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.Optional;

public class MUResourcePacks {
    private static void registerResourcePack(ModContainer container, String id) {
        Constants.LOGGER.info("Registering resource pack {}...", id);
        boolean result = ResourceManagerHelper.registerBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id), container,
                Component.translatable("pack." + Constants.MOD_ID + "." + id), ResourcePackActivationType.NORMAL);
        if (result){
            Constants.LOGGER.info("Successfully registered resource pack {}.", id);
        } else
            Constants.LOGGER.warn("Failed to register resource pack {}.", id);
    }


    public static void addPacks() {
        Optional<ModContainer> container = FabricLoader.getInstance().getModContainer(Constants.MOD_ID);
        container.ifPresent(modContainer -> registerResourcePack(modContainer, "32x"));
    }
}
