package net.trique.mythicupgrades.networking.packet;


import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.util.ClientFunctions;

public record S2CPercentAnimationPacket(int Id) implements S2CModPacket<RegistryFriendlyByteBuf> {
    public static final Type<S2CPercentAnimationPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID,
                    "play_percent_particle"
            )
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, S2CPercentAnimationPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,S2CPercentAnimationPacket::Id, S2CPercentAnimationPacket::new
    );


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override
    public void handleClient() {
        ClientFunctions.handlePercentPacket(this);
    }
}
