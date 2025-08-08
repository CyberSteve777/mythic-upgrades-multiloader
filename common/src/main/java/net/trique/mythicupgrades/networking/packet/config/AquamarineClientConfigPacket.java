package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record AquamarineClientConfigPacket(UUID playerId,
                                           double tools_freeze_duration,
                                           double ice_shield_slowness_duration,
                                           int ice_shield_amplifier) implements CustomPacketPayload {
    public static final Type<AquamarineClientConfigPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "aquamarine_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, AquamarineClientConfigPacket> CODEC = StreamCodec.ofMember(
            AquamarineClientConfigPacket::write, AquamarineClientConfigPacket::new
    );

    public AquamarineClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readDouble(), buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeDouble(tools_freeze_duration);
        buf.writeDouble(ice_shield_slowness_duration);
        buf.writeInt(ice_shield_amplifier);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
