package net.trique.mythicupgrades.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

import static net.trique.mythicupgrades.registry.ParticleRegistry.*;

public class MUParticleDescriptionProvider extends ParticleDescriptionProvider {
    protected MUParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        sprite(PERCENT_PARTICLE.get(), PERCENT_PARTICLE.getId());
    }
}
