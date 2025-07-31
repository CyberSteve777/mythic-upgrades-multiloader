package net.trique.mythicupgrades.networking.packet.particle;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;

public record PercentAnimationPacket(int Id) implements CustomPacketPayload {
    public static final Type<PercentAnimationPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID,
                    "play_percent_particle"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, PercentAnimationPacket> CODEC = StreamCodec.ofMember(
            PercentAnimationPacket::writeId, PercentAnimationPacket::new
    );

    public PercentAnimationPacket(FriendlyByteBuf buf) {
        this(buf.readVarInt());
    }

    public void writeId(FriendlyByteBuf buf) {
        buf.writeVarInt(Id);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
