package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record SapphireClientConfigPacket(UUID playerId,
                                         double tools_percentage_damage_percent,
                                         int damage_deflection_amplifier) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SapphireClientConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "sapphire_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, SapphireClientConfigPacket> CODEC = StreamCodec.ofMember(
            SapphireClientConfigPacket::write, SapphireClientConfigPacket::new
    );

    public SapphireClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readDouble(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeDouble(tools_percentage_damage_percent);
        buf.writeInt(damage_deflection_amplifier);
    }


    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
