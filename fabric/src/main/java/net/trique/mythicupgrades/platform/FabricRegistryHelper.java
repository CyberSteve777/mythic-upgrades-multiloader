package net.trique.mythicupgrades.platform;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.platform.services.IRegistryHelper;

import static net.trique.mythicupgrades.block.MUBlocks.*;
import static net.trique.mythicupgrades.item.MUItems.*;
import static net.trique.mythicupgrades.registry.RegisterMUItems.ALL_ITEMS;
import static net.trique.mythicupgrades.registry.RegisterMUItems.MICS;
import static net.trique.mythicupgrades.registry.RegisterMUItems.TOOLS;
import static net.trique.mythicupgrades.registry.RegisterMUEffects.ALL_EFFECTS;

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public void registerBlocks() {
        ALL_BLOCKS.forEach((key, value) -> Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(Constants.MOD_ID, key), value));
    }

    @Override
    public void registerItems() {
        ALL_ITEMS.forEach((key, value)-> Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(Constants.MOD_ID, key), value));
        BLOCK_ITEMS.forEach((key, value)-> Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(Constants.MOD_ID, key), value));

        CreativeModeTab MYTHICTOOLSGROUP = FabricItemGroup.builder().title(Component.literal("Mythic Upgrades: Combat & Tools"))
                .icon(() -> new ItemStack(JADE_AXE)).displayItems((displayContext, entries) -> TOOLS.forEach(entries::accept)).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythictoolsgroup"), MYTHICTOOLSGROUP);

        CreativeModeTab MYTHICMISCGROUP = FabricItemGroup.builder().title(Component.literal("Mythic Upgrades: Misc"))
                .icon(() -> new ItemStack(JADE)).displayItems((displayContext, entries) -> MICS.forEach(entries::accept)).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythicmiscgroup"), MYTHICMISCGROUP);

        CreativeModeTab MYTHICBLOCKGROUP = FabricItemGroup.builder().title(Component.literal("Mythic Upgrades: Blocks"))
                .icon(() -> new ItemStack(JADE_BLOCK)).displayItems((displayContext, entries) -> BLOCKS_ORDER.forEach(entries::accept)).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythicblockgroup"), MYTHICBLOCKGROUP);

    }

    @Override
    public void registerEffects() {
        ALL_EFFECTS.forEach((key, value) -> Registry.register(BuiltInRegistries.MOB_EFFECT,
                new ResourceLocation(Constants.MOD_ID, key), value));
    }
}
