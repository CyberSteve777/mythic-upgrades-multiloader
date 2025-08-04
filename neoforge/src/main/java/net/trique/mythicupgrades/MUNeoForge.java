package net.trique.mythicupgrades;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforgespi.locating.IModFile;
import net.trique.mythicupgrades.client.HiResPackSource;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.loot.ModLootModifiers;
import net.trique.mythicupgrades.networking.packet.config.*;
import net.trique.mythicupgrades.networking.packet.particle.PercentAnimationPacket;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.registry.ParticleRegistry;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;


@Mod(Constants.MOD_ID)
public class MUNeoForge {

    public MUNeoForge(IEventBus eventBus) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, MUConfig.CONFIG_SPEC);
        // Use NeoForge to bootstrap the Common mod.
        Constants.LOGGER.info("Hello NeoForge world!");
        MUCommon.init();
        ModLootModifiers.register(eventBus);
        eventBus.addListener(this::setupPackets);
        IModFile modFile = ModLoadingContext.get().getActiveContainer().getModInfo().getOwningFile().getFile();
        eventBus.addListener((AddPackFindersEvent event) -> {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                event.addRepositorySource(new HiResPackSource(modFile, PackType.CLIENT_RESOURCES, "32x", Component.translatable("pack.mythicupgrades.32x")));
            }
        });
//        NeoForge.EVENT_BUS.addListener(this::syncOnJoin);
        if (Services.PLATFORM.isClient()) {
            ModLoadingContext.get().getActiveContainer().registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }

    private void setupPackets(final RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(Constants.MOD_ID).versioned("1.0.0").optional();
        registrar.playToClient(PercentAnimationPacket.TYPE, PercentAnimationPacket.CODEC, (message, context) -> {
            context.enqueueWork(() -> {
                Player player = context.player();
                if (player.level().getEntity(message.Id()) instanceof Entity entity) {
                    Minecraft.getInstance().particleEngine.createTrackingEmitter(entity, ParticleRegistry.PERCENT_PARTICLE.get());
                }
            });
        });
        registrar.playBidirectional(AquamarineConfigPacket.TYPE, AquamarineConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateAquamarineValues(packet);
                else MUConfigHelper.cachePlayerAquamarineValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(PeridotConfigPacket.TYPE, PeridotConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updatePeridotValues(packet);
                else MUConfigHelper.cachePlayerPeridotValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(TopazConfigPacket.TYPE, TopazConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateTopazValues(packet);
                else MUConfigHelper.cachePlayerTopazValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(SapphireConfigPacket.TYPE, SapphireConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateSapphireValues(packet);
                else MUConfigHelper.cachePlayerSapphireValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(RubyConfigPacket.TYPE, RubyConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateRubyValues(packet);
                else MUConfigHelper.cachePlayerRubyValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(JadeConfigPacket.TYPE, JadeConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateJadeValues(packet);
                else MUConfigHelper.cachePlayerJadeValues(ctx.player().getUUID(), packet);
            });
        }));
        registrar.playBidirectional(AmetrineConfigPacket.TYPE, AmetrineConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> {
                if (Services.PLATFORM.isClient()) MUConfigHelper.updateAmetrineValues(packet);
                else MUConfigHelper.cachePlayerAmetrineValues(ctx.player().getUUID(), packet);
            });
        }));
    }
}