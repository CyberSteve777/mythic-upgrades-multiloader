package net.trique.mythicupgrades.util.veinmine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.attachments.CommonDataAttachments;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * credit to <a href="https://github.com/qyl27/DiggusMaximus/tree/1.21.1">...</a>
 */
public class VeinMine {
    private final BlockPos startPos;
    private final Player player;
    private ResourceLocation startID;
    private final Item startTool;
    private int mined = 0;
    private final Level world;
    private final Deque<BlockPos> points = new ArrayDeque<>();

    private final Direction facing;
    private int shapeSelection = -1;

    private static final int airHash = ResourceLocation.withDefaultNamespace("air").hashCode();

    public VeinMine(BlockPos pos, ResourceLocation blockID, Player player, Direction facing) {
        this.startPos = pos;
        this.player = player;
        this.world = player.level();
        this.startID = blockID;
        this.startTool = player.getMainHandItem().getItem();
        this.facing = facing;
    }

    public void startExcavate(int shapeSelection) {
        this.shapeSelection = shapeSelection;
        forceExcavateAt(startPos);
        if (startID == null) return;
        CommonDataAttachments.setExcavating(player,true);
        while (!points.isEmpty()) {
            spread(points.remove());
        }
        CommonDataAttachments.setExcavating(player,false);
    }

    private void spread(BlockPos pos) {
        for (BlockPos dirPos : VeinMineTypes.getSpreadType(shapeSelection, facing, startPos, pos)) {
            if (VeinMineHelper.isValidPos(dirPos))
                excavateAt(pos.offset(dirPos));
        }
    }

    private void excavateAt(BlockPos pos) {
        if (mined >= VeinMineHelper.maxMined) return;
        ResourceLocation block = BuiltInRegistries.BLOCK.getKey(VeinMineHelper.getBlockAt(world, pos));
        if (block.hashCode() != airHash && VeinMineHelper.isTheSameBlock(startID, block, world, shapeSelection) && VeinMineHelper.canMine(player, startTool, world, startPos, pos) && isExcavatingAllowed(pos)) {
            forceExcavateAt(pos);
        }
    }

    private boolean isExcavatingAllowed(BlockPos pos) {
        return /*PlayerBlockBreakEvents.BEFORE.invoker().beforeBlockBreak(world, player, pos, world.getBlockState(pos), world.getBlockEntity(pos)) &&*/
                ((ServerPlayer) player).gameMode.destroyBlock(pos);
    }

    private void forceExcavateAt(BlockPos pos) {
        points.add(pos);
        mined++;
        VeinMineHelper.pickupDrops(world, pos, player);
    }
}
