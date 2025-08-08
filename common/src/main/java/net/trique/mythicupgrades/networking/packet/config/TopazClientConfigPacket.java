package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record TopazClientConfigPacket(UUID playerId, double topaz_tools_fire_seconds,
                                      int item_mastery_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TopazClientConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "topaz_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, TopazClientConfigPacket> CODEC = StreamCodec.ofMember(
            TopazClientConfigPacket::write, TopazClientConfigPacket::new
    );

    public TopazClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeDouble(topaz_tools_fire_seconds);
        buf.writeInt(item_mastery_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
