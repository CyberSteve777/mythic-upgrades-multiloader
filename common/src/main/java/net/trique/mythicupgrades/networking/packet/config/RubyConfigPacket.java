package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record RubyConfigPacket(int tools_haste_amplifier,
                               int spelunker_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RubyConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "ruby_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, RubyConfigPacket> CODEC = StreamCodec.ofMember(
            RubyConfigPacket::write, RubyConfigPacket::new
    );

    public RubyConfigPacket(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(tools_haste_amplifier);
        buf.writeInt(spelunker_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
