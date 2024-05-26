package net.trique.mythicupgrades.registry;


import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.trique.mythicupgrades.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static net.trique.mythicupgrades.Constants.MOD_ID;
import static net.trique.mythicupgrades.block.MUBlocks.*;
import static net.trique.mythicupgrades.item.MUItems.*;


public class RegisterMUItems {
    private static final HashMap<String, Item> ALL_ITEMS = new HashMap<>();

    private static <T extends Item> void addItem(String name, T item) {
        ALL_ITEMS.put(name, item);
    }

    private static void registerItem(Map.Entry<String, Item> entry) {
        String name = entry.getKey();
        Item item = entry.getValue();
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
    }

    private static void registerMUItems() {
        addItem("aquamarine_helmet", AQUAMARINE_HELMET);
        addItem("aquamarine_chestplate", AQUAMARINE_CHESTPLATE);
        addItem("aquamarine_leggings", AQUAMARINE_LEGGINGS);
        addItem("aquamarine_boots", AQUAMARINE_BOOTS);
        addItem("aquamarine", AQUAMARINE);
        addItem("aquamarine_ingot", AQUAMARINE_INGOT);
        addItem("aquamarine_crystal_shard", AQUAMARINE_CRYSTAL_SHARD);
        addItem("aquamarine_potion", AQUAMARINE_POTION);
        addItem("aquamarine_upgrade_smithing_template", AQUAMARINE_UPGRADE_SMITHING_TEMPLATE);

        addItem("citrine_axe", CITRINE_AXE);
        addItem("citrine_sword", CITRINE_SWORD);
        addItem("citrine_helmet", CITRINE_HELMET);
        addItem("citrine_chestplate", CITRINE_CHESTPLATE);
        addItem("citrine_leggings", CITRINE_LEGGINGS);
        addItem("citrine_boots", CITRINE_BOOTS);
        addItem("citrine", CITRINE);
        addItem("citrine_ingot", CITRINE_INGOT);
        addItem("citrine_crystal_shard", CITRINE_CRYSTAL_SHARD);
        addItem("citrine_potion", CITRINE_POTION);
        addItem("citrine_upgrade_smithing_template", CITRINE_UPGRADE_SMITHING_TEMPLATE);

        addItem("peridot_axe", PERIDOT_AXE);
        addItem("peridot_sword", PERIDOT_SWORD);
        addItem("peridot_helmet", PERIDOT_HELMET);
        addItem("peridot_chestplate", PERIDOT_CHESTPLATE);
        addItem("peridot_leggings", PERIDOT_LEGGINGS);
        addItem("peridot_boots", PERIDOT_BOOTS);
        addItem("peridot", PERIDOT);
        addItem("peridot_ingot", PERIDOT_INGOT);
        addItem("peridot_crystal_shard", PERIDOT_CRYSTAL_SHARD);
        addItem("peridot_potion", PERIDOT_POTION);
        addItem("peridot_upgrade_smithing_template", PERIDOT_UPGRADE_SMITHING_TEMPLATE);

        addItem("zircon_helmet", ZIRCON_HELMET);
        addItem("zircon_chestplate", ZIRCON_CHESTPLATE);
        addItem("zircon_leggings", ZIRCON_LEGGINGS);
        addItem("zircon_boots", ZIRCON_BOOTS);
        addItem("zircon_axe", ZIRCON_AXE);
        addItem("zircon_sword", ZIRCON_SWORD);
        addItem("zircon", ZIRCON);
        addItem("zircon_ingot", ZIRCON_INGOT);
        addItem("zircon_crystal_shard", ZIRCON_CRYSTAL_SHARD);
        addItem("zircon_potion", ZIRCON_POTION);
        addItem("zircon_upgrade_smithing_template", ZIRCON_UPGRADE_SMITHING_TEMPLATE);

        addItem("ruby_shovel", RUBY_SHOVEL);
        addItem("ruby_axe", RUBY_AXE);
        addItem("ruby_pickaxe", RUBY_PICKAXE);
        addItem("ruby_hoe", RUBY_HOE);
        addItem("ruby", RUBY);
        addItem("ruby_ingot", RUBY_INGOT);
        addItem("ruby_crystal_shard", RUBY_CRYSTAL_SHARD);
        addItem("ruby_potion", RUBY_POTION);
        addItem("ruby_upgrade_smithing_template", RUBY_UPGRADE_SMITHING_TEMPLATE);

        addItem("sapphire_helmet", SAPPHIRE_HELMET);
        addItem("sapphire_chestplate", SAPPHIRE_CHESTPLATE);
        addItem("sapphire_leggings", SAPPHIRE_LEGGINGS);
        addItem("sapphire_boots", SAPPHIRE_BOOTS);
        addItem("sapphire_axe", SAPPHIRE_AXE);
        addItem("sapphire_sword", SAPPHIRE_SWORD);
        addItem("sapphire", SAPPHIRE);
        addItem("sapphire_ingot", SAPPHIRE_INGOT);
        addItem("sapphire_crystal_shard", SAPPHIRE_CRYSTAL_SHARD);
        addItem("sapphire_potion", SAPPHIRE_POTION);
        addItem("sapphire_upgrade_smithing_template", SAPPHIRE_UPGRADE_SMITHING_TEMPLATE);

        addItem("topaz_shovel", TOPAZ_SHOVEL);
        addItem("topaz_pickaxe", TOPAZ_PICKAXE);
        addItem("topaz_axe", TOPAZ_AXE);
        addItem("topaz_hoe", TOPAZ_HOE);
        addItem("topaz_sword", TOPAZ_SWORD);
        addItem("topaz_helmet", TOPAZ_HELMET);
        addItem("topaz_chestplate", TOPAZ_CHESTPLATE);
        addItem("topaz_leggings", TOPAZ_LEGGINGS);
        addItem("topaz_boots", TOPAZ_BOOTS);
        addItem("topaz", TOPAZ);
        addItem("topaz_ingot", TOPAZ_INGOT);
        addItem("topaz_crystal_shard", TOPAZ_CRYSTAL_SHARD);
        addItem("topaz_potion", TOPAZ_POTION);
        addItem("topaz_upgrade_smithing_template", TOPAZ_UPGRADE_SMITHING_TEMPLATE);

        addItem("ametrine_axe", AMETRINE_AXE);
        addItem("ametrine_sword", AMETRINE_SWORD);
        addItem("ametrine_helmet", AMETRINE_HELMET);
        addItem("ametrine_chestplate", AMETRINE_CHESTPLATE);
        addItem("ametrine_leggings", AMETRINE_LEGGINGS);
        addItem("ametrine_boots", AMETRINE_BOOTS);
        addItem("ametrine", AMETRINE);
        addItem("ametrine_ingot", AMETRINE_INGOT);
        addItem("ametrine_crystal_shard", AMETRINE_CRYSTAL_SHARD);
        addItem("ametrine_potion", AMETRINE_POTION);
        addItem("ametrine_upgrade_smithing_template", AMETRINE_UPGRADE_SMITHING_TEMPLATE);

        addItem("jade_axe", JADE_AXE);
        addItem("jade_sword", JADE_SWORD);
        addItem("jade_helmet", JADE_HELMET);
        addItem("jade_chestplate", JADE_CHESTPLATE);
        addItem("jade_leggings", JADE_LEGGINGS);
        addItem("jade_boots", JADE_BOOTS);
        addItem("jade", JADE);
        addItem("jade_ingot", JADE_INGOT);
        addItem("jade_crystal_shard", JADE_CRYSTAL_SHARD);
        addItem("jade_potion", JADE_POTION);
        addItem("jade_upgrade_smithing_template", JADE_UPGRADE_SMITHING_TEMPLATE);

        addItem("raw_necoium", RAW_NECOIUM);
        addItem("necoium_ingot", NECOIUM_INGOT);
        addItem("necoium_nugget", NECOIUM_NUGGET);
        ALL_ITEMS.entrySet().forEach(RegisterMUItems::registerItem);
    }

