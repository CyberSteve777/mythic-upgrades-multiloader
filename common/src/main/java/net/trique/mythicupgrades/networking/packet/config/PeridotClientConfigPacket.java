package net.trique.mythicupgrades.networking.packet.config;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

import java.util.UUID;

public record PeridotClientConfigPacket(UUID playerId,
                                        int tools_effects_amplifier,
                                        double tools_poison_duration,
                                        double tools_nausea_duration,
                                        int poisonous_thorns_amplifier,
                                        double poisonous_thorns_poison_duration,
                                        double poisonous_thorns_nausea_duration) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<PeridotClientConfigPacket> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID, "peridot_client_config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, PeridotClientConfigPacket> CODEC = StreamCodec.ofMember(
            PeridotClientConfigPacket::write, PeridotClientConfigPacket::new
    );

    public PeridotClientConfigPacket(FriendlyByteBuf buf) {
        this(buf.readUUID(), buf.readInt(), buf.readDouble(), buf.readDouble(),
                buf.readInt(), buf.readDouble(), buf.readDouble());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUUID(playerId);
        buf.writeInt(tools_effects_amplifier);
        buf.writeDouble(tools_poison_duration);
        buf.writeDouble(tools_nausea_duration);
        buf.writeInt(poisonous_thorns_amplifier);
        buf.writeDouble(poisonous_thorns_poison_duration);
        buf.writeDouble(poisonous_thorns_nausea_duration);
    }



    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
