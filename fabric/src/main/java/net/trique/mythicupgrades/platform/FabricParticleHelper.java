package net.trique.mythicupgrades.platform;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.trique.mythicupgrades.platform.services.IParticleHelper;

public class FabricParticleHelper implements IParticleHelper {
    @Override
    public SimpleParticleType getSimpleParticle() {
        return FabricParticleTypes.simple();
    }
}
