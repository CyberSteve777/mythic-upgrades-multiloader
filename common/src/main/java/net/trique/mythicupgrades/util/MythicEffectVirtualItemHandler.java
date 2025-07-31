package net.trique.mythicupgrades.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;

public class MythicEffectVirtualItemHandler {

    private ItemEffectsList allEffects;

    public MythicEffectVirtualItemHandler(ItemEffectsList allEffects) {
        this.allEffects = allEffects;
    }

    public void handlePostHit(LivingEntity target, LivingEntity attacker) {
        CommonFunctions.addStatusEffects(target, getOnHitEffectsForEnemy(), attacker);
        CommonFunctions.addStatusEffects(attacker, getOnHitEffectsForSelf(), attacker);
    }
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getMainHandEffects() {
        return allEffects.getForMainHand();
    }
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getEquipmentEffectsForSelf() {
        return allEffects.getForEquipmentForSelf();
    }
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getEquipmentEffectsForEnemy() {
        return allEffects.getForEquipmentForEnemy();
    }
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitEffectsForEnemy() {
        return allEffects.getOnHitForEnemy();
    }
    public Object2ObjectMap<Holder<MobEffect>, EffectMeta> getOnHitEffectsForSelf() {
        return allEffects.getOnHitForSelf();
    }

    public void setNewEffects(ItemEffectsList list) {
        allEffects = list;
    }
}