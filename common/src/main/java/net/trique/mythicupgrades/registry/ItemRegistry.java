package net.trique.mythicupgrades.registry;

import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.MUCommon;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.*;
import net.trique.mythicupgrades.item.materials.MUArmorMaterials;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.item.misc.MUTemplateItem;
import net.trique.mythicupgrades.item.equipment.common.*;
import net.trique.mythicupgrades.item.equipment.sapphire.*;
import net.trique.mythicupgrades.item.misc.potion.MUPotions;
import net.trique.mythicupgrades.item.misc.MythicPotionItem;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;
import net.trique.mythicupgrades.util.CommonFunctions;

import java.util.List;

import static net.minecraft.world.effect.MobEffects.*;
import static net.trique.mythicupgrades.util.MUArmorSets.*;

public class ItemRegistry {

    public static void init() {
        Constants.LOGGER.info("Registering items for mythic upgrades");

    }

    protected static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);

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


    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_HELMET = ITEMS.register("aquamarine_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "aquamarine_armor.description", ItemRegistry::getAquamarineArmorAmplifierList, ChatFormatting.AQUA, AQUAMARINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_CHESTPLATE = ITEMS.register("aquamarine_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "aquamarine_armor.description", ItemRegistry::getAquamarineArmorAmplifierList, ChatFormatting.AQUA, AQUAMARINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_LEGGINGS = ITEMS.register("aquamarine_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "aquamarine_armor.description", ItemRegistry::getAquamarineArmorAmplifierList, ChatFormatting.AQUA, AQUAMARINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AQUAMARINE_BOOTS = ITEMS.register("aquamarine_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.AQUAMARINE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "aquamarine_armor.description", ItemRegistry::getAquamarineArmorAmplifierList, ChatFormatting.AQUA, AQUAMARINE_SET));
    public static final RegistryObject<Item, MythicEffectsShovelItem> AQUAMARINE_SHOVEL = ITEMS.register("aquamarine_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.AQUAMARINE, 2, -2.9f)), "aquamarine_tool.description", ChatFormatting.AQUA, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAquamarineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> AQUAMARINE_PICKAXE = ITEMS.register("aquamarine_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.AQUAMARINE, 1, -2.7f)), "aquamarine_tool.description", ChatFormatting.AQUA, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAquamarineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> AQUAMARINE_AXE = ITEMS.register("aquamarine_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.AQUAMARINE, 5, -2.9f)), "aquamarine_tool.description", ChatFormatting.AQUA, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAquamarineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsHoeItem> AQUAMARINE_HOE = ITEMS.register("aquamarine_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.AQUAMARINE, -4, 0.1f)), "aquamarine_tool.description", ChatFormatting.AQUA, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAquamarineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> AQUAMARINE_SWORD = ITEMS.register("aquamarine_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.AQUAMARINE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.AQUAMARINE, 3, -2.3f)), "aquamarine_tool.description", ChatFormatting.AQUA, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAquamarineToolEffectList));

    public static final RegistryObject<Item, MythicEffectsShovelItem> PERIDOT_SHOVEL = ITEMS.register("peridot_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.PERIDOT, 2, -2.9f)), "peridot_tool.description", ChatFormatting.GREEN, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getPeridotToolEffectList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> PERIDOT_PICKAXE = ITEMS.register("peridot_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.PERIDOT, 1, -2.7f)), "peridot_tool.description", ChatFormatting.GREEN, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getPeridotToolEffectList));
    public static final RegistryObject<Item, MythicEffectsHoeItem> PERIDOT_HOE = ITEMS.register("peridot_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.PERIDOT, -4, 0.1f)), "peridot_tool.description", ChatFormatting.GREEN, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getPeridotToolEffectList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> PERIDOT_AXE = ITEMS.register("peridot_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.PERIDOT, 5, -2.9f)), "peridot_tool.description", ChatFormatting.GREEN, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getPeridotToolEffectList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> PERIDOT_SWORD = ITEMS.register("peridot_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.PERIDOT, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.PERIDOT, 3, -2.3f)), "peridot_tool.description", ChatFormatting.GREEN, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getPeridotToolEffectList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_HELMET = ITEMS.register("peridot_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "peridot_armor.description", ItemRegistry::getPeridotArmorAmplifierList, ChatFormatting.GREEN, PERIDOT_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_CHESTPLATE = ITEMS.register("peridot_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "peridot_armor.description", ItemRegistry::getPeridotArmorAmplifierList, ChatFormatting.GREEN, PERIDOT_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_LEGGINGS = ITEMS.register("peridot_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "peridot_armor.description", ItemRegistry::getPeridotArmorAmplifierList, ChatFormatting.GREEN, PERIDOT_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> PERIDOT_BOOTS = ITEMS.register("peridot_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.PERIDOT, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "peridot_armor.description", ItemRegistry::getPeridotArmorAmplifierList, ChatFormatting.GREEN, PERIDOT_SET));

    public static final RegistryObject<Item, MythicEffectsShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.RUBY, 2, -2.1f)), "ruby_tool.description", ChatFormatting.RED, ItemRegistry::getRubyToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.RUBY, 1, -1.9f)), "ruby_tool.description", ChatFormatting.RED, ItemRegistry::getRubyToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.RUBY, 5, -2.1f)), "ruby_tool.description", ChatFormatting.RED, ItemRegistry::getRubyToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsHoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.RUBY, -4, 0.9f)), "ruby_tool.description", ChatFormatting.RED, ItemRegistry::getRubyToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.RUBY, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.RUBY, 3, -1.5f)), "ruby_tool.description", ChatFormatting.RED, ItemRegistry::getRubyToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "ruby_armor.description", ItemRegistry::getRubyArmorAmplifierList, ChatFormatting.RED, RUBY_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "ruby_armor.description", ItemRegistry::getRubyArmorAmplifierList, ChatFormatting.RED, RUBY_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "ruby_armor.description", ItemRegistry::getRubyArmorAmplifierList, ChatFormatting.RED, RUBY_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.RUBY, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "ruby_armor.description", ItemRegistry::getRubyArmorAmplifierList, ChatFormatting.RED, RUBY_SET));

    public static final RegistryObject<Item, SapphireHoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoeItem(getFireResistantProperties().attributes(createSapphireAttributes(MUToolMaterials.SAPPHIRE, -4, 0.1f)), "sapphire_tool.description", ChatFormatting.DARK_BLUE, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, SapphireShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovelItem(getFireResistantProperties().attributes(createSapphireAttributes(MUToolMaterials.SAPPHIRE, 2, -2.9f)), "sapphire_tool.description", ChatFormatting.DARK_BLUE, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, SapphirePickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxeItem(getFireResistantProperties().attributes(createSapphireAttributes(MUToolMaterials.SAPPHIRE, 1, -2.7f)), "sapphire_tool.description", ChatFormatting.DARK_BLUE, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, SapphireAxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxeItem(getFireResistantProperties().attributes(createSapphireAttributes(MUToolMaterials.SAPPHIRE, 5, -2.9f)), "sapphire_tool.description", ChatFormatting.DARK_BLUE, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, SapphireSwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSwordItem(getFireResistantProperties().attributes(createSapphireAttributes(MUToolMaterials.SAPPHIRE, 3, -2.3f)), "sapphire_tool.description", ChatFormatting.DARK_BLUE, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "sapphire_armor.description", ItemRegistry::getSapphireArmorAmplifierList, ChatFormatting.DARK_BLUE, SAPPHIRE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "sapphire_armor.description", ItemRegistry::getSapphireArmorAmplifierList, ChatFormatting.DARK_BLUE, SAPPHIRE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "sapphire_armor.description", ItemRegistry::getSapphireArmorAmplifierList, ChatFormatting.DARK_BLUE, SAPPHIRE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "sapphire_armor.description", ItemRegistry::getSapphireArmorAmplifierList, ChatFormatting.DARK_BLUE, SAPPHIRE_SET));

    public static final RegistryObject<Item, MythicEffectsShovelItem> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.TOPAZ, 2, -2.9f)), "topaz_tool.description", ChatFormatting.GOLD, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.TOPAZ, 1, -2.7f)), "topaz_tool.description", ChatFormatting.GOLD, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> TOPAZ_AXE = ITEMS.register("topaz_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.TOPAZ, 5, -2.9f)), "topaz_tool.description", ChatFormatting.GOLD, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsHoeItem> TOPAZ_HOE = ITEMS.register("topaz_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.TOPAZ, -4, 0.1f)), "topaz_tool.description", ChatFormatting.GOLD, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> TOPAZ_SWORD = ITEMS.register("topaz_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.TOPAZ, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.TOPAZ, 3, -2.3f)), "topaz_tool.description", ChatFormatting.GOLD, EffectList::getEmptyList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_HELMET = ITEMS.register("topaz_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "topaz_armor.description", ItemRegistry::getTopazArmorAmplifierList, ChatFormatting.GOLD, TOPAZ_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "topaz_armor.description", ItemRegistry::getTopazArmorAmplifierList, ChatFormatting.GOLD, TOPAZ_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "topaz_armor.description", ItemRegistry::getTopazArmorAmplifierList, ChatFormatting.GOLD, TOPAZ_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> TOPAZ_BOOTS = ITEMS.register("topaz_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.TOPAZ, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "topaz_armor.description", ItemRegistry::getTopazArmorAmplifierList, ChatFormatting.GOLD, TOPAZ_SET));

    public static final RegistryObject<Item, MythicEffectsHoeItem> AMETRINE_HOE = ITEMS.register("ametrine_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.AMETRINE, -4, 0.1f)), "ametrine_tool.description", ChatFormatting.DARK_PURPLE, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAmetrineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsShovelItem> AMETRINE_SHOVEL = ITEMS.register("ametrine_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.AMETRINE, 2, -2.9f)), "ametrine_tool.description", ChatFormatting.DARK_PURPLE, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAmetrineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> AMETRINE_PICKAXE = ITEMS.register("ametrine_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.AMETRINE, 1, -2.7f)), "ametrine_tool.description", ChatFormatting.DARK_PURPLE, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAmetrineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> AMETRINE_AXE = ITEMS.register("ametrine_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.AMETRINE, 5, -2.9f)), "ametrine_tool.description", ChatFormatting.DARK_PURPLE, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAmetrineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> AMETRINE_SWORD = ITEMS.register("ametrine_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.AMETRINE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.AMETRINE, 3, -2.3f)), "ametrine_tool.description", ChatFormatting.DARK_PURPLE, EffectList::getEmptyList, EffectList::getEmptyList, ItemRegistry::getAmetrineToolEffectList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_HELMET = ITEMS.register("ametrine_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "ametrine_armor.description", ItemRegistry::getAmetrineArmorAmplifierList, ChatFormatting.DARK_PURPLE, AMETRINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_CHESTPLATE = ITEMS.register("ametrine_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "ametrine_armor.description", ItemRegistry::getAmetrineArmorAmplifierList, ChatFormatting.DARK_PURPLE, AMETRINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_LEGGINGS = ITEMS.register("ametrine_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "ametrine_armor.description", ItemRegistry::getAmetrineArmorAmplifierList, ChatFormatting.DARK_PURPLE, AMETRINE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> AMETRINE_BOOTS = ITEMS.register("ametrine_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.AMETRINE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "ametrine_armor.description", ItemRegistry::getAmetrineArmorAmplifierList, ChatFormatting.DARK_PURPLE, AMETRINE_SET));

    public static final RegistryObject<Item, MythicEffectsShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> new MythicEffectsShovelItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsShovelItem.createAttributes(MUToolMaterials.JADE, 2, -2.9f)), "jade_tool.description", ChatFormatting.DARK_GREEN, ItemRegistry::getJadeToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsPickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> new MythicEffectsPickaxeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsPickaxeItem.createAttributes(MUToolMaterials.JADE, 1, -2.7f)), "jade_tool.description", ChatFormatting.DARK_GREEN, ItemRegistry::getJadeToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsHoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> new MythicEffectsHoeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsHoeItem.createAttributes(MUToolMaterials.JADE, -4, 0.1f)), "jade_tool.description", ChatFormatting.DARK_GREEN, ItemRegistry::getJadeToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsAxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> new MythicEffectsAxeItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsAxeItem.createAttributes(MUToolMaterials.JADE, 5, -2.9f)), "jade_tool.description", ChatFormatting.DARK_GREEN, ItemRegistry::getJadeToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsSwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> new MythicEffectsSwordItem(MUToolMaterials.JADE, getFireResistantProperties().attributes(MythicEffectsSwordItem.createAttributes(MUToolMaterials.JADE, 3, -2.3f)), "jade_tool.description", ChatFormatting.DARK_GREEN, ItemRegistry::getJadeToolEffectList, EffectList::getEmptyList, EffectList::getEmptyList));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.HELMET, getFireResistantProperties().durability(ArmorItem.Type.HELMET.getDurability(50)), "jade_armor.description", ItemRegistry::getJadeArmorAmplifierList, ChatFormatting.DARK_GREEN, JADE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.CHESTPLATE, getFireResistantProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50)), "jade_armor.description", ItemRegistry::getJadeArmorAmplifierList, ChatFormatting.DARK_GREEN, JADE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.LEGGINGS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "jade_armor.description", ItemRegistry::getJadeArmorAmplifierList, ChatFormatting.DARK_GREEN, JADE_SET));
    public static final RegistryObject<Item, MythicEffectsArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> new MythicEffectsArmorItem(MUArmorMaterials.JADE, ArmorItem.Type.BOOTS, getFireResistantProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(50)), "jade_armor.description", ItemRegistry::getJadeArmorAmplifierList, ChatFormatting.DARK_GREEN, JADE_SET));


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

    private static EffectList getAquamarineToolEffectList() {
       // AquamarineData data = MUConfigHelper.getAquamarineValues();
        return new EffectList.Builder().build();
    }

    public static final ResourceLocation AQUAMARINE_UNDERWATER_MINING_ID = CommonFunctions.getLoc("aquamarine_underwater_mining");

    public static ItemAttributeModifiers createSapphireAttributes(Tier tier, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.SUBMERGED_MINING_SPEED,
                        new AttributeModifier(AQUAMARINE_UNDERWATER_MINING_ID, 4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }


    private static List<Integer> getAquamarineArmorAmplifierList() {
        AquamarineData data = MUConfigHelper.getAquamarineValues();
        return List.of(data.ice_shield_amplifier());
    }

    private static EffectList getPeridotToolEffectList() {
        PeridotData data = MUConfigHelper.getPeridotValues();
        return new EffectList.Builder()
                .addEffect(POISON, (int) (20 * data.tools_poison_duration()), data.tools_effects_amplifier(),
                        false, true, true)
                .addEffect(CONFUSION, (int) (20 * data.tools_nausea_duration()), data.tools_effects_amplifier(),
                        false, true, true)
                .build();
    }

    private static List<Integer> getPeridotArmorAmplifierList() {
        PeridotData data = MUConfigHelper.getPeridotValues();
        return List.of(data.poisonous_thorns_amplifier());
    }

    private static EffectList getRubyToolEffectList() {
        RubyData data = MUConfigHelper.getRubyValues();
        return new EffectList.Builder()
                .addInfiniteEffect(DIG_SPEED, data.tools_haste_amplifier(), true, false, true)
                .build();
    }

    private static List<Integer> getRubyArmorAmplifierList() {
        RubyData data = MUConfigHelper.getRubyValues();
        return List.of(data.spelunker_amplifier());
    }

    private static EffectList getAmetrineToolEffectList() {
        AmetrineData data = MUConfigHelper.getAmetrineValues();
        return new EffectList.Builder()
                .addEffect(LEVITATION, (int)(20 * data.tools_levitation_duration()),
                        data.tools_levitation_amplifier(),
                        false, false, true)
                .build();
    }

    private static List<Integer> getAmetrineArmorAmplifierList() {
        AmetrineData data = MUConfigHelper.getAmetrineValues();
        return List.of(data.arcane_aura_amplifier());
    }

    private static EffectList getJadeToolEffectList() {
        JadeData data = MUConfigHelper.getJadeValues();
        return new EffectList.Builder()
                .addInfiniteEffect(EffectRegistry.BOUNCER, data.tools_bouncer_amplifier(),
                        true, false, true)
                .build();
    }

    private static List<Integer> getJadeArmorAmplifierList() {
        JadeData data = MUConfigHelper.getJadeValues();
        return List.of(data.speed_amplifier(), data.jump_boost_amplifier());
    }

    private static List<Integer> getSapphireArmorAmplifierList() {
        SapphireData data = MUConfigHelper.getSapphireValues();
        return List.of(data.damage_deflection_amplifier());
    }

    private static List<Integer> getTopazArmorAmplifierList() {
        TopazData data = MUConfigHelper.getTopazValues();
        return List.of(data.item_mastery_amplifier());
    }
}
