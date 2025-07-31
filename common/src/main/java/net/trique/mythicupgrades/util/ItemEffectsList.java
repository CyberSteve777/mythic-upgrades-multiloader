package net.trique.mythicupgrades.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;


public record ItemEffectsList(Object2ObjectMap<Target, Object2ObjectMap<Holder<MobEffect>, EffectMeta>> effects) {
    // Empty instance constant
    public static final ItemEffectsList EMPTY = new ItemEffectsList(Object2ObjectMaps.emptyMap());

    // Constructor with immutability enforcement
    public ItemEffectsList {
        // Create defensive unmodifiable copies
        Object2ObjectMap<Target, Object2ObjectMap<Holder<MobEffect>, EffectMeta>> temp = new Object2ObjectOpenHashMap<>();
        effects.forEach((target, map) ->
                temp.put(target, Object2ObjectMaps.unmodifiable(new Object2ObjectOpenHashMap<>(map)))
        );
        effects = Object2ObjectMaps.unmodifiable(temp);
    }

    // Default constructor creates empty maps for all targets
    public ItemEffectsList() {
        this(createEmptyFastUtilMap());
    }

    private static Object2ObjectMap<Target, Object2ObjectMap<Holder<MobEffect>, EffectMeta>> createEmptyFastUtilMap() {
        Object2ObjectMap<Target, Object2ObjectMap<Holder<MobEffect>, EffectMeta>> map = new Object2ObjectOpenHashMap<>();
        for (Target target : Target.values()) {
            map.put(target, new Object2ObjectOpenHashMap<>());
        }
        return map;
    }

    // Accessors return immutable views
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getForMainHand() {
        return effects.getOrDefault(Target.IN_MAIN_HAND, Object2ObjectMaps.emptyMap());
    }

    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getForEquipmentForSelf() {
        return effects.getOrDefault(Target.ON_EQUIPMENT_FOR_SELF, Object2ObjectMaps.emptyMap());
    }

    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getForEquipmentForEnemy() {
        return effects.getOrDefault(Target.ON_EQUIPMENT_FOR_ENEMY, Object2ObjectMaps.emptyMap());
    }

    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitForEnemy() {
        return effects.getOrDefault(Target.ON_HIT_FOR_ENEMY, Object2ObjectMaps.emptyMap());
    }

    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitForSelf() {
        return effects.getOrDefault(Target.ON_HIT_FOR_SELF, Object2ObjectMaps.emptyMap());
    }

    // StreamCodec for network synchronization
    public static final StreamCodec<RegistryFriendlyByteBuf, ItemEffectsList> STREAM_CODEC =
            StreamCodec.composite(
                    // 1) inner codec: Map<Target, Map<Holder<MobEffect>,EffectMeta>>
                    ByteBufCodecs.map(
                            Object2ObjectOpenHashMap::new,                         // map supplier
                            ByteBufCodecs.idMapper(Target.BY_ID, Target::getType),// key codec for Target
                            // codec for inner map: Holder<MobEffect> → EffectMeta
                            ByteBufCodecs.map(
                                    Object2ObjectOpenHashMap::new,                     // inner-map supplier
                                    ByteBufCodecs.holderRegistry(BuiltInRegistries.MOB_EFFECT.key()),
                                    EffectMeta.STREAM_CODEC
                            )
                    ),
                    // 2) encoder: ItemEffectsList → raw map
                    ItemEffectsList::effects,
                    // 3) decoder: raw map → ItemEffectsList
                    ItemEffectsList::new
            );

    // Builder pattern
    public static final class Builder {
        private final Object2ObjectMap<Target, Object2ObjectMap<Holder<MobEffect>, EffectMeta>> effectsMap;

        public Builder() {
            this.effectsMap = createEmptyFastUtilMap();
        }

        public Builder addForMainHand(Holder<MobEffect> effect, int duration, int amplifier) {
            effectsMap.get(Target.IN_MAIN_HAND).put(effect, EffectMeta.partiallyVisible(duration, amplifier));
            return this;
        }

        public Builder addForHitToEnemy(Holder<MobEffect> effect, int duration, int amplifier) {
            effectsMap.get(Target.ON_HIT_FOR_ENEMY).put(effect, EffectMeta.fullyVisible(duration, amplifier));
            return this;
        }

        public Builder addForHitToSelf(Holder<MobEffect> effect, int duration, int amplifier) {
            effectsMap.get(Target.ON_HIT_FOR_SELF).put(effect, EffectMeta.fullyVisible(duration, amplifier));
            return this;
        }

        public Builder addForEquipmentBuffs(Holder<MobEffect> effect, int amplifier) {
            effectsMap.get(Target.ON_EQUIPMENT_FOR_SELF)
                    .put(effect, EffectMeta.partiallyVisible(MobEffectInstance.INFINITE_DURATION, amplifier));
            return this;
        }

        public Builder addForEquipmentDebuffs(Holder<MobEffect> effect, int duration, int amplifier) {
            effectsMap.get(Target.ON_EQUIPMENT_FOR_ENEMY)
                    .put(effect, EffectMeta.fullyVisible(duration, amplifier));
            return this;
        }

        public ItemEffectsList build() {
            return new ItemEffectsList(effectsMap);
        }
    }
}