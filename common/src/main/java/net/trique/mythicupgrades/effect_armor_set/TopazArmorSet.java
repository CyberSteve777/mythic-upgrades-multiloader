package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.TopazData;

import static net.minecraft.world.effect.MobEffects.FIRE_RESISTANCE;
import static net.trique.mythicupgrades.registry.EffectRegistry.ITEM_MASTERY;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class TopazArmorSet extends EffectArmorSet {
    public TopazArmorSet() {
        super(getLoc("topaz_set"));
    }

    @Override
    public EffectList getEffectsWhenWearing(LivingEntity entity) {
        TopazData data = MUConfigHelper.getTopazValues();
        return new EffectList.Builder()
                .addPartiallyVisibleEffect(FIRE_RESISTANCE, MobEffectInstance.INFINITE_DURATION, 0)
                .addPartiallyVisibleEffect(ITEM_MASTERY, MobEffectInstance.INFINITE_DURATION,
                        data.item_mastery_amplifier())
                .build();
    }

    @Override
    public EffectList getEffectsForSelfWhenHit(DamageSource source, float amount) {
        return EffectList.EMPTY;
    }

    @Override
    public EffectList getEffectsForAttackerWhenHit(DamageSource source, float amount) {
        return EffectList.EMPTY;
    }
}
