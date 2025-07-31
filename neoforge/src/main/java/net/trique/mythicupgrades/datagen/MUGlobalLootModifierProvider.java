package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class MUGlobalLootModifierProvider extends GlobalLootModifierProvider {
    private static final ResourceKey<LootTable> DESERT_PYRAMID_LOOT = BuiltInLootTables.DESERT_PYRAMID;
    private static final ResourceKey<LootTable> JUNGLE_TEMPLE_LOOT = BuiltInLootTables.JUNGLE_TEMPLE;
    private static final ResourceKey<LootTable> IGLOO_CHEST_LOOT = BuiltInLootTables.IGLOO_CHEST;
    private static final ResourceKey<LootTable> BASTION_BRIDGE_LOOT = BuiltInLootTables.BASTION_BRIDGE;
    private static final ResourceKey<LootTable> BASTION_HOGLIN_STABLE_LOOT = BuiltInLootTables.BASTION_HOGLIN_STABLE;
    private static final ResourceKey<LootTable> BASTION_OTHER_LOOT = BuiltInLootTables.BASTION_OTHER;
    private static final ResourceKey<LootTable> BASTION_TREASURE_LOOT = BuiltInLootTables.BASTION_TREASURE;
    private static final ResourceKey<LootTable> NETHER_BRIDGE_LOOT = BuiltInLootTables.NETHER_BRIDGE;
    private static final ResourceKey<LootTable> END_CITY_TREASURE_LOOT = BuiltInLootTables.END_CITY_TREASURE;


    public MUGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Constants.MOD_ID);
    }

    @Override
    protected void start() {
        add("add_peridot_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(JUNGLE_TEMPLE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, PERIDOT_POTION.get()
        ));
        add("add_peridot_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(JUNGLE_TEMPLE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, PERIDOT_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_topaz_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(DESERT_PYRAMID_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, TOPAZ_POTION.get()
        ));
        add("add_topaz_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(DESERT_PYRAMID_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, TOPAZ_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_aquamarine_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(IGLOO_CHEST_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, AQUAMARINE_POTION.get()
        ));
        add("add_aquamarine_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(IGLOO_CHEST_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_ruby_potion_in_hoglin_stable", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_HOGLIN_STABLE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, RUBY_POTION.get()
        ));
        add("add_ruby_upgrade_smithing_template_in_hoglin_stable", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_HOGLIN_STABLE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, RUBY_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("add_ruby_potion_in_bridge", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_BRIDGE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, RUBY_POTION.get()
        ));
        add("add_ruby_upgrade_smithing_template_in_bridge", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_BRIDGE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, RUBY_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("add_ruby_potion_in_other", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_OTHER_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, RUBY_POTION.get()
        ));
        add("add_ruby_upgrade_smithing_template_in_other", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_OTHER_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, RUBY_UPGRADE_SMITHING_TEMPLATE.get()
        ));
        add("add_ruby_potion_in_treasure", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(1f).build(),
                }, RUBY_POTION.get()
        ));
        add("add_ruby_upgrade_smithing_template_in_treasure", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BASTION_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build(),
                }, RUBY_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_sapphire_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(NETHER_BRIDGE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, SAPPHIRE_POTION.get()
        ));
        add("add_sapphire_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(NETHER_BRIDGE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_ametrine_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(END_CITY_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, AMETRINE_POTION.get()
        ));
        add("add_ametrine_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(END_CITY_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, AMETRINE_UPGRADE_SMITHING_TEMPLATE.get()
        ));

        add("add_jade_potion", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(END_CITY_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, JADE_POTION.get()
        ));
        add("add_jade_upgrade_smithing_template", new AddItemModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(END_CITY_TREASURE_LOOT.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, JADE_UPGRADE_SMITHING_TEMPLATE.get()
        ));

    }
}
