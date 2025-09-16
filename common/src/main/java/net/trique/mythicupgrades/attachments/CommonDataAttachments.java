package net.trique.mythicupgrades.attachments;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.trique.mythicupgrades.platform.Services;

import java.util.*;

public class CommonDataAttachments {

    private static final Map<ResourceLocation,CommonDataAttachment<?>> MAP =new HashMap<>();

    public static final CommonDataAttachment<Boolean> EXCAVATING = register(CommonDataAttachment.create(o -> false).build("excavating"));

    public static CommonDataAttachment<?> lookup(ResourceLocation location) {
        return MAP.get(location);
    }

    static <T> CommonDataAttachment<T> register(CommonDataAttachment<T> type) {
        Services.PLATFORM.registerDataAttachment(type);
        Objects.requireNonNull(type.getAttachment());
        MAP.put(type.name,type);
        return type;
    }

    public static void setExcavating(Player player,boolean excavating) {
        Services.PLATFORM.setAttachedValue(player,EXCAVATING,excavating);
    }

    public static void init() {

    }
}
