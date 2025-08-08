package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record JadeClientConfigPacket(UUID playerId,
                                     double tools_bouncer_jump_boost_duration,
                                     int tools_bouncer_amplifier,
                                     int speed_amplifier,
                                     int jump_boost_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<JadeClientConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "jade_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, JadeClientConfigPacket> CODEC = StreamCodec.ofMember(
            JadeClientConfigPacket::write, JadeClientConfigPacket::new
    );

    public JadeClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readDouble(), buf.readInt(), buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeDouble(tools_bouncer_jump_boost_duration);
        buf.writeInt(tools_bouncer_amplifier);
        buf.writeInt(speed_amplifier);
        buf.writeInt(jump_boost_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
