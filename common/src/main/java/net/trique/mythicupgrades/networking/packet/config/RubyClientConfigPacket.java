package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record RubyClientConfigPacket(UUID playerId,
                                     int tools_haste_amplifier,
                                     int spelunker_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RubyClientConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "ruby_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, RubyClientConfigPacket> CODEC = StreamCodec.ofMember(
            RubyClientConfigPacket::write, RubyClientConfigPacket::new
    );

    public RubyClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeInt(tools_haste_amplifier);
        buf.writeInt(spelunker_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
