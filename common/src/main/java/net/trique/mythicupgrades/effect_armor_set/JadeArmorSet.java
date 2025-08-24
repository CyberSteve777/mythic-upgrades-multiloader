package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.JadeData;

import static net.minecraft.world.effect.MobEffects.JUMP;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class JadeArmorSet extends FullEffectArmorSet {
    public JadeArmorSet() {
        super(getLoc("jade_set"),
                JadeArmorSet::getActualEffects,
                JadeArmorSet::getFiller,
                JadeArmorSet::getFiller);
    }


    private static EffectList getActualEffects(LivingEntity entity) {
        JadeData data = MUConfigHelper.getJadeValues();
        return new EffectList.Builder()
                .addInfiniteEffect(MOVEMENT_SPEED, data.speed_amplifier(), true, false, true)
                .addInfiniteEffect(JUMP, data.jump_boost_amplifier(), true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
