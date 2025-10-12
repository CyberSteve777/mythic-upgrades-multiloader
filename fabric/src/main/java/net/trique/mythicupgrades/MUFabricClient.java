package net.trique.mythicupgrades;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.trique.mythicupgrades.client.MUKeybinds;
import net.trique.mythicupgrades.config.MUClientConfig;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.mixin.LevelRendererAccess;
import net.trique.mythicupgrades.particle.PercentParticle;
import net.trique.mythicupgrades.registry.ParticleRegistry;
import net.trique.mythicupgrades.util.ClientFunctions;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.client.ConfigScreenFactoryRegistry;

import java.util.List;

import static net.trique.mythicupgrades.registry.BlockRegistry.*;

public class MUFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.CLIENT, MUClientConfig.CONFIG_SPEC);
        ParticleFactoryRegistry.getInstance().register(ParticleRegistry.PERCENT_PARTICLE.get(), PercentParticle.Provider::new);
        for (Block crystal: List.of(AMETRINE_CRYSTAL_CLUSTER.get(), AQUAMARINE_CRYSTAL_CLUSTER.get(),
                JADE_CRYSTAL_CLUSTER.get(), PERIDOT_CRYSTAL_CLUSTER.get(), RUBY_CRYSTAL_CLUSTER.get(),
                SAPPHIRE_CRYSTAL_CLUSTER.get(), TOPAZ_CRYSTAL_CLUSTER.get())) {
            BlockRenderLayerMap.INSTANCE.putBlock(crystal, RenderType.cutout());
        }
        ClientLoginConnectionEvents.INIT.register(((handler, client) -> {
        }));
        ClientLoginConnectionEvents.DISCONNECT.register(((handler, client) -> {
        }));
        ClientTickEvents.START_CLIENT_TICK.register((client -> ClientFunctions.handleClientTick()));
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            var worldRenderer = (LevelRendererAccess)context.worldRenderer();
            if (SpelunkerEffectRenderer.isActive())
                SpelunkerEffectRenderer.render(context.matrixStack(), context.camera(), worldRenderer.getRenderBuffers().outlineBufferSource());
        });

        ConfigScreenFactoryRegistry.INSTANCE.register(Constants.MOD_ID, ConfigurationScreen::new);
        KeyBindingHelper.registerKeyBinding(MUKeybinds.TOGGLE_RUBY_ABILITY);
    }
}
