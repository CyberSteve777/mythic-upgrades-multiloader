package net.trique.mythicupgrades.item.base;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.trique.mythicupgrades.util.EffectMeta;

import java.util.HashMap;

public interface BaseMythicItem {
    Object2ObjectMap<Holder<MobEffect>, EffectMeta> getMainHandEffects();
    Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitEffectsForEnemy();
    Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitEffectsForSelf();
}