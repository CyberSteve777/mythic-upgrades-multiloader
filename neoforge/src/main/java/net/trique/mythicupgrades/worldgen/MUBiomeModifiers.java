package net.trique.mythicupgrades.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.common.Tags;
import net.minecraft.world.level.biome.Biomes;
import net.trique.mythicupgrades.Constants;


public class MUBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_ORE = registerKey("add_aquamarine_ore");
    public static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_CRYSTAL_GEODE =
            registerKey("add_aquamarine_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_PERIDOT_ORE = registerKey("add_peridot_ore");
    public static final ResourceKey<BiomeModifier> ADD_PERIDOT_CRYSTAL_GEODE =
            registerKey("add_peridot_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_TOPAZ_ORE = registerKey("add_topaz_ore");
    public static final ResourceKey<BiomeModifier> ADD_TOPAZ_CRYSTAL_GEODE =
            registerKey("add_topaz_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("add_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_CRYSTAL_GEODE =
            registerKey("add_sapphire_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("add_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_CRYSTAL_GEODE =
            registerKey("add_ruby_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_AMETRINE_ORE = registerKey("add_ametrine_ore");
    public static final ResourceKey<BiomeModifier> ADD_AMETRINE_CRYSTAL_GEODE =
            registerKey("add_ametrine_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_JADE_ORE = registerKey("add_jade_ore");
    public static final ResourceKey<BiomeModifier> ADD_JADE_CRYSTAL_GEODE =
            registerKey("add_jade_crystal_geode");

    public static final ResourceKey<BiomeModifier> ADD_NECOIUM_ORE = registerKey("add_necoium_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_AQUAMARINE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_ICY),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.AQUAMARINE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TOPAZ_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.TOPAZ_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_PERIDOT_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.PERIDOT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_SAPPHIRE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.SAPPHIRE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_RUBY_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_AMETRINE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.AMETRINE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_JADE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.JADE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NECOIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.NECOIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        context.register(ADD_AQUAMARINE_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.AQUAMARINE_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_TOPAZ_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.TOPAZ_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_PERIDOT_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.PERIDOT_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_SAPPHIRE_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.SAPPHIRE_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_RUBY_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.RUBY_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_AMETRINE_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.AMETRINE_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
        context.register(ADD_JADE_CRYSTAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MUPlacedFeatures.JADE_CRYSTAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }
}
