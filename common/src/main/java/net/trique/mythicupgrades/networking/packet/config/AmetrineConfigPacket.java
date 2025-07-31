package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record AmetrineConfigPacket(double tools_levitation_duration,
                                   int tools_levitation_amplifier,
                                   double arcane_aura_levitation_duration,
                                   int arcane_aura_amplifier) implements CustomPacketPayload {
    public static final Type<AmetrineConfigPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "ametrine_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, AmetrineConfigPacket> CODEC = StreamCodec.ofMember(
            AmetrineConfigPacket::write, AmetrineConfigPacket::new
    );

    public AmetrineConfigPacket(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readInt(), buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(tools_levitation_duration);
        buf.writeInt(tools_levitation_amplifier);
        buf.writeDouble(arcane_aura_levitation_duration);
        buf.writeInt(arcane_aura_amplifier);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
