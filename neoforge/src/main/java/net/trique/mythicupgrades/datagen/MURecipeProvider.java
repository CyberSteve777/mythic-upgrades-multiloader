package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.trique.mythicupgrades.Constants;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;
import static net.trique.mythicupgrades.registry.BlockRegistry.*;


public class MURecipeProvider extends RecipeProvider implements IConditionBuilder {
    public MURecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput, List.of(AQUAMARINE_ORE.get(), DEEPSLATE_AQUAMARINE_ORE.get()), RecipeCategory.MISC, AQUAMARINE.get(),
                3.0f, 200, "aquamarine");
        oreBlasting(recipeOutput, List.of(AQUAMARINE_ORE.get(), DEEPSLATE_AQUAMARINE_ORE.get()), RecipeCategory.MISC, AQUAMARINE.get(),
                3.0f, 100, "aquamarine");

        oreSmelting(recipeOutput, List.of(PERIDOT_ORE.get(), DEEPSLATE_PERIDOT_ORE.get()), RecipeCategory.MISC, PERIDOT.get(),
                3.0f, 200, "peridot");
        oreBlasting(recipeOutput, List.of(PERIDOT_ORE.get(), DEEPSLATE_PERIDOT_ORE.get()), RecipeCategory.MISC, PERIDOT.get(),
                3.0f, 100, "peridot");

        oreSmelting(recipeOutput, List.of(RUBY_ORE.get()), RecipeCategory.MISC, RUBY.get(),
                3.0f, 200, "ruby");
        oreBlasting(recipeOutput, List.of(RUBY_ORE.get()), RecipeCategory.MISC, RUBY.get(),
                3.0f, 100, "ruby");

        oreSmelting(recipeOutput, List.of(SAPPHIRE_ORE.get()), RecipeCategory.MISC, SAPPHIRE.get(),
                3.0f, 200, "sapphire");
        oreBlasting(recipeOutput, List.of(SAPPHIRE_ORE.get()), RecipeCategory.MISC, SAPPHIRE.get(),
                3.0f, 100, "sapphire");

        oreSmelting(recipeOutput, List.of(TOPAZ_ORE.get(), DEEPSLATE_TOPAZ_ORE.get()), RecipeCategory.MISC, TOPAZ.get(),
                3.0f, 200, "topaz");
        oreBlasting(recipeOutput, List.of(TOPAZ_ORE.get(), DEEPSLATE_TOPAZ_ORE.get()), RecipeCategory.MISC, TOPAZ.get(),
                3.0f, 100, "topaz");

        oreSmelting(recipeOutput, List.of(AMETRINE_ORE.get()), RecipeCategory.MISC, AMETRINE.get(),
                3.0f, 200, "ametrine");
        oreBlasting(recipeOutput, List.of(AMETRINE_ORE.get()), RecipeCategory.MISC, AMETRINE.get(),
                3.0f, 100, "ametrine");

        oreSmelting(recipeOutput, List.of(JADE_ORE.get()), RecipeCategory.MISC, JADE.get(),
                3.0f, 200, "jade");
        oreBlasting(recipeOutput, List.of(JADE_ORE.get()), RecipeCategory.MISC, JADE.get(),
                3.0f, 100, "jade");

        oreSmelting(recipeOutput, List.of(NECOIUM_ORE.get()), RecipeCategory.MISC, NECOIUM_INGOT.get(),
                3.0f, 200, "necoium");
        oreBlasting(recipeOutput, List.of(NECOIUM_ORE.get()), RecipeCategory.MISC, NECOIUM_INGOT.get(),
                3.0f, 100, "necoium");

        oreSmelting(recipeOutput, List.of(RAW_NECOIUM.get()), RecipeCategory.MISC, NECOIUM_INGOT.get(),
                3.0f, 200, "necoium");
        oreBlasting(recipeOutput, List.of(RAW_NECOIUM.get()), RecipeCategory.MISC, NECOIUM_INGOT.get(),
                3.0f, 100, "necoium");


        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, AQUAMARINE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, AQUAMARINE_BLOCK.get(),
                getId("aquamarine_block"), "aquamarine_block", getId("aquamarine_ingot_from_aquamarine_block"), "aquamarine_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, PERIDOT_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, PERIDOT_BLOCK.get(),
                getId("peridot_block"), "peridot_block", getId("peridot_ingot_from_peridot_block"), "peridot_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, RUBY_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, RUBY_BLOCK.get(),
                getId("ruby_block"), "ruby_block", getId("ruby_ingot_from_ruby_block"), "ruby_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, SAPPHIRE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, SAPPHIRE_BLOCK.get(),
                getId("sapphire_block"), "sapphire_block", getId("sapphire_ingot_from_sapphire_block"), "sapphire_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, TOPAZ_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, TOPAZ_BLOCK.get(),
                getId("topaz_block"), "topaz_block", getId("topaz_ingot_from_topaz_block"), "topaz_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, AMETRINE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, AMETRINE_BLOCK.get(),
                getId("ametrine_block"), "ametrine_block", getId("ametrine_ingot_from_ametrine_block"), "ametrine_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, JADE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, JADE_BLOCK.get(),
                getId("jade_block"), "jade_block", getId("jade_ingot_from_jade_block"), "jade_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, NECOIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, NECOIUM_BLOCK.get(),
                getId("necoium_block"), "necoium_block", getId("necoium_ingot_from_necoium_block"), "necoium_ingot");

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, RAW_NECOIUM.get(), RecipeCategory.BUILDING_BLOCKS, RAW_NECOIUM_BLOCK.get(),
                getId("raw_necoium_block"), "raw_necoium_block", getId("raw_necoium_from_raw_necoium_block"), "necoium_ingot");

        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), AQUAMARINE.get(), AQUAMARINE_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), TOPAZ.get(), TOPAZ_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), PERIDOT.get(), PERIDOT_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), SAPPHIRE.get(), SAPPHIRE_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), RUBY.get(), RUBY_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), AMETRINE.get(), AMETRINE_INGOT.get());
        offerGemIngotRecipe(recipeOutput, NECOIUM_INGOT.get(), JADE.get(), JADE_INGOT.get());


        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE::get,
                AQUAMARINE::get, () -> Items.STONE_BRICKS);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE::get,
                PERIDOT::get, () -> Items.MOSSY_COBBLESTONE);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE::get,
                RUBY::get, () -> Items.BLACKSTONE);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE::get,
                SAPPHIRE::get, () -> Items.NETHER_BRICKS);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE::get,
                TOPAZ::get, () -> Items.SANDSTONE);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE::get,
                AMETRINE::get, () -> Items.END_STONE_BRICKS);
        offerCustomSmithingTemplateCopyingRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE::get,
                JADE::get, () -> Items.END_STONE_BRICKS);


        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, PERIDOT_INGOT.get(), RecipeCategory.TOOLS, PERIDOT_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, PERIDOT_INGOT.get(), RecipeCategory.TOOLS, PERIDOT_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, PERIDOT_INGOT.get(), RecipeCategory.TOOLS, PERIDOT_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, PERIDOT_INGOT.get(), RecipeCategory.COMBAT, PERIDOT_BOOTS.get());

        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, TOPAZ_INGOT.get(), RecipeCategory.TOOLS, TOPAZ_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, TOPAZ_INGOT.get(), RecipeCategory.TOOLS, TOPAZ_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, TOPAZ_INGOT.get(), RecipeCategory.TOOLS, TOPAZ_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, TOPAZ_INGOT.get(), RecipeCategory.COMBAT, TOPAZ_BOOTS.get());

        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, RUBY_INGOT.get(), RecipeCategory.TOOLS, RUBY_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, RUBY_INGOT.get(), RecipeCategory.TOOLS, RUBY_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, RUBY_INGOT.get(), RecipeCategory.TOOLS, RUBY_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, RUBY_INGOT.get(), RecipeCategory.TOOLS, RUBY_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, RUBY_INGOT.get(), RecipeCategory.TOOLS, RUBY_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, RUBY_INGOT.get(), RecipeCategory.COMBAT, RUBY_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, RUBY_INGOT.get(), RecipeCategory.COMBAT, RUBY_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, RUBY_INGOT.get(), RecipeCategory.COMBAT, RUBY_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, RUBY_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, RUBY_INGOT.get(), RecipeCategory.COMBAT, RUBY_BOOTS.get());

        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, SAPPHIRE_INGOT.get(), RecipeCategory.TOOLS, SAPPHIRE_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, SAPPHIRE_INGOT.get(), RecipeCategory.TOOLS, SAPPHIRE_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, SAPPHIRE_INGOT.get(), RecipeCategory.TOOLS, SAPPHIRE_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, SAPPHIRE_INGOT.get(), RecipeCategory.COMBAT, SAPPHIRE_BOOTS.get());

        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, AMETRINE_INGOT.get(), RecipeCategory.TOOLS, AMETRINE_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, AMETRINE_INGOT.get(), RecipeCategory.TOOLS, AMETRINE_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, AMETRINE_INGOT.get(), RecipeCategory.TOOLS, AMETRINE_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, AMETRINE_INGOT.get(), RecipeCategory.COMBAT, AMETRINE_BOOTS.get());

        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, JADE_INGOT.get(), RecipeCategory.TOOLS, JADE_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, JADE_INGOT.get(), RecipeCategory.TOOLS, JADE_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, JADE_INGOT.get(), RecipeCategory.TOOLS, JADE_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, JADE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, JADE_INGOT.get(), RecipeCategory.COMBAT, JADE_BOOTS.get());


        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_AXE, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_AXE.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SWORD, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_SWORD.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_PICKAXE, AQUAMARINE_INGOT.get(), RecipeCategory.TOOLS, AQUAMARINE_PICKAXE.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_SHOVEL, AQUAMARINE_INGOT.get(), RecipeCategory.TOOLS, AQUAMARINE_SHOVEL.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HOE, AQUAMARINE_INGOT.get(), RecipeCategory.TOOLS, AQUAMARINE_HOE.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_HELMET, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_HELMET.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_CHESTPLATE, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_CHESTPLATE.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_LEGGINGS, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_LEGGINGS.get());
        offerCustomUpgradeRecipe(recipeOutput, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get(),
                Items.NETHERITE_BOOTS, AQUAMARINE_INGOT.get(), RecipeCategory.COMBAT, AQUAMARINE_BOOTS.get());


        offerMythicPotionRecipe(recipeOutput, AMETRINE_CRYSTAL_SHARD.get(), AMETRINE_POTION.get());
        offerMythicPotionRecipe(recipeOutput, AQUAMARINE_CRYSTAL_SHARD.get(), AQUAMARINE_POTION.get());
        offerMythicPotionRecipe(recipeOutput, JADE_CRYSTAL_SHARD.get(), JADE_POTION.get());
        offerMythicPotionRecipe(recipeOutput, PERIDOT_CRYSTAL_SHARD.get(), PERIDOT_POTION.get());
        offerMythicPotionRecipe(recipeOutput, RUBY_CRYSTAL_SHARD.get(), RUBY_POTION.get());
        offerMythicPotionRecipe(recipeOutput, SAPPHIRE_CRYSTAL_SHARD.get(), SAPPHIRE_POTION.get());
        offerMythicPotionRecipe(recipeOutput, TOPAZ_CRYSTAL_SHARD.get(), TOPAZ_POTION.get());
    }

    protected static String getId(String name) {
        return Constants.MOD_ID + ":" + name;
    }

    protected static void offerCustomUpgradeRecipe(RecipeOutput exporter, Item template, Item input, Item itemMaterialUpgrade, RecipeCategory category, Item result) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(input), Ingredient.of(itemMaterialUpgrade), category, result).
                unlocks(RecipeProvider.getHasName(() -> itemMaterialUpgrade), RecipeProvider.has(itemMaterialUpgrade)).save(exporter, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, RecipeProvider.getItemName(result) + "_smithing"));
    }

    protected static void offerCustomSmithingTemplateCopyingRecipe(RecipeOutput exporter, ItemLike template, ItemLike duplicationMaterial, ItemLike resource) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, template, 2).define('#', duplicationMaterial).define('C', resource).define('S', template).pattern("#S#").pattern("#C#").pattern("###").
                unlockedBy(RecipeProvider.getHasName(template), RecipeProvider.has(template)).save(exporter);
    }

    protected static void offerMythicPotionRecipe(RecipeOutput exporter, ItemLike gem, ItemLike mythicPotion) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, mythicPotion, 1).define('#', gem).define('N',
                        Items.GOLD_NUGGET).define('B', Items.GLASS_BOTTLE).pattern("###").pattern("#N#")
                .pattern("#B#").unlockedBy(RecipeProvider.getHasName(gem), RecipeProvider.has(gem)).save(exporter);
    }

    protected static void offerGemIngotRecipe(RecipeOutput exporter, ItemLike baseIngot, ItemLike gem, ItemLike output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, 2)
                .requires(baseIngot, 4)
                .requires(gem, 4)
                .unlockedBy(RecipeProvider.getHasName(baseIngot), RecipeProvider.has(baseIngot))
                .unlockedBy(RecipeProvider.getHasName(gem), RecipeProvider.has(gem))
                .save(exporter);
    }

}
