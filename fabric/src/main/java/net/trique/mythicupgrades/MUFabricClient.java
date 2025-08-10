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
import net.trique.mythicupgrades.networking.packet.config.*;
import net.trique.mythicupgrades.networking.packet.particle.PercentAnimationPacket;
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
            MUConfigHelper.cachePlayerTopazValues();
            MUConfigHelper.cachePlayerAquamarineValues();
            MUConfigHelper.cachePlayerPeridotValues();
            MUConfigHelper.cachePlayerSapphireValues();
            MUConfigHelper.cachePlayerRubyValues();
            MUConfigHelper.cachePlayerJadeValues();
            MUConfigHelper.cachePlayerAmetrineValues();
        }));
        ClientLoginConnectionEvents.DISCONNECT.register(((handler, client) -> {
            MUConfigHelper.updatePeridotValues(MUConfigHelper.getPlayerPeridotCache());
            MUConfigHelper.updateTopazValues(MUConfigHelper.getPlayerTopazCache());
            MUConfigHelper.updateAquamarineValues(MUConfigHelper.getPlayerAquamarineCache());
            MUConfigHelper.updateSapphireValues(MUConfigHelper.getPlayerSapphireCache());
            MUConfigHelper.updateRubyValues(MUConfigHelper.getPlayerRubyCache());
            MUConfigHelper.updateJadeValues(MUConfigHelper.getPlayerJadePacket());
            MUConfigHelper.updateAmetrineValues(MUConfigHelper.getPlayerAmetrinePacket());
        }));
        ClientTickEvents.START_CLIENT_TICK.register((client ->
                SpelunkerEffectRenderer.clientFillRenderPositions(client.player)));
        WorldRenderEvents.AFTER_TRANSLUCENT.register(worldRenderContext ->
                SpelunkerEffectRenderer.renderOres(worldRenderContext.matrixStack()));
        ConfigScreenFactoryRegistry.INSTANCE.register(Constants.MOD_ID, ConfigurationScreen::new);
    }

    public static void addConfigPacketsReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(AquamarineConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updateAquamarineValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(TopazConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updateTopazValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(PeridotConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updatePeridotValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(RubyConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updateRubyValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(SapphireConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updateSapphireValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(JadeConfigPacket.TYPE, ((payload, context) ->
                MUConfigHelper.updateJadeValues(payload)));
        ClientPlayNetworking.registerGlobalReceiver(AmetrineConfigPacket.TYPE, (payload, context) ->
                MUConfigHelper.updateAmetrineValues(payload));
    }
}
