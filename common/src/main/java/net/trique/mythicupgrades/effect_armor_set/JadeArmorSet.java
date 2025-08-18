package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.item.armor.base.ArmorSet;
import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.JadeData;

import static net.minecraft.world.effect.MobEffects.JUMP;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED;

public class JadeArmorSet extends EffectArmorSet {
    public JadeArmorSet(ArmorSet armorSet) {
        super(armorSet);
    }

    @Override
    public EffectList getEffectsWhenWearing(LivingEntity entity) {
        JadeData data = MUConfigHelper.getJadeValues();
        return new EffectList.Builder()
                .addPartiallyVisibleEffect(MOVEMENT_SPEED, MobEffectInstance.INFINITE_DURATION, data.speed_amplifier())
                .addPartiallyVisibleEffect(JUMP, MobEffectInstance.INFINITE_DURATION, data.jump_boost_amplifier())
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
