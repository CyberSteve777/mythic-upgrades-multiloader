package net.trique.mythicupgrades.registry;


import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.trique.mythicupgrades.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.trique.mythicupgrades.Constants.MOD_ID;
import static net.trique.mythicupgrades.block.MUBlocks.*;
import static net.trique.mythicupgrades.item.MUItems.*;


public class RegisterMUItems {
    public static final HashMap<String, Item> ALL_ITEMS = new HashMap<>();
    public static final ArrayList<Item> TOOLS = new ArrayList<>();
    public static final ArrayList<Item> MICS = new ArrayList<>();

    private static <T extends Item> void addItem(String name, T item) {
        ALL_ITEMS.put(name, item);
    }

    private static void registerItem(Map.Entry<String, Item> entry) {
        String name = entry.getKey();
        Item item = entry.getValue();
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
    }


    private static void setTools() {
        TOOLS.add(RUBY_SHOVEL);
        TOOLS.add(RUBY_PICKAXE);
        TOOLS.add(RUBY_AXE);
        TOOLS.add(RUBY_HOE);
        TOOLS.add(TOPAZ_SHOVEL);
        TOOLS.add(TOPAZ_PICKAXE);
        TOOLS.add(TOPAZ_AXE);
        TOOLS.add(TOPAZ_HOE);
        TOOLS.add(TOPAZ_SWORD);
        TOOLS.add(TOPAZ_HELMET);
        TOOLS.add(TOPAZ_CHESTPLATE);
        TOOLS.add(TOPAZ_LEGGINGS);
        TOOLS.add(TOPAZ_BOOTS);
        TOOLS.add(CITRINE_AXE);
        TOOLS.add(CITRINE_SWORD);
        TOOLS.add(CITRINE_HELMET);
        TOOLS.add(CITRINE_CHESTPLATE);
        TOOLS.add(CITRINE_LEGGINGS);
        TOOLS.add(CITRINE_BOOTS);
        TOOLS.add(PERIDOT_AXE);
        TOOLS.add(PERIDOT_SWORD);
        TOOLS.add(PERIDOT_HELMET);
        TOOLS.add(PERIDOT_CHESTPLATE);
        TOOLS.add(PERIDOT_LEGGINGS);
        TOOLS.add(PERIDOT_BOOTS);
        TOOLS.add(JADE_AXE);
        TOOLS.add(JADE_SWORD);
        TOOLS.add(JADE_HELMET);
        TOOLS.add(JADE_CHESTPLATE);
        TOOLS.add(JADE_LEGGINGS);
        TOOLS.add(JADE_BOOTS);
        TOOLS.add(AQUAMARINE_HELMET);
        TOOLS.add(AQUAMARINE_CHESTPLATE);
        TOOLS.add(AQUAMARINE_LEGGINGS);
        TOOLS.add(AQUAMARINE_BOOTS);
        TOOLS.add(ZIRCON_AXE);
        TOOLS.add(ZIRCON_SWORD);
        TOOLS.add(ZIRCON_HELMET);
        TOOLS.add(ZIRCON_CHESTPLATE);
        TOOLS.add(ZIRCON_LEGGINGS);
        TOOLS.add(ZIRCON_BOOTS);
        TOOLS.add(SAPPHIRE_AXE);
        TOOLS.add(SAPPHIRE_SWORD);
        TOOLS.add(SAPPHIRE_HELMET);
        TOOLS.add(SAPPHIRE_CHESTPLATE);
        TOOLS.add(SAPPHIRE_LEGGINGS);
        TOOLS.add(SAPPHIRE_BOOTS);
        TOOLS.add(AMETRINE_AXE);
        TOOLS.add(AMETRINE_SWORD);
        TOOLS.add(AMETRINE_HELMET);
        TOOLS.add(AMETRINE_CHESTPLATE);
        TOOLS.add(AMETRINE_LEGGINGS);
        TOOLS.add(AMETRINE_BOOTS);
    }

    private static void setMics() {
        MICS.add(RUBY);
        MICS.add(RUBY_INGOT);
        MICS.add(RUBY_CRYSTAL_SHARD);
        MICS.add(RUBY_POTION);
        MICS.add(RUBY_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(TOPAZ);
        MICS.add(TOPAZ_INGOT);
        MICS.add(TOPAZ_CRYSTAL_SHARD);
        MICS.add(TOPAZ_POTION);
        MICS.add(TOPAZ_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(CITRINE);
        MICS.add(CITRINE_INGOT);
        MICS.add(CITRINE_CRYSTAL_SHARD);
        MICS.add(CITRINE_POTION);
        MICS.add(CITRINE_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(PERIDOT);
        MICS.add(PERIDOT_INGOT);
        MICS.add(PERIDOT_CRYSTAL_SHARD);
        MICS.add(PERIDOT_POTION);
        MICS.add(PERIDOT_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(JADE);
        MICS.add(JADE_INGOT);
        MICS.add(JADE_CRYSTAL_SHARD);
        MICS.add(JADE_POTION);
        MICS.add(JADE_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(AQUAMARINE);
        MICS.add(AQUAMARINE_INGOT);
        MICS.add(AQUAMARINE_CRYSTAL_SHARD);
        MICS.add(AQUAMARINE_POTION);
        MICS.add(AQUAMARINE_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(ZIRCON);
        MICS.add(ZIRCON_INGOT);
        MICS.add(ZIRCON_CRYSTAL_SHARD);
        MICS.add(ZIRCON_POTION);
        MICS.add(ZIRCON_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(SAPPHIRE);
        MICS.add(SAPPHIRE_INGOT);
        MICS.add(SAPPHIRE_CRYSTAL_SHARD);
        MICS.add(SAPPHIRE_POTION);
        MICS.add(SAPPHIRE_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(AMETRINE);
        MICS.add(AMETRINE_INGOT);
        MICS.add(AMETRINE_CRYSTAL_SHARD);
        MICS.add(AMETRINE_POTION);
        MICS.add(AMETRINE_UPGRADE_SMITHING_TEMPLATE);

        MICS.add(RAW_NECOIUM);
        MICS.add(NECOIUM_INGOT);
        MICS.add(NECOIUM_NUGGET);
    }



    private static void setMUItemsForRegisrty() {
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
    }

    public static void setMythicItems() {
        setMUItemsForRegisrty();
        setMics();
        setTools();
        Constants.LOG.info("Registering Mythic Items for " + MOD_ID);
    }
}