package net.trique.mythicupgrades.event;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.particle.PercentParticle;
import net.trique.mythicupgrades.registry.ParticleRegistry;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientRegistrationEventHandler {
    @SubscribeEvent
    public static void registerParticleProviders(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleRegistry.PERCENT_PARTICLE.get(), PercentParticle.Provider::new);
    }
}
