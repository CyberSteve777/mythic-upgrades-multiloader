package net.trique.mythicupgrades.attachments;

import com.mojang.serialization.Codec;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.trique.mythicupgrades.platform.Services;

import java.util.*;

public class CommonDataAttachments {

    private static final Map<ResourceLocation,CommonDataAttachment<?>> MAP =new HashMap<>();

    public static final CommonDataAttachment<Boolean> EXCAVATING = register(CommonDataAttachment.create(o -> false).build("excavating"));

    public static final CommonDataAttachment<Boolean> ALTERNATIVE_RUBY_ABILITY =
            register(CommonDataAttachment.create(o -> false)
                    .copyOnDeath()
                    .codec(Codec.BOOL)
                    .networkSynchronized(ByteBufCodecs.BOOL)
                    .build("alternative_ruby_ability"));

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

    public static void toggleRubyAbility(Player player) {
        Services.PLATFORM.setAttachedValue(player,ALTERNATIVE_RUBY_ABILITY,!useAlternativeRubyAbility(player));
    }

    public static boolean useAlternativeRubyAbility(LivingEntity player) {
        return Services.PLATFORM.getOrCreateAttachedValue(player,ALTERNATIVE_RUBY_ABILITY);
    }

    public static void init() {

    }
}
