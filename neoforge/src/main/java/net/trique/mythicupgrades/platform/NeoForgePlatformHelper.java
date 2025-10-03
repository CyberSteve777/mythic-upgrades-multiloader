package net.trique.mythicupgrades.platform;

import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.network.ConfigSync;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.trique.mythicupgrades.attachments.CommonDataAttachment;
import net.trique.mythicupgrades.networking.packet.C2SModPacket;
import net.trique.mythicupgrades.networking.packet.S2CConfigFilePayload;
import net.trique.mythicupgrades.networking.packet.S2CModPacket;
import net.trique.mythicupgrades.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Function;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public boolean isClient() {
        return FMLEnvironment.dist.isClient();
    }

    @Override
    public <T> void registerDataAttachment(CommonDataAttachment<T> attachment) {
        AttachmentType.Builder<T> builder = AttachmentType.builder((Function<IAttachmentHolder, T>) (Object) attachment.getDefaultValueSupplier());
        if (attachment.getCodec() != null) {
            builder.serialize(attachment.getCodec());
        }
        if (attachment.isCopyOnDeath()) {
            builder.copyOnDeath();
        }
        if (attachment.canSync()) {
            builder.sync(attachment.getStreamCodec());
        }
        AttachmentType<T> type = builder.build();
        Registry.register(NeoForgeRegistries.ATTACHMENT_TYPES, attachment.getName(), type);
        attachment.setAttachment(type);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    @Nullable
    public <T> T getAttachedValue(Object object, CommonDataAttachment<T> attachment) {
        AttachmentType<T> type = (AttachmentType<T>) attachment.getAttachment();
        if (object instanceof IAttachmentHolder attachmentHolder) {
            return attachmentHolder.getData(type);
        } else {
            throw new IllegalStateException("Cannot attach data to " + object);
        }
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public <T> void setAttachedValue(Object object, CommonDataAttachment<T> attachment, @Nullable T value) {
        AttachmentType<T> type = (AttachmentType<T>) attachment.getAttachment();
        if (object instanceof IAttachmentHolder attachmentHolder) {
            if (value == null) {
                attachmentHolder.removeData(type);
            } else {
                attachmentHolder.setData(type, value);
            }
        } else {
            throw new IllegalStateException("Cannot attach data to " + object);
        }
    }

    public static PayloadRegistrar registrar;

    @Override
    public <MSG extends S2CModPacket<?>> void registerClientPlayPacket(CustomPacketPayload.Type<MSG> type, StreamCodec<RegistryFriendlyByteBuf, MSG> streamCodec) {
        registrar.playToClient(type, streamCodec, (p, t) -> p.handleClient());
    }

    @Override
    public <MSG extends C2SModPacket<?>> void registerServerPlayPacket(CustomPacketPayload.Type<MSG> type, StreamCodec<RegistryFriendlyByteBuf, MSG> streamCodec) {
        registrar.playToServer(type, streamCodec, (p, t) -> p.handleServer((ServerPlayer) t.player()));
    }


    @Override
    public void sendToClient(S2CModPacket<?> msg, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, msg);
    }

    @Override
    public void sendToServer(C2SModPacket<?> msg) {
        PacketDistributor.sendToServer(msg);
    }

    @Override
    public void receiveSyncedConfig(byte[] contents, String fileName) {
        ConfigSync.receiveSyncedConfig(contents, fileName);
    }

    public static ModConfig SYNCABLE_CONFIG;

    @Override
    public void sendSyncedConfig(MinecraftServer server) {
        try {
            var packet = new S2CConfigFilePayload(SYNCABLE_CONFIG.getFileName(), Files.readAllBytes(SYNCABLE_CONFIG.getFullPath()));
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                sendToClient(packet, player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}