package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record SapphireConfigPacket(double tools_percentage_damage_percent,
                                   int damage_deflection_amplifier) implements CustomPacketPayload {
    public static final Type<SapphireConfigPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "sapphire_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, SapphireConfigPacket> CODEC = StreamCodec.ofMember(
            SapphireConfigPacket::write, SapphireConfigPacket::new
    );

    public SapphireConfigPacket(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(tools_percentage_damage_percent);
        buf.writeInt(damage_deflection_amplifier);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
