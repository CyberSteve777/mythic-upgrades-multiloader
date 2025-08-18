package net.trique.mythicupgrades;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientLoginConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.networking.packet.MUConfigPacket;
import net.trique.mythicupgrades.networking.packet.PercentAnimationPacket;
import net.trique.mythicupgrades.particle.PercentParticle;
import net.trique.mythicupgrades.registry.ParticleRegistry;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.client.ConfigScreenFactoryRegistry;

import java.util.List;
import static net.trique.mythicupgrades.registry.BlockRegistry.*;

@Environment(EnvType.CLIENT)
public class MUFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ParticleRegistry.PERCENT_PARTICLE.get(), PercentParticle.Provider::new);
        for (Block crystal: List.of(AMETRINE_CRYSTAL_CLUSTER.get(), AQUAMARINE_CRYSTAL_CLUSTER.get(),
                JADE_CRYSTAL_CLUSTER.get(), PERIDOT_CRYSTAL_CLUSTER.get(), RUBY_CRYSTAL_CLUSTER.get(),
                SAPPHIRE_CRYSTAL_CLUSTER.get(), TOPAZ_CRYSTAL_CLUSTER.get())) {
            BlockRenderLayerMap.INSTANCE.putBlock(crystal, RenderType.cutout());
        }
        ClientPlayNetworking.registerGlobalReceiver(PercentAnimationPacket.TYPE, (payload, context) -> {
            LocalPlayer player = context.player();
            if (player != null && player.level().getEntity(payload.Id()) instanceof Entity entity) {
                context.client().particleEngine.createTrackingEmitter(entity, ParticleRegistry.PERCENT_PARTICLE.get());
            }
        });
        addConfigPacketsReceivers();
        ClientLoginConnectionEvents.INIT.register(((handler, client) -> {
            MUConfigHelper.cacheValuesBeforeJoin();
        }));
        ClientLoginConnectionEvents.DISCONNECT.register(((handler, client) -> {
            MUConfigHelper.restoreClientValues();
        }));
        ClientTickEvents.START_CLIENT_TICK.register((client ->
                SpelunkerEffectRenderer.clientFillRenderPositions(client.player)));
        WorldRenderEvents.AFTER_TRANSLUCENT.register(worldRenderContext ->
                SpelunkerEffectRenderer.renderOres(worldRenderContext.matrixStack()));
        ConfigScreenFactoryRegistry.INSTANCE.register(Constants.MOD_ID, ConfigurationScreen::new);
    }

    public static void addConfigPacketsReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(MUConfigPacket.TYPE, ((payload, context) -> {
            MUConfigHelper.updateValuesOnJoin(payload);
        }));
    }
}
