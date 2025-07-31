package net.trique.mythicupgrades.platform;

import net.minecraft.core.particles.SimpleParticleType;
import net.trique.mythicupgrades.platform.services.IParticleHelper;

public class NeoForgeParticleHelper implements IParticleHelper {
    @Override
    public SimpleParticleType getSimpleParticle() {
        return new SimpleParticleType(false);
    }
}
