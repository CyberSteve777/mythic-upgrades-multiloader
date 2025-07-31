package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record TopazConfigPacket(double topaz_tools_fire_seconds,
                                int item_mastery_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TopazConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "topaz_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, TopazConfigPacket> CODEC = StreamCodec.ofMember(
            TopazConfigPacket::write, TopazConfigPacket::new
    );

    public TopazConfigPacket(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(topaz_tools_fire_seconds);
        buf.writeInt(item_mastery_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
