package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.Tags;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.util.MUBlockTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.trique.mythicupgrades.registry.BlockRegistry.*;

public class MUBlockTagProvider extends BlockTagsProvider {
    public MUBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                AQUAMARINE_BLOCK.get(), AQUAMARINE_ORE.get(), DEEPSLATE_AQUAMARINE_ORE.get(), AQUAMARINE_CRYSTAL_BLOCK.get(), AQUAMARINE_CRYSTAL_CLUSTER.get(),
                TOPAZ_BLOCK.get(), TOPAZ_ORE.get(), DEEPSLATE_TOPAZ_ORE.get(), TOPAZ_CRYSTAL_BLOCK.get(), TOPAZ_CRYSTAL_CLUSTER.get(),
                PERIDOT_BLOCK.get(), PERIDOT_ORE.get(), DEEPSLATE_PERIDOT_ORE.get(), PERIDOT_CRYSTAL_BLOCK.get(), PERIDOT_CRYSTAL_CLUSTER.get(),
                RUBY_BLOCK.get(), RUBY_ORE.get(), RUBY_CRYSTAL_BLOCK.get(), RUBY_CRYSTAL_CLUSTER.get(),
                SAPPHIRE_BLOCK.get(), SAPPHIRE_ORE.get(), SAPPHIRE_CRYSTAL_BLOCK.get(), SAPPHIRE_CRYSTAL_CLUSTER.get(),
                JADE_BLOCK.get(), JADE_ORE.get(), JADE_CRYSTAL_BLOCK.get(), JADE_CRYSTAL_CLUSTER.get(),
                AMETRINE_BLOCK.get(), AMETRINE_ORE.get(), AMETRINE_CRYSTAL_BLOCK.get(), AMETRINE_CRYSTAL_CLUSTER.get(),
                NECOIUM_BLOCK.get(), NECOIUM_ORE.get()
        );
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                AQUAMARINE_CRYSTAL_BLOCK.get(), AQUAMARINE_CRYSTAL_CLUSTER.get(),
                TOPAZ_CRYSTAL_BLOCK.get(), TOPAZ_CRYSTAL_CLUSTER.get(),
                PERIDOT_CRYSTAL_BLOCK.get(), PERIDOT_CRYSTAL_CLUSTER.get(),
                RUBY_CRYSTAL_BLOCK.get(), RUBY_CRYSTAL_CLUSTER.get(),
                SAPPHIRE_CRYSTAL_BLOCK.get(), SAPPHIRE_CRYSTAL_CLUSTER.get(),
                JADE_CRYSTAL_BLOCK.get(), JADE_CRYSTAL_CLUSTER.get(),
                AMETRINE_CRYSTAL_BLOCK.get(), AMETRINE_CRYSTAL_CLUSTER.get()
        );
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                AQUAMARINE_BLOCK.get(), AQUAMARINE_ORE.get(), DEEPSLATE_AQUAMARINE_ORE.get(),
                TOPAZ_BLOCK.get(), TOPAZ_ORE.get(), DEEPSLATE_TOPAZ_ORE.get(),
                PERIDOT_BLOCK.get(), PERIDOT_ORE.get(), DEEPSLATE_PERIDOT_ORE.get(),
                RUBY_BLOCK.get(), RUBY_ORE.get(),
                SAPPHIRE_BLOCK.get(), SAPPHIRE_ORE.get(),
                JADE_BLOCK.get(), JADE_ORE.get(),
                AMETRINE_BLOCK.get(), AMETRINE_ORE.get(),
                NECOIUM_BLOCK.get(), NECOIUM_ORE.get(), RAW_NECOIUM_BLOCK.get()
        );
        tag(Tags.Blocks.ORES).add(
                AMETRINE_ORE.get(), AQUAMARINE_ORE.get(), DEEPSLATE_AQUAMARINE_ORE.get(),
                JADE_ORE.get(), PERIDOT_ORE.get(), DEEPSLATE_PERIDOT_ORE.get(), RUBY_ORE.get(),
                SAPPHIRE_ORE.get(), TOPAZ_ORE.get(), DEEPSLATE_TOPAZ_ORE.get(), NECOIUM_ORE.get()
        );
        tag(Tags.Blocks.CLUSTERS).add(
                AQUAMARINE_CRYSTAL_CLUSTER.get(), TOPAZ_CRYSTAL_CLUSTER.get(),
                AQUAMARINE_CRYSTAL_CLUSTER.get(), RUBY_CRYSTAL_CLUSTER.get(),
                SAPPHIRE_CRYSTAL_CLUSTER.get(), JADE_CRYSTAL_CLUSTER.get(),
                AMETRINE_CRYSTAL_CLUSTER.get()
        );
        tag(MUBlockTags.INCORRECT_FOR_AMETRINE_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_JADE_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_SAPPHIRE_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_RUBY_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_PERIDOT_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_TOPAZ_TOOL);
        tag(MUBlockTags.INCORRECT_FOR_AQUAMARINE_TOOL);

        tag(MUBlockTags.STORAGE_BLOCKS_AQUAMARINE)
                .add(AQUAMARINE_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_TOPAZ)
                .add(TOPAZ_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_PERIDOT)
                .add(PERIDOT_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_RUBY)
                .add(RUBY_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_SAPPHIRE)
                .add(SAPPHIRE_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_JADE)
                .add(JADE_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_AMETRINE)
                .add(AMETRINE_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_NECOIUM)
                .add(NECOIUM_BLOCK.get());
        tag(MUBlockTags.STORAGE_BLOCKS_RAW_NECOIUM)
                .add(RAW_NECOIUM_BLOCK.get());


        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(
                        MUBlockTags.STORAGE_BLOCKS_AQUAMARINE,
                        MUBlockTags.STORAGE_BLOCKS_TOPAZ,
                        MUBlockTags.STORAGE_BLOCKS_PERIDOT,
                        MUBlockTags.STORAGE_BLOCKS_RUBY,
                        MUBlockTags.STORAGE_BLOCKS_SAPPHIRE,
                        MUBlockTags.STORAGE_BLOCKS_JADE,
                        MUBlockTags.STORAGE_BLOCKS_AMETRINE,
                        MUBlockTags.STORAGE_BLOCKS_NECOIUM,
                        MUBlockTags.STORAGE_BLOCKS_RAW_NECOIUM
                );

        tag(MUBlockTags.SPELUNKER_OUTLINED).addTags(
                Tags.Blocks.ORES,
                Tags.Blocks.CHESTS,
                Tags.Blocks.BARRELS,
                Tags.Blocks.CLUSTERS,
                Tags.Blocks.STORAGE_BLOCKS_COAL,
                Tags.Blocks.STORAGE_BLOCKS_EMERALD,
                Tags.Blocks.STORAGE_BLOCKS_DIAMOND,
                Tags.Blocks.STORAGE_BLOCKS_COPPER,
                Tags.Blocks.STORAGE_BLOCKS_GOLD,
                Tags.Blocks.STORAGE_BLOCKS_REDSTONE,
                Tags.Blocks.STORAGE_BLOCKS_IRON,
                Tags.Blocks.STORAGE_BLOCKS_LAPIS,
                Tags.Blocks.STORAGE_BLOCKS_NETHERITE,
                Tags.Blocks.STORAGE_BLOCKS_RAW_COPPER,
                Tags.Blocks.STORAGE_BLOCKS_RAW_GOLD,
                Tags.Blocks.STORAGE_BLOCKS_RAW_IRON,
                MUBlockTags.STORAGE_BLOCKS_AQUAMARINE,
                MUBlockTags.STORAGE_BLOCKS_TOPAZ,
                MUBlockTags.STORAGE_BLOCKS_PERIDOT,
                MUBlockTags.STORAGE_BLOCKS_RUBY,
                MUBlockTags.STORAGE_BLOCKS_SAPPHIRE,
                MUBlockTags.STORAGE_BLOCKS_JADE,
                MUBlockTags.STORAGE_BLOCKS_AMETRINE,
                MUBlockTags.STORAGE_BLOCKS_NECOIUM,
                MUBlockTags.STORAGE_BLOCKS_RAW_NECOIUM
        ).add(
                Blocks.DECORATED_POT
        );
        tag(MUBlockTags.CAN_VEINMINE).addTag(MUBlockTags.SPELUNKER_OUTLINED);
    }
}
