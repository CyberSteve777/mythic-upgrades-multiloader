package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registry.MUDamageTypes;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MUDamageTypeProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, MUDamageTypeProvider::bootstrap);

    public MUDamageTypeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Constants.MOD_ID));
    }


    private static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(MUDamageTypes.DEFLECTING_DAMAGE_TYPE, new DamageType(
                "deflecting",
                DamageScaling.NEVER,
                0.0f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT));
        context.register(MUDamageTypes.PERCENTAGE_DAMAGE_TYPE, new DamageType(
                "percentage",
                DamageScaling.NEVER,
                0.0f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT));
    }

    @Override
    public String getName() {
        return "MUDamageTypes";
    }
}
