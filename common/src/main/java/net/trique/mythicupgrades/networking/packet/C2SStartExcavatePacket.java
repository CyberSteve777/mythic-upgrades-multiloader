package net.trique.mythicupgrades.networking.packet;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.trique.mythicupgrades.util.CommonFunctions;
import net.trique.mythicupgrades.util.veinmine.Excavate;

public record C2SStartExcavatePacket(BlockPos pos, ResourceLocation id, Direction facing, int shape) implements C2SModPacket<RegistryFriendlyByteBuf> {

    public static final ResourceLocation IDENTIFIER = CommonFunctions.getLoc("start_excavate_packet");

    public static final Type<C2SStartExcavatePacket> PACKET_ID = new Type<>(IDENTIFIER);

    public static final StreamCodec<RegistryFriendlyByteBuf, C2SStartExcavatePacket>
            CODEC = StreamCodec.composite(
                    BlockPos.STREAM_CODEC,C2SStartExcavatePacket::pos,
            ResourceLocation.STREAM_CODEC,C2SStartExcavatePacket::id,
            Direction.STREAM_CODEC,C2SStartExcavatePacket::facing,
            ByteBufCodecs.INT,C2SStartExcavatePacket::shape,
            C2SStartExcavatePacket::new);

    @Override
    public void handleServer(ServerPlayer player) {
        if (pos.closerThan(player.blockPosition(), 10)) {
            new Excavate(pos, id, player, facing).startExcavate(shape);
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return PACKET_ID;
    }

    public static void sendExcavatePacket(BlockPos pos, ResourceLocation id, Direction facing, int shape) {
        PacketHandler.sendToServer(new C2SStartExcavatePacket(pos, id, facing, shape));
    }
}