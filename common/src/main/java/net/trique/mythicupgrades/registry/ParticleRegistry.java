package net.trique.mythicupgrades.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;

public class ParticleRegistry {
    protected static final RegistrationProvider<ParticleType<?>> PARTICLE_TYPES = RegistrationProvider.get(Registries.PARTICLE_TYPE, Constants.MOD_ID);

    public static final RegistryObject<ParticleType<?>, SimpleParticleType> PERCENT_PARTICLE = PARTICLE_TYPES.register("percent_particle", Services.PARTICLE_HELPER::getSimpleParticle);

    public static void init() {
        Constants.LOGGER.info("Registering particles for Mythic Upgrades...");
    }
}
