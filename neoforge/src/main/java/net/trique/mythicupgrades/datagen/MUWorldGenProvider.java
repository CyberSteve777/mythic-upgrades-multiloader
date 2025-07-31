package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.worldgen.*;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MUWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MUConfiguredFeatures::boostrap)
            .add(Registries.PLACED_FEATURE, MUPlacedFeatures::boostrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MUBiomeModifiers::bootstrap);

    public MUWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BUILDER, Set.of(Constants.MOD_ID));
    }

    @Override
    public String getName() {
        return "MUWorldGen";
    }
}