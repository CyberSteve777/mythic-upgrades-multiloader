package net.trique.mythicupgrades.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.trique.mythicupgrades.Constants;

import java.util.List;

import static net.trique.mythicupgrades.registry.BlockRegistry.*;

public class MUConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_ORE_KEY = registerKey("aquamarine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERIDOT_ORE_KEY = registerKey("peridot_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ_ORE_KEY = registerKey("topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETRINE_ORE_KEY = registerKey("ametrine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NECOIUM_ORE_KEY = registerKey("necoium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AQUAMARINE_CRYSTAL_GEODE_KEY = registerKey("aquamarine_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERIDOT_CRYSTAL_GEODE_KEY = registerKey("peridot_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_CRYSTAL_GEODE_KEY = registerKey("ruby_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_CRYSTAL_GEODE_KEY = registerKey("sapphire_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ_CRYSTAL_GEODE_KEY = registerKey("topaz_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETRINE_CRYSTAL_GEODE_KEY = registerKey("ametrine_crystal_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_CRYSTAL_GEODE_KEY = registerKey("jade_crystal_geode");


    public static void boostrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherStoneReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldAquamarineOres =
                List.of(OreConfiguration.target(stoneReplaceables, AQUAMARINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldPeridotOres =
                List.of(OreConfiguration.target(stoneReplaceables, PERIDOT_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, DEEPSLATE_PERIDOT_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherRubyOres =
                List.of(OreConfiguration.target(netherStoneReplaceables, RUBY_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherSapphireOres =
                List.of(OreConfiguration.target(netherStoneReplaceables, SAPPHIRE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTopazOres =
                List.of(OreConfiguration.target(stoneReplaceables, TOPAZ_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endAmetrineOres =
                List.of(OreConfiguration.target(endStoneReplaceables, AMETRINE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endJadeOres =
                List.of(OreConfiguration.target(endStoneReplaceables, JADE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endNecoiumOres =
                List.of(OreConfiguration.target(endStoneReplaceables, NECOIUM_ORE.get().defaultBlockState()));

        register(context, AQUAMARINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAquamarineOres, 5));
        register(context, PERIDOT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPeridotOres, 5));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(netherRubyOres, 5));
        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(netherSapphireOres, 5));
        register(context, TOPAZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTopazOres, 5));
        register(context, AMETRINE_ORE_KEY, Feature.ORE, new OreConfiguration(endAmetrineOres, 5));
        register(context, JADE_ORE_KEY, Feature.ORE, new OreConfiguration(endJadeOres, 5));
        register(context, NECOIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endNecoiumOres, 5));

        register(context, AQUAMARINE_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(AQUAMARINE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(AQUAMARINE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(AQUAMARINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AQUAMARINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AQUAMARINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AQUAMARINE_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, PERIDOT_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(PERIDOT_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(PERIDOT_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(PERIDOT_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                PERIDOT_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                PERIDOT_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                PERIDOT_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, RUBY_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(RUBY_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(RUBY_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(RUBY_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                RUBY_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                RUBY_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                RUBY_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, SAPPHIRE_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(SAPPHIRE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(SAPPHIRE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(SAPPHIRE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                SAPPHIRE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                SAPPHIRE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                SAPPHIRE_CRYSTAL_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, TOPAZ_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(TOPAZ_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(TOPAZ_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(TOPAZ_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                TOPAZ_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                TOPAZ_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                TOPAZ_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, AMETRINE_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(AMETRINE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(AMETRINE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.OBSIDIAN),
                        List.of(AMETRINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AMETRINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AMETRINE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                AMETRINE_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));

        register(context, JADE_CRYSTAL_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(JADE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(JADE_CRYSTAL_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.OBSIDIAN),
                        List.of(JADE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                JADE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                JADE_CRYSTAL_CLUSTER.get().defaultBlockState(),
                                JADE_CRYSTAL_CLUSTER.get().defaultBlockState()
                        ),
                        BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7, 2.2, 3.2, 4.2),
                        new GeodeCrackSettings(0.95, 2.0, 2),
                        0.35, 0.083,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05, 1));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
