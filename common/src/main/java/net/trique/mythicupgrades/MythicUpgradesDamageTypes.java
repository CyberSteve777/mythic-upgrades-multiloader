package net.trique.mythicupgrades;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static net.trique.mythicupgrades.Constants.MOD_ID;

public class MythicUpgradesDamageTypes {
    public static final ResourceKey<DamageType> DEFLECTING_DAMAGE_TYPE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(MOD_ID, "deflecting_damage_type"));

    public static final ResourceKey<DamageType> PERCENTAGE_DAMAGE_TYPE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(MOD_ID, "percentage_damage_type"));

    public static DamageSource create(Level world, ResourceKey<DamageType> key, @Nullable Entity attacker) {
        return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key), attacker);
    }
}