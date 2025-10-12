package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.trique.mythicupgrades.registry.BlockRegistry;

import java.util.Set;

import static net.trique.mythicupgrades.registry.BlockRegistry.*;
import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class MUBlockLootTableProvider extends BlockLootSubProvider {
    protected MUBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(AQUAMARINE_BLOCK.get());
        dropSelf(AQUAMARINE_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_AQUAMARINE_CRYSTAL_BLOCK.get());
        dropSelf(AQUAMARINE_CRYSTAL_BRICKS.get());
        dropSelf(AQUAMARINE_PILLAR.get());
        dropSelf(CUT_AQUAMARINE_PILLAR.get());
        add(AQUAMARINE_ORE.get(), createOreDrop(AQUAMARINE_ORE.get(), AQUAMARINE.get()));
        add(DEEPSLATE_AQUAMARINE_ORE.get(), createOreDrop(DEEPSLATE_AQUAMARINE_ORE.get(), AQUAMARINE.get()));

        dropSelf(PERIDOT_BLOCK.get());
        dropSelf(PERIDOT_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_PERIDOT_CRYSTAL_BLOCK.get());
        dropSelf(PERIDOT_CRYSTAL_BRICKS.get());
        dropSelf(PERIDOT_PILLAR.get());
        dropSelf(CUT_PERIDOT_PILLAR.get());
        add(PERIDOT_ORE.get(), createOreDrop(PERIDOT_ORE.get(), PERIDOT.get()));
        add(DEEPSLATE_PERIDOT_ORE.get(), createOreDrop(DEEPSLATE_PERIDOT_ORE.get(), PERIDOT.get()));


        dropSelf(RUBY_BLOCK.get());
        dropSelf(RUBY_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_RUBY_CRYSTAL_BLOCK.get());
        dropSelf(RUBY_CRYSTAL_BRICKS.get());
        dropSelf(RUBY_PILLAR.get());
        dropSelf(CUT_RUBY_PILLAR.get());
        add(RUBY_ORE.get(), createOreDrop(RUBY_ORE.get(), RUBY.get()));

        dropSelf(SAPPHIRE_BLOCK.get());
        dropSelf(SAPPHIRE_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_SAPPHIRE_CRYSTAL_BLOCK.get());
        dropSelf(SAPPHIRE_CRYSTAL_BRICKS.get());
        dropSelf(SAPPHIRE_PILLAR.get());
        dropSelf(CUT_SAPPHIRE_PILLAR.get());
        add(SAPPHIRE_ORE.get(), createOreDrop(SAPPHIRE_ORE.get(), SAPPHIRE.get()));

        dropSelf(TOPAZ_BLOCK.get());
        dropSelf(TOPAZ_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_TOPAZ_CRYSTAL_BLOCK.get());
        dropSelf(TOPAZ_CRYSTAL_BRICKS.get());
        dropSelf(TOPAZ_PILLAR.get());
        dropSelf(CUT_TOPAZ_PILLAR.get());
        add(TOPAZ_ORE.get(), createOreDrop(TOPAZ_ORE.get(), TOPAZ.get()));
        add(DEEPSLATE_TOPAZ_ORE.get(), createOreDrop(DEEPSLATE_TOPAZ_ORE.get(), TOPAZ.get()));

        dropSelf(AMETRINE_BLOCK.get());
        dropSelf(AMETRINE_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_AMETRINE_CRYSTAL_BLOCK.get());
        dropSelf(AMETRINE_CRYSTAL_BRICKS.get());
        dropSelf(AMETRINE_PILLAR.get());
        dropSelf(CUT_AMETRINE_PILLAR.get());
        add(AMETRINE_ORE.get(), createOreDrop(AMETRINE_ORE.get(), AMETRINE.get()));

        dropSelf(JADE_BLOCK.get());
        dropSelf(JADE_CRYSTAL_BLOCK.get());
        dropSelf(POLISHED_JADE_CRYSTAL_BLOCK.get());
        dropSelf(JADE_CRYSTAL_BRICKS.get());
        dropSelf(JADE_PILLAR.get());
        dropSelf(CUT_JADE_PILLAR.get());
        add(JADE_ORE.get(), createOreDrop(JADE_ORE.get(), JADE.get()));

        dropSelf(NECOIUM_BLOCK.get());
        dropSelf(RAW_NECOIUM_BLOCK.get());
        add(NECOIUM_ORE.get(), createOreDrop(NECOIUM_ORE.get(), RAW_NECOIUM.get()));


        add(AMETRINE_CRYSTAL_CLUSTER.get(), createClusterDrops(AMETRINE_CRYSTAL_CLUSTER.get(), AMETRINE_CRYSTAL_SHARD.get()));
        add(AQUAMARINE_CRYSTAL_CLUSTER.get(), createClusterDrops(AQUAMARINE_CRYSTAL_CLUSTER.get(), AQUAMARINE_CRYSTAL_SHARD.get()));
        add(JADE_CRYSTAL_CLUSTER.get(), createClusterDrops(JADE_CRYSTAL_CLUSTER.get(), JADE_CRYSTAL_SHARD.get()));
        add(PERIDOT_CRYSTAL_CLUSTER.get(), createClusterDrops(PERIDOT_CRYSTAL_CLUSTER.get(), PERIDOT_CRYSTAL_SHARD.get()));
        add(RUBY_CRYSTAL_CLUSTER.get(), createClusterDrops(RUBY_CRYSTAL_CLUSTER.get(), RUBY_CRYSTAL_SHARD.get()));
        add(SAPPHIRE_CRYSTAL_CLUSTER.get(), createClusterDrops(SAPPHIRE_CRYSTAL_CLUSTER.get(), SAPPHIRE_CRYSTAL_SHARD.get()));
        add(TOPAZ_CRYSTAL_CLUSTER.get(), createClusterDrops(TOPAZ_CRYSTAL_CLUSTER.get(), TOPAZ_CRYSTAL_SHARD.get()));
    }


    public LootTable.Builder createClusterDrops(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)))
                .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                .when(MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)))))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.getModBlocks();
    }
}
