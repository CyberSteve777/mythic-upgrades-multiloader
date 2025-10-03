package net.trique.mythicupgrades.util.spelunker;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.phys.Vec3;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.mixin.ChunkMapAccess;

import java.util.HashMap;

public class SpelunkerEffectManager {

    public static ChunkOres findOresInChunk(Level world, BlockPos sectionPos) {
        ChunkAccess chunk = null;
        if (world.getChunkSource().hasChunk(sectionPos.getX(), sectionPos.getZ())) {
            if (world instanceof ServerLevel sw) {
                ChunkHolder chunkHolder = ((ChunkMapAccess) sw.getChunkSource().chunkMap)
                        .$getVisibleChunkIfPresent(ChunkPos.asLong(sectionPos.getX(), sectionPos.getZ())); // prevent random server crash ¯\_(ツ)_/¯
                if (chunkHolder != null)
                    chunk = chunkHolder.getTickingChunk();
            } else {
                chunk = world.getChunk(sectionPos.getX(), sectionPos.getZ(), ChunkStatus.FULL, false);
            }
        }
        if (chunk == null)
            return ChunkOres.EMPTY;
        LevelChunkSection section = chunk.getSection(sectionPos.getY());
        ChunkOres ores = new ChunkOres(sectionPos);
        var blockStates = section.getStates();
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (int z = 0; z < 16; z++) {
                    Block block = blockStates.get(x, y, z).getBlock();
                    String tag = MUConfig.findTag(block);
                    if (tag != null) {
                        BlockPos blockPos = new BlockPos(x, y, z);
                        ores.put(blockPos, MUConfig.CONFIG.block_configs.get().get(tag));
                    }
                }
            }
        }
        return ores;
    }

    public static HashMap<BlockPos, LevelChunkSection> getSurroundingChunkSections(Level world, Vec3 playerPos) {
        int cx = SectionPos.posToSectionCoord(playerPos.x);
        int cy = world.getSectionIndexFromSectionY(SectionPos.posToSectionCoord(playerPos.y));
        int cz = SectionPos.posToSectionCoord(playerPos.z);

        int chunkRadius = MUConfig.CONFIG.chunk_radius.get();
        HashMap<BlockPos, LevelChunkSection> sections = new HashMap<>();
        for (int x = cx - chunkRadius; x < cx + chunkRadius + 1; x++) {
            for (int z = cz - chunkRadius; z < cz + chunkRadius + 1; z++) {
                for (int y = cy - chunkRadius; y < cy + chunkRadius + 1; y++) {
                    LevelChunk chunk = world.getChunk(x, z);
                    LevelChunkSection[] sectionArray = chunk.getSections();
                    if (y < 0 || y >= sectionArray.length)
                        continue;
                    sections.put(new BlockPos(x, y, z), sectionArray[y]);
                }
            }
        }
        return sections;
    }

}
