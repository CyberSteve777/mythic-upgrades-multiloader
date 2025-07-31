package net.trique.mythicupgrades.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.item.materials.MUArmorMaterials;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.item.misc.MUTemplateItem;
import net.trique.mythicupgrades.item.mythic_impl.common.*;
import net.trique.mythicupgrades.item.mythic_impl.sapphire.*;
import net.trique.mythicupgrades.item.potion.MUPotions;
import net.trique.mythicupgrades.item.potion.MythicPotionItem;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;
import net.trique.mythicupgrades.util.ItemEffectsList;

import java.util.ArrayList;
import java.util.List;

public class ItemRegistry {

    public static void init() {
        Constants.LOGGER.info("Registering items for mythic upgrades");

    }

    private static final ItemEffectsList emptyItemEffectsList = new ItemEffectsList();
    private static final List<Integer> emptyItemEffectsAplifiersList = new ArrayList<>();

    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);

    public static final RegistryObject<Item, Item> AMETRINE = ITEMS.register("ametrine", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> AMETRINE_INGOT = ITEMS.register("ametrine_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> AMETRINE_CRYSTAL_SHARD = ITEMS.register("ametrine_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> AMETRINE_POTION = ITEMS.register("ametrine_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getAmetrinePotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> AQUAMARINE = ITEMS.register("aquamarine", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> AQUAMARINE_INGOT = ITEMS.register("aquamarine_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> AQUAMARINE_CRYSTAL_SHARD = ITEMS.register("aquamarine_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> AQUAMARINE_POTION = ITEMS.register("aquamarine_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getAquamarinePotion()).stacksTo(16)));


    public static final RegistryObject<Item, Item> JADE = ITEMS.register("jade", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> JADE_CRYSTAL_SHARD = ITEMS.register("jade_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> JADE_POTION = ITEMS.register("jade_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getJadePotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> PERIDOT = ITEMS.register("peridot", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> PERIDOT_INGOT = ITEMS.register("peridot_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> PERIDOT_CRYSTAL_SHARD = ITEMS.register("peridot_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> PERIDOT_POTION = ITEMS.register("peridot_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getPeridotPotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> RUBY = ITEMS.register("ruby", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> RUBY_INGOT = ITEMS.register("ruby_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> RUBY_CRYSTAL_SHARD = ITEMS.register("ruby_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> RUBY_POTION = ITEMS.register("ruby_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getRubyPotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> SAPPHIRE_INGOT = ITEMS.register("sapphire_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> SAPPHIRE_CRYSTAL_SHARD = ITEMS.register("sapphire_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> SAPPHIRE_POTION = ITEMS.register("sapphire_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getSapphirePotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> TOPAZ = ITEMS.register("topaz", () -> new Item(getItemProperties()));
    public static final RegistryObject<Item, Item> TOPAZ_INGOT = ITEMS.register("topaz_ingot", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> TOPAZ_CRYSTAL_SHARD = ITEMS.register("topaz_crystal_shard", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, MythicPotionItem> TOPAZ_POTION = ITEMS.register("topaz_potion", () ->
            new MythicPotionItem(getFireResistantProperties().food(MUPotions.getTopazPotion()).stacksTo(16)));

    public static final RegistryObject<Item, Item> RAW_NECOIUM = ITEMS.register("raw_necoium", () -> new Item(getFireResistantProperties()));
    public static final RegistryObject<Item, Item> NECOIUM_INGOT = ITEMS.register("necoium_ingot", () -> new Item(getFireResistantProperties()));


    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_HELMET = ITEMS.register("aquamarine_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "aquamarine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_CHESTPLATE = ITEMS.register("aquamarine_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "aquamarine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_LEGGINGS = ITEMS.register("aquamarine_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "aquamarine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_BOOTS = ITEMS.register("aquamarine_boots", () ->  new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "aquamarine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsShovelItem> AQUAMARINE_SHOVEL = ITEMS.register("aquamarine_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.AQUAMARINE, 2, -2.9f)), emptyItemEffectsList, "aquamarine_tool.description", ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> AQUAMARINE_PICKAXE = ITEMS.register("aquamarine_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.AQUAMARINE, 1, -2.7f)), emptyItemEffectsList, "aquamarine_tool.description", ChatFormatting.AQUA)) ;
    public static final RegistryObject<Item, MythicEffectsAxeItem> AQUAMARINE_AXE = ITEMS.register("aquamarine_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.AQUAMARINE, 5, -2.9f)), emptyItemEffectsList, "aquamarine_tool.description", ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsHoeItem> AQUAMARINE_HOE = ITEMS.register("aquamarine_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.AQUAMARINE, -4, 0.1f)), emptyItemEffectsList, "aquamarine_tool.description", ChatFormatting.AQUA));
    public static final RegistryObject<Item, MythicEffectsSwordItem> AQUAMARINE_SWORD = ITEMS.register("aquamarine_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.AQUAMARINE, 3, -2.3f)), emptyItemEffectsList, "aquamarine_tool.description", ChatFormatting.AQUA));

    public static final RegistryObject<Item, MythicEffectsShovelItem> PERIDOT_SHOVEL = ITEMS.register("peridot_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.PERIDOT, 2, -2.9f)), emptyItemEffectsList, "peridot_tool.description", ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> PERIDOT_PICKAXE = ITEMS.register("peridot_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.PERIDOT, 1, -2.7f)), emptyItemEffectsList, "peridot_tool.description", ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsHoeItem> PERIDOT_HOE = ITEMS.register("peridot_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.PERIDOT, -4, 0.1f)), emptyItemEffectsList, "peridot_tool.description", ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsAxeItem> PERIDOT_AXE = ITEMS.register("peridot_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.PERIDOT, 5, -2.9f)), emptyItemEffectsList, "peridot_tool.description", ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsSwordItem> PERIDOT_SWORD = ITEMS.register("peridot_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.PERIDOT, 3, -2.3f)), emptyItemEffectsList, "peridot_tool.description", ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_HELMET = ITEMS.register("peridot_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "peridot_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_CHESTPLATE = ITEMS.register("peridot_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "peridot_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_LEGGINGS = ITEMS.register("peridot_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "peridot_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_BOOTS = ITEMS.register("peridot_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "peridot_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GREEN));

    public static final RegistryObject<Item, MythicEffectsShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.RUBY, 2, -2.1f)), emptyItemEffectsList, "ruby_tool.description", ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.RUBY, 1, -1.9f)), emptyItemEffectsList, "ruby_tool.description", ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsAxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.RUBY, 5, -2.1f)), emptyItemEffectsList, "ruby_tool.description", ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsHoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.RUBY, -4, 0.9f)), emptyItemEffectsList, "ruby_tool.description", ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsSwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.RUBY, 3, -1.5f)), emptyItemEffectsList, "ruby_tool.description", ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "ruby_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "ruby_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "ruby_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.RED));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "ruby_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.RED));

    public static final RegistryObject<Item, SapphireHoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoeItem(5, getFireResistantProperties().attributes(SapphireHoeItem.createAttributes(MUToolMaterials.SAPPHIRE, -4, 0.1f)), emptyItemEffectsList, "sapphire_tool.description", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, SapphireShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovelItem(5, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.SAPPHIRE, 2, -2.9f)), emptyItemEffectsList, "sapphire_tool.description", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, SapphirePickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxeItem(5, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.SAPPHIRE, 1, -2.7f)), emptyItemEffectsList, "sapphire_tool.description", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, SapphireAxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxeItem(5, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.SAPPHIRE, 5, -2.9f)), emptyItemEffectsList, "sapphire_tool.description", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, SapphireSwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSwordItem(5, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.SAPPHIRE, 3, -2.3f)), emptyItemEffectsList, "sapphire_tool.description", ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "sapphire_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "sapphire_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "sapphire_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_BLUE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "sapphire_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_BLUE));

    public static final RegistryObject<Item, MythicEffectsShovelItem> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.TOPAZ, 2, -2.9f)), emptyItemEffectsList, "topaz_tool.description", ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.TOPAZ, 1, -2.7f)), emptyItemEffectsList, "topaz_tool.description", ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsAxeItem> TOPAZ_AXE = ITEMS.register("topaz_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.TOPAZ, 5, -2.9f)), emptyItemEffectsList, "topaz_tool.description", ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsHoeItem> TOPAZ_HOE = ITEMS.register("topaz_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.TOPAZ, -4, 0.1f)), emptyItemEffectsList, "topaz_tool.description", ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsSwordItem> TOPAZ_SWORD = ITEMS.register("topaz_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.TOPAZ, 3, -2.3f)), emptyItemEffectsList, "topaz_tool.description", ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_HELMET = ITEMS.register("topaz_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "topaz_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "topaz_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "topaz_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GOLD));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_BOOTS = ITEMS.register("topaz_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "topaz_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.GOLD));

    public static final RegistryObject<Item, MythicEffectsHoeItem> AMETRINE_HOE = ITEMS.register("ametrine_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.AMETRINE, -4, 0.1f)), emptyItemEffectsList, "ametrine_tool.description", ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsShovelItem> AMETRINE_SHOVEL = ITEMS.register("ametrine_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.AMETRINE, 2, -2.9f)), emptyItemEffectsList, "ametrine_tool.description", ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> AMETRINE_PICKAXE = ITEMS.register("ametrine_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.AMETRINE, 1, -2.7f)), emptyItemEffectsList, "ametrine_tool.description", ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsAxeItem> AMETRINE_AXE = ITEMS.register("ametrine_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.AMETRINE, 5, -2.9f)), emptyItemEffectsList, "ametrine_tool.description", ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsSwordItem> AMETRINE_SWORD = ITEMS.register("ametrine_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.AMETRINE, 3, -2.3f)), emptyItemEffectsList, "ametrine_tool.description", ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_HELMET = ITEMS.register("ametrine_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "ametrine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_CHESTPLATE = ITEMS.register("ametrine_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "ametrine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_LEGGINGS = ITEMS.register("ametrine_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "ametrine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_PURPLE));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_BOOTS = ITEMS.register("ametrine_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "ametrine_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_PURPLE));

    public static final RegistryObject<Item, MythicEffectsShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.JADE, 2, -2.9f)), emptyItemEffectsList, "jade_tool.description", ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.JADE, 1, -2.7f)), emptyItemEffectsList, "jade_tool.description", ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsHoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.JADE, -4, 0.1f)), emptyItemEffectsList, "jade_tool.description", ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsAxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.JADE, 5, -2.9f)), emptyItemEffectsList, "jade_tool.description", ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsSwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.JADE, 3, -2.3f)), emptyItemEffectsList, "jade_tool.description", ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), emptyItemEffectsList, "jade_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), emptyItemEffectsList, "jade_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "jade_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_GREEN));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), emptyItemEffectsList, "jade_armor.description", emptyItemEffectsAplifiersList, ChatFormatting.DARK_GREEN));

    
    public static final RegistryObject<Item, MUTemplateItem> AQUAMARINE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("aquamarine_upgrade_smithing_template", MUTemplateItem::createAquamarineUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> PERIDOT_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("peridot_upgrade_smithing_template", MUTemplateItem::createPeridotUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> RUBY_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ruby_upgrade_smithing_template", MUTemplateItem::createRubyUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> SAPPHIRE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("sapphire_upgrade_smithing_template", MUTemplateItem::createSapphireUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> TOPAZ_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("topaz_upgrade_smithing_template", MUTemplateItem::createTopazUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> AMETRINE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ametrine_upgrade_smithing_template", MUTemplateItem::createAmetrineUpgrade);
    public static final RegistryObject<Item, MUTemplateItem> JADE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("jade_upgrade_smithing_template", MUTemplateItem::createJadeUpgrade);





    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }
    public static Item.Properties getFireResistantProperties() {
        return new Item.Properties().fireResistant();
    }


}
