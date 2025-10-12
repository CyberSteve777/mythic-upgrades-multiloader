package net.trique.mythicupgrades;


import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ConfigTracker;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforgespi.locating.IModFile;
import net.trique.mythicupgrades.attachments.CommonDataAttachments;
import net.trique.mythicupgrades.client.HiResPackSource;
import net.trique.mythicupgrades.config.MUClientConfig;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.loot.ModLootModifiers;
import net.trique.mythicupgrades.networking.packet.PacketHandler;
import net.trique.mythicupgrades.platform.NeoForgePlatformHelper;
import net.trique.mythicupgrades.platform.Services;


@Mod(Constants.MOD_ID)
public class MUNeoForge {

    public MUNeoForge(IEventBus eventBus, ModContainer container) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.
        NeoForgePlatformHelper.SYNCABLE_CONFIG = ConfigTracker.INSTANCE.registerConfig(ModConfig.Type.SERVER, MUConfig.CONFIG_SPEC,container);
        container.registerConfig(ModConfig.Type.CLIENT, MUClientConfig.CONFIG_SPEC);
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
        eventBus.addListener(this::registerAttachments);
//        NeoForge.EVENT_BUS.addListener(this::syncOnJoin);
        if (Services.PLATFORM.isClient()) {
            ModLoadingContext.get().getActiveContainer().registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }

    private void registerAttachments(RegisterEvent event) {
        CommonDataAttachments.init();
    }

    private void setupPackets(final RegisterPayloadHandlersEvent event) {
        NeoForgePlatformHelper.registrar = event.registrar(Constants.MOD_ID).versioned("1").optional();
        PacketHandler.registerPackets();
    }
}