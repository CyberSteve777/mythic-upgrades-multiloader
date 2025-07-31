package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record AquamarineConfigPacket(double tools_freeze_duration,
                                     double ice_shield_slowness_duration,
                                     int ice_shield_amplifier) implements CustomPacketPayload {
    public static final Type<AquamarineConfigPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "aquamarine_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, AquamarineConfigPacket> CODEC = StreamCodec.ofMember(
            AquamarineConfigPacket::write, AquamarineConfigPacket::new
    );

    public AquamarineConfigPacket(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(tools_freeze_duration);
        buf.writeDouble(ice_shield_slowness_duration);
        buf.writeInt(ice_shield_amplifier);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
