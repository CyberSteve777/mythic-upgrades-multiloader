package net.trique.mythicupgrades.effect;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import static net.trique.mythicupgrades.config.Config.OCEAN_SHIELD_MINING_FATIGUE_DURATION;

public class OceanShieldEffect extends MobEffect {
    public OceanShieldEffect(MobEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            Entity attacker = livingEntity.getLastHurtByMob();
            if (livingEntity.hurtTime == 9) {
                if (attacker instanceof LivingEntity entity && !attacker.equals(livingEntity)) {
                    entity.hurt(livingEntity.level().damageSources().thorns(livingEntity), amplifier);
                    entity.playSound(SoundEvents.ELDER_GUARDIAN_HURT, 1.0f, livingEntity.getVoicePitch());
                    entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN,
                            (int)(OCEAN_SHIELD_MINING_FATIGUE_DURATION.get() * 20), amplifier), livingEntity);
                }
            }
        }
        super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}