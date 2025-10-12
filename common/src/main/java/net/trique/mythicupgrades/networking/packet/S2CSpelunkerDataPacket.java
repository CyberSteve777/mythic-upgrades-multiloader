package net.trique.mythicupgrades.networking.packet;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.trique.mythicupgrades.util.CommonFunctions;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;
import net.trique.mythicupgrades.util.spelunker.ChunkOres;

import java.util.List;

public record S2CSpelunkerDataPacket(boolean overwrite, List<BlockPos> remove, List<ChunkOres> add) implements S2CModPacket<RegistryFriendlyByteBuf> {

    public static final Type<S2CSpelunkerDataPacket> TYPE = new Type<>(CommonFunctions.getLoc("ore_chunks"));

    public static final StreamCodec<RegistryFriendlyByteBuf,S2CSpelunkerDataPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,S2CSpelunkerDataPacket::overwrite,
            BlockPos.STREAM_CODEC.apply(ByteBufCodecs.list()),S2CSpelunkerDataPacket::remove,
            ChunkOres.STREAM_CODEC.apply(ByteBufCodecs.list()),S2CSpelunkerDataPacket::add,S2CSpelunkerDataPacket::new
    );

    //    public static void readPacket(SpelunkerEffectRenderer renderer, PacketByteBuf buf) {
    //        boolean overwrite = buf.readBoolean();
    //
    //        c = buf.readVarInt();
    //        ArrayList<ChunkOres> chunks = new ArrayList<>(c);
    //        for (int i = 0; i < c; i++) {
    //            Vec3i pos = new Vec3i(
    //                    buf.readVarInt(),
    //                    buf.readVarInt(),
    //                    buf.readVarInt()
    //            );
    //
    //            ChunkOres ores = overwrite ? new ChunkOres(pos) : renderer.get(pos);
    //            int cc = buf.readVarInt();
    //            for (int j = 0; j < cc; j++) {
    //                Vec3i orePos = new Vec3i(
    //                        buf.readByte(),
    //                        buf.readByte(),
    //                        buf.readByte()
    //                );
    //                int blockId = buf.readVarInt();
    //
    //                if (ores != null)
    //                    ores.processConfig(orePos, blockId == -1 ? null : SpelunkerConfig.blockConfigs.get(Registries.BLOCK.get(blockId)), true);
    //            }
    //            if (overwrite)
    //                chunks.add(ores);
    //        }
    //
    //        if (overwrite) {
    //            int bottomSectionCord = buf.readVarInt();
    //            renderer.addChunks(bottomSectionCord, chunks);
    //        }
    //    }

    @Override
    public void handleClient() {
        remove.forEach(SpelunkerEffectRenderer::removeChunk);
        for(ChunkOres chunkOre :add) {
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
