package net.trique.mythicupgrades.util;

import net.minecraft.util.ByIdMap;

import java.util.function.IntFunction;

public enum Target {
    IN_MAIN_HAND(0),
    ON_HIT_FOR_ENEMY(1),
    ON_HIT_FOR_SELF(2),
    ON_EQUIPMENT_FOR_SELF(3),
    ON_EQUIPMENT_FOR_ENEMY(4);

    private final int type;

    public static final IntFunction<Target> BY_ID =
            ByIdMap.continuous(Target::getType, values(), ByIdMap.OutOfBoundsStrategy.ZERO);


    Target(int t) {
        type = t;
    }

    public int getType() {
        return type;
    }
}