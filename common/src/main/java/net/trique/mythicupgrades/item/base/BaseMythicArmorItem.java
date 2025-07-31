package net.trique.mythicupgrades.item.base;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.trique.mythicupgrades.util.EffectMeta;
import net.trique.mythicupgrades.util.ItemEffectsList;

import java.util.HashMap;
import java.util.List;

public interface BaseMythicArmorItem extends BaseMythicItem {
    Object2ObjectMap<Holder<MobEffect>, EffectMeta> getEquipmentEffectsForSelf();
    Object2ObjectMap<Holder<MobEffect>, EffectMeta> getEquipmentEffectsForEnemies();
    void setNewEffects(ItemEffectsList effectsList, List<Integer> amplifierList);
}