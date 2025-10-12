package net.trique.mythicupgrades.util;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.trique.mythicupgrades.config.MUClientConfig;
import net.trique.mythicupgrades.config.MUConfig;
import net.trique.mythicupgrades.util.spelunker.ChunkOres;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class SpelunkerEffectRenderer {

    private static final ConcurrentMap<Vec3i, ChunkOres> chunkSections = new ConcurrentHashMap<>();
    private static boolean active = false;
    private static final ModelPart.Cube CUBE = new ModelPart.Cube(0, 0, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, 0.0F, 0.0F, 0.0F, false, 0.0F, 0.0F, EnumSet.allOf(Direction.class));
    private static final RenderType RENDER_LAYER = RenderType.outline(CommonFunctions.getLoc("textures/none.png"));

    public SpelunkerEffectRenderer() {
    }

    public static void render(PoseStack matrices, Camera camera, OutlineBufferSource vertexConsumers) {
        Vec3 pos = camera.getPosition();
        matrices.pushPose();
        matrices.translate(-pos.x, -pos.y, -pos.z);

        for (Map.Entry<Vec3i, ChunkOres> vec3iChunkOresEntry : chunkSections.entrySet()) {
            Map.Entry<Vec3i, ChunkOres> chunkSection = vec3iChunkOresEntry;
            renderChunk(chunkSection.getValue(), matrices, pos, vertexConsumers);
        }

        matrices.popPose();
    }

    public static boolean setActive(boolean value) {
        boolean init = value && !SpelunkerEffectRenderer.active;
        SpelunkerEffectRenderer.active = value;
        return init;
    }

    public static boolean isActive() {
        return SpelunkerEffectRenderer.active;
    }

    public static void clear() {
        chunkSections.clear();
    }

    public static void updateChunks(Level world, Collection<BlockPos> remove, Collection<ChunkOres> add) {
        for (Vec3i v : remove)
            chunkSections.remove(v);
        for (ChunkOres chunk : add) {
            chunkSections.put(chunk.getPos(), chunk
                    .remapToBlockCoordinates(world.getMinSection())
            );
        }
    }

    public static void removeChunk(Vec3i pos) {
        chunkSections.remove(pos);
    }

    public static ChunkOres get(Vec3i pos) {
        return chunkSections.get(pos);
    }

    public static void addChunks(int bottomSectionCord, Collection<ChunkOres> chunks) {

        for (ChunkOres chunk : chunks) {
            chunkSections.put(chunk.getPos(), chunk.remapToBlockCoordinates(bottomSectionCord));
        }

    }

    public static void renderChunk(ChunkOres chunk, PoseStack matrices, Vec3 playerPos, OutlineBufferSource vertexConsumers) {
        for (Map.Entry<BlockPos, MUConfig.ChunkBlockConfig> ore : chunk.entrySet()) {
            Vec3i pos = ore.getKey();
            double squareDistance = toSquaredDistanceFromCenter(pos, playerPos.x, playerPos.y, playerPos.z);
            MUConfig.ChunkBlockConfig block = ore.getValue();
            float fade;
            if (MUClientConfig.CONFIG.globalTransition.get() && block.isTransition()) {
                fade = Math.min(1 - (float) ((squareDistance - block.getBlockRadiusMin()) / (block.getBlockRadiusMax() - block.getBlockRadiusMin())), 1);
                fade = easeOutCirc(fade);
            } else fade = 1;
            matrices.pushPose();
            matrices.translate(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            matrices.scale(fade, fade, fade);
            {
                matrices.pushPose();
                matrices.translate(-0.5, -0.5, -0.5);
                CUBE.compile(matrices.last(), setOutlineColor(block.getColor(), vertexConsumers), 0, OverlayTexture.NO_OVERLAY, 0);
                matrices.popPose();
            }
            matrices.popPose();
        }
    }

    private static VertexConsumer setOutlineColor(int color, OutlineBufferSource vertexConsumers) {
        vertexConsumers.setColor(color >> 16 & 255, color >> 8 & 255, color & 255, 255);
        return vertexConsumers.getBuffer(RENDER_LAYER);
    }

    private static float easeOutCirc(float x) {
        return (float)Math.sqrt(1.0 - Math.pow(x - 1.0F, 2.0));
    }

    private static double toSquaredDistanceFromCenter(Vec3i pos, double x, double y, double z) {
        double d = (double)pos.getX() + 0.5 - x;
        double e = (double)pos.getY() + 0.5 - y;
        double f = (double)pos.getZ() + 0.5 - z;
        return d * d + e * e + f * f;
    }

}
