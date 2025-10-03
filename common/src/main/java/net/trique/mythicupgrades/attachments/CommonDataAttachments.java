package net.trique.mythicupgrades.attachments;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
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

    ///transient attachments, don't sync or save

    public static final CommonDataAttachment<HashSet<BlockPos>> SPELUNKER_POS =
            register(CommonDataAttachment.<HashSet<BlockPos>>create(o -> new HashSet<>())
                    .build("spelunker_pos"));

    public static final CommonDataAttachment<Boolean> FORCE_ORE_CHUNK_UPDATE =
            register(CommonDataAttachment.create(o -> false)
                    .build("force_ore_chunk_update"));

    public static final CommonDataAttachment<Vec3i> LAST_CHUNK =
            register(CommonDataAttachment.<Vec3i>create(o -> Vec3i.ZERO)
                    .build("last_chunk"));

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
