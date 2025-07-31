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
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, MUConfig.CONFIG_SPEC);
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
        registrar.playToClient(AquamarineConfigPacket.TYPE, AquamarineConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateAquamarineValues(packet));
        }));
        registrar.playToClient(PeridotConfigPacket.TYPE, PeridotConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updatePeridotValues(packet));
        }));
        registrar.playToClient(TopazConfigPacket.TYPE, TopazConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateTopazValues(packet));
        }));
        registrar.playToClient(SapphireConfigPacket.TYPE, SapphireConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateSapphireValues(packet));
        }));
        registrar.playToClient(RubyConfigPacket.TYPE, RubyConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateRubyValues(packet));
        }));
        registrar.playToClient(JadeConfigPacket.TYPE, JadeConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateJadeValues(packet));
        }));
        registrar.playToClient(AmetrineConfigPacket.TYPE, AmetrineConfigPacket.CODEC, ((packet, ctx) -> {
            ctx.enqueueWork(() -> MUConfigHelper.updateAmetrineValues(packet));
        }));
    }

    private void syncOnJoin(final PlayerEvent.PlayerLoggedInEvent event) {
        AmetrineConfigPacket ametrineConfigPacket = new AmetrineConfigPacket(
                CONFIG.tools_levitation_duration.get(),
                CONFIG.tools_levitation_amplifier.get(),
                CONFIG.arcane_aura_levitation_duration.get(),
                CONFIG.arcane_aura_amplifier.get()
        );
        JadeConfigPacket jadeConfigPacket = new JadeConfigPacket(
                CONFIG.tools_bouncer_jump_boost_duration.get(),
                CONFIG.tools_bouncer_amplifier.get(),
                CONFIG.speed_amplifier.get(),
                CONFIG.jump_boost_amplifier.get()
        );
        RubyConfigPacket rubyConfigPacket = new RubyConfigPacket(
                CONFIG.tools_haste_amplifier.get(),
                CONFIG.spelunker_amplifier.get()
        );
        SapphireConfigPacket sapphireConfigPacket = new SapphireConfigPacket(
                CONFIG.tools_percentage_damage_percent.get(),
                CONFIG.damage_deflection_amplifier.get()
        );
        TopazConfigPacket topazConfigPacket = new TopazConfigPacket(
                CONFIG.topaz_tools_fire_seconds.get(),
                CONFIG.item_mastery_amplifier.get()
        );
        AquamarineConfigPacket aquamarineConfigPacket = new AquamarineConfigPacket(
                CONFIG.tools_freeze_duration.get(),
                CONFIG.ice_shield_slowness_duration.get(),
                CONFIG.ice_shield_amplifier.get()
        );
        PeridotConfigPacket peridotConfigPacket = new PeridotConfigPacket(
                CONFIG.tools_effects_amplifier.get(),
                CONFIG.tools_poison_duration.get(),
                CONFIG.tools_nausea_duration.get(),
                CONFIG.poisonous_thorns_amplifier.get(),
                CONFIG.poisonous_thorns_poison_duration.get(),
                CONFIG.poisonous_thorns_nausea_duration.get()
        );

        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null && server.isDedicatedServer() && event.getEntity() instanceof
                ServerPlayer player) {
            PacketDistributor.sendToPlayer(player, aquamarineConfigPacket);
            PacketDistributor.sendToPlayer(player, topazConfigPacket);
            PacketDistributor.sendToPlayer(player, peridotConfigPacket);
            PacketDistributor.sendToPlayer(player, rubyConfigPacket);
            PacketDistributor.sendToPlayer(player, sapphireConfigPacket);
            PacketDistributor.sendToPlayer(player, jadeConfigPacket);
            PacketDistributor.sendToPlayer(player, ametrineConfigPacket);
        }
    }
}