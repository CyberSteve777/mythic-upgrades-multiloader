package net.trique.mythicupgrades.util.spelunker;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.Block;
import net.trique.mythicupgrades.config.MUConfig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChunkOres extends ConcurrentHashMap<BlockPos, MUConfig.ChunkBlockConfig> {
        public static final ChunkOres EMPTY;
        private final BlockPos pos;
        private boolean remapped = false;
        private int bottomSectionCord;

        public static final StreamCodec<RegistryFriendlyByteBuf,ChunkOres> STREAM_CODEC = new StreamCodec<>() {


            //   boolean overwrite = buf.readBoolean();
            //        int c = buf.readVarInt();
            //        for (int i = 0; i < c; i++) {
            //            SpelunkerEffectRenderer.removeChunk(new Vec3i(
            //                    buf.readVarInt(),
            //                    buf.readVarInt(),
            //                    buf.readVarInt()
            //            ));
            //        }
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
            //            ChunkOres ores = overwrite ? new ChunkOres(pos) : SpelunkerEffectRenderer.get(pos);
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
            //                    ores.processConfig(orePos, blockId == -1 ? null : MUConfig.CONFIG.block_configs.get().get(BuiltInRegistries.BLOCK.byId(blockId)), true);
            //            }
            //            if (overwrite)
            //                chunks.add(ores);
            //        }
            //
            //        if (overwrite) {
            //            int bottomSectionCord = buf.readVarInt();
            //            SpelunkerEffectRenderer.addChunks(bottomSectionCord, chunks);
            //        }

            @Override
            public ChunkOres decode(RegistryFriendlyByteBuf buffer) {

                BlockPos pos1 = BlockPos.STREAM_CODEC.decode(buffer);
                ChunkOres chunkOres = new ChunkOres(pos1);
                int size = buffer.readInt();
                for (int i = 0; i < size;i++) {
                    BlockPos pos2 = BlockPos.STREAM_CODEC.decode(buffer);
                    var config = MUConfig.ChunkBlockConfig.STREAM_CODEC.decode(buffer);
                    chunkOres.put(pos2,config);
                }

                return chunkOres;
            }


            //        buf.writeVarInt(add.size());
            //        for (ChunkOres ores : add) {
            //            BlockPos pos = ores.getPos();
            //            buf.writeVarInt(pos.getX());
            //            buf.writeVarInt(pos.getY());
            //            buf.writeVarInt(pos.getZ());
            //
            //            buf.writeVarInt(ores.size());
            //            for (Map.Entry<BlockPos, MUConfig.ChunkBlockConfig> ore : ores.entrySet()) {
            //                Vec3i orePos = ore.getKey();
            //                buf.writeByte(orePos.getX());
            //                buf.writeByte(orePos.getY());
            //                buf.writeByte(orePos.getZ());
            //
            //                MUConfig.ChunkBlockConfig conf = ore.getValue();
            //                buf.writeVarInt(MUConfig.NONE_BLOCK_CONFIG == conf ? -1 : BuiltInRegistries.BLOCK.getId(conf.getBlock()));
            //            }
            //        }

            @Override
            public void encode(RegistryFriendlyByteBuf buffer, ChunkOres value) {
                BlockPos.STREAM_CODEC.encode(buffer,value.pos);
                buffer.writeInt(value.entrySet().size());
                for (Map.Entry<BlockPos,MUConfig.ChunkBlockConfig> entry : value.entrySet()) {
                    BlockPos.STREAM_CODEC.encode(buffer,entry.getKey());
                    MUConfig.ChunkBlockConfig.STREAM_CODEC.encode(buffer,entry.getValue());
                }
            }
        };

    public ChunkOres(BlockPos pos) {
            this.pos = pos;
        }

        public BlockPos getPos() {
            return this.pos;
        }

        public void processConfig(BlockPos pos, MUConfig.ChunkBlockConfig conf, boolean localPos) {
            if (this.remapped && localPos) {
                pos = toBlockCoord(pos, this.pos, this.bottomSectionCord);
            } else if (!this.remapped && !localPos) {
                pos = toLocalCoord(pos);
            }

            if (conf == null) {
                this.remove(pos);
            } else {
                this.put(pos, conf);
            }

        }

        public ChunkOres remapToBlockCoordinates(int bottomSectionCord) {
            this.remapped = true;
            this.bottomSectionCord = bottomSectionCord;
            HashMap<BlockPos, MUConfig.ChunkBlockConfig> clone = new HashMap<>(this);
            this.clear();

            for (Map.Entry<BlockPos, MUConfig.ChunkBlockConfig> vec3iChunkBlockConfigEntry : clone.entrySet()) {
                Map.Entry<BlockPos, MUConfig.ChunkBlockConfig> pair = vec3iChunkBlockConfigEntry;
                this.put(toBlockCoord(pair.getKey(), this.pos, bottomSectionCord), pair.getValue());
            }

            return this;
        }

        public static BlockPos toLocalCoord(Vec3i blockPos) {
            return new BlockPos(SectionPos.sectionRelative(blockPos.getX()), SectionPos.sectionRelative(blockPos.getY()), SectionPos.sectionRelative(blockPos.getZ()));
        }

        public static BlockPos toBlockCoord(BlockPos localPos, BlockPos sectionPos, int bottomSectionCord) {
            return new BlockPos(SectionPos.sectionToBlockCoord(sectionPos.getX()) + localPos.getX(), SectionPos.sectionToBlockCoord(sectionPos.getY() + bottomSectionCord) + localPos.getY(), SectionPos.sectionToBlockCoord(sectionPos.getZ()) + localPos.getZ());
        }

        static {
            EMPTY = new ChunkOres(BlockPos.ZERO);
        }
}