    private static void registerMUItemGroup() {
        CreativeModeTab MYTHICTOOLSGROUP = CreativeModeTab.builder(null, -1).title(Component.literal("Mythic Upgrades: Combat & Tools"))
                .icon(() -> new ItemStack(JADE_AXE)).displayItems((displayContext, entries) -> {
                    entries.accept(RUBY_SHOVEL);
                    entries.accept(RUBY_PICKAXE);
                    entries.accept(RUBY_AXE);
                    entries.accept(RUBY_HOE);

                    entries.accept(TOPAZ_SHOVEL);
                    entries.accept(TOPAZ_PICKAXE);
                    entries.accept(TOPAZ_AXE);
                    entries.accept(TOPAZ_HOE);
                    entries.accept(TOPAZ_SWORD);
                    entries.accept(TOPAZ_HELMET);
                    entries.accept(TOPAZ_CHESTPLATE);
                    entries.accept(TOPAZ_LEGGINGS);
                    entries.accept(TOPAZ_BOOTS);

                    entries.accept(CITRINE_AXE);
                    entries.accept(CITRINE_SWORD);
                    entries.accept(CITRINE_HELMET);
                    entries.accept(CITRINE_CHESTPLATE);
                    entries.accept(CITRINE_LEGGINGS);
                    entries.accept(CITRINE_BOOTS);

                    entries.accept(PERIDOT_AXE);
                    entries.accept(PERIDOT_SWORD);
                    entries.accept(PERIDOT_HELMET);
                    entries.accept(PERIDOT_CHESTPLATE);
                    entries.accept(PERIDOT_LEGGINGS);
                    entries.accept(PERIDOT_BOOTS);

                    entries.accept(JADE_AXE);
                    entries.accept(JADE_SWORD);
                    entries.accept(JADE_HELMET);
                    entries.accept(JADE_CHESTPLATE);
                    entries.accept(JADE_LEGGINGS);
                    entries.accept(JADE_BOOTS);

                    entries.accept(AQUAMARINE_HELMET);
                    entries.accept(AQUAMARINE_CHESTPLATE);
                    entries.accept(AQUAMARINE_LEGGINGS);
                    entries.accept(AQUAMARINE_BOOTS);

                    entries.accept(ZIRCON_AXE);
                    entries.accept(ZIRCON_SWORD);
                    entries.accept(ZIRCON_HELMET);
                    entries.accept(ZIRCON_CHESTPLATE);
                    entries.accept(ZIRCON_LEGGINGS);
                    entries.accept(ZIRCON_BOOTS);

                    entries.accept(SAPPHIRE_AXE);
                    entries.accept(SAPPHIRE_SWORD);
                    entries.accept(SAPPHIRE_HELMET);
                    entries.accept(SAPPHIRE_CHESTPLATE);
                    entries.accept(SAPPHIRE_LEGGINGS);
                    entries.accept(SAPPHIRE_BOOTS);

                    entries.accept(AMETRINE_AXE);
                    entries.accept(AMETRINE_SWORD);
                    entries.accept(AMETRINE_HELMET);
                    entries.accept(AMETRINE_CHESTPLATE);
                    entries.accept(AMETRINE_LEGGINGS);
                    entries.accept(AMETRINE_BOOTS);
                }).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythictoolsgroup"), MYTHICTOOLSGROUP);

        CreativeModeTab MYTHICMISCGROUP = CreativeModeTab.builder(null, -1).title(Component.literal("Mythic Upgrades: Misc"))
                .icon(() -> new ItemStack(JADE)).displayItems((displayContext, entries) -> {
                    entries.accept(RUBY);
                    entries.accept(RUBY_INGOT);
                    entries.accept(RUBY_CRYSTAL_SHARD);
                    entries.accept(RUBY_POTION);
                    entries.accept(RUBY_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(TOPAZ);
                    entries.accept(TOPAZ_INGOT);
                    entries.accept(TOPAZ_CRYSTAL_SHARD);
                    entries.accept(TOPAZ_POTION);
                    entries.accept(TOPAZ_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(CITRINE);
                    entries.accept(CITRINE_INGOT);
                    entries.accept(CITRINE_CRYSTAL_SHARD);
                    entries.accept(CITRINE_POTION);
                    entries.accept(CITRINE_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(PERIDOT);
                    entries.accept(PERIDOT_INGOT);
                    entries.accept(PERIDOT_CRYSTAL_SHARD);
                    entries.accept(PERIDOT_POTION);
                    entries.accept(PERIDOT_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(JADE);
                    entries.accept(JADE_INGOT);
                    entries.accept(JADE_CRYSTAL_SHARD);
                    entries.accept(JADE_POTION);
                    entries.accept(JADE_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(AQUAMARINE);
                    entries.accept(AQUAMARINE_INGOT);
                    entries.accept(AQUAMARINE_CRYSTAL_SHARD);
                    entries.accept(AQUAMARINE_POTION);
                    entries.accept(AQUAMARINE_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(ZIRCON);
                    entries.accept(ZIRCON_INGOT);
                    entries.accept(ZIRCON_CRYSTAL_SHARD);
                    entries.accept(ZIRCON_POTION);
                    entries.accept(ZIRCON_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(SAPPHIRE);
                    entries.accept(SAPPHIRE_INGOT);
                    entries.accept(SAPPHIRE_CRYSTAL_SHARD);
                    entries.accept(SAPPHIRE_POTION);
                    entries.accept(SAPPHIRE_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(AMETRINE);
                    entries.accept(AMETRINE_INGOT);
                    entries.accept(AMETRINE_CRYSTAL_SHARD);
                    entries.accept(AMETRINE_POTION);
                    entries.accept(AMETRINE_UPGRADE_SMITHING_TEMPLATE);

                    entries.accept(RAW_NECOIUM);
                    entries.accept(NECOIUM_INGOT);
                    entries.accept(NECOIUM_NUGGET);
                }).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythicmiscgroup"), MYTHICMISCGROUP);

        CreativeModeTab MYTHICBLOCKGROUP = CreativeModeTab.builder(null, -1).title(Component.literal("Mythic Upgrades: Blocks"))
                .icon(() -> new ItemStack(JADE_BLOCK)).displayItems((displayContext, entries) -> {
                    entries.accept(RUBY_BLOCK);
                    entries.accept(RUBY_ORE);
                    entries.accept(RUBY_CRYSTAL_BLOCK);
                    entries.accept(RUBY_CRYSTAL_CLUSTER);

                    entries.accept(TOPAZ_BLOCK);
                    entries.accept(TOPAZ_ORE);
                    entries.accept(TOPAZ_CRYSTAL_BLOCK);
                    entries.accept(TOPAZ_CRYSTAL_CLUSTER);

                    entries.accept(CITRINE_BLOCK);
                    entries.accept(CITRINE_ORE);
                    entries.accept(DEEPSLATE_CITRINE_ORE);
                    entries.accept(CITRINE_CRYSTAL_BLOCK);
                    entries.accept(CITRINE_CRYSTAL_CLUSTER);

                    entries.accept(PERIDOT_BLOCK);
                    entries.accept(PERIDOT_ORE);
                    entries.accept(DEEPSLATE_PERIDOT_ORE);
                    entries.accept(PERIDOT_CRYSTAL_BLOCK);
                    entries.accept(PERIDOT_CRYSTAL_CLUSTER);

                    entries.accept(JADE_BLOCK);
                    entries.accept(JADE_ORE);
                    entries.accept(JADE_CRYSTAL_BLOCK);
                    entries.accept(JADE_CRYSTAL_CLUSTER);

                    entries.accept(AQUAMARINE_BLOCK);
                    entries.accept(AQUAMARINE_ORE);
                    entries.accept(DEEPSLATE_AQUAMARINE_ORE);
                    entries.accept(AQUAMARINE_CRYSTAL_BLOCK);
                    entries.accept(AQUAMARINE_CRYSTAL_CLUSTER);

                    entries.accept(ZIRCON_BLOCK);
                    entries.accept(ZIRCON_ORE);
                    entries.accept(DEEPSLATE_ZIRCON_ORE);
                    entries.accept(ZIRCON_CRYSTAL_BLOCK);
                    entries.accept(ZIRCON_CRYSTAL_CLUSTER);

                    entries.accept(SAPPHIRE_BLOCK);
                    entries.accept(SAPPHIRE_ORE);
                    entries.accept(SAPPHIRE_CRYSTAL_BLOCK);
                    entries.accept(SAPPHIRE_CRYSTAL_CLUSTER);

                    entries.accept(AMETRINE_BLOCK);
                    entries.accept(AMETRINE_ORE);
                    entries.accept(AMETRINE_CRYSTAL_BLOCK);
                    entries.accept(AMETRINE_CRYSTAL_CLUSTER);

                    entries.accept(RAW_NECOIUM_BLOCK);
                    entries.accept(NECOIUM_BLOCK);
                    entries.accept(NECOIUM_ORE);
                }).build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Constants.MOD_ID, "mythicblockgroup"), MYTHICBLOCKGROUP);
    }

    public static void registerMythicItems() {
        registerMUItems();
        registerMUItemGroup();
        Constants.LOG.info("Registering Mythic Items for " + MOD_ID);
    }
}