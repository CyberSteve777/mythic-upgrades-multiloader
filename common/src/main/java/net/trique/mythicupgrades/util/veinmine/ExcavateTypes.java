package net.trique.mythicupgrades.util.veinmine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExcavateTypes {
    public final static List<BlockPos> standard = new ArrayList<>();
    public final static List<BlockPos> standardDiag = new ArrayList<>();

    static {
        standard.add(new BlockPos(0, 1, 0));
        standard.add(new BlockPos(0, 0, 1));
        standard.add(new BlockPos(0, -1, 0));
        standard.add(new BlockPos(1, 0, 0));
        standard.add(new BlockPos(0, 0, -1));
        standard.add(new BlockPos(-1, 0, 0));

        standardDiag.addAll(BlockPos.betweenClosedStream(-1, -1, -1, 1, 1, 1).map(BlockPos::immutable).collect(Collectors.toList()));
    }

    public static List<BlockPos> getSpreadType(int shapeSelection, Direction facing, BlockPos startPos, BlockPos pos) {
        return ExcavateTypes.standard;
    }
}
