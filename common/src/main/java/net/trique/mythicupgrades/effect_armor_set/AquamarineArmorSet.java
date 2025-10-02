package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.AquamarineData;
import net.trique.mythicupgrades.registry.EffectRegistry;
import net.trique.mythicupgrades.util.CommonFunctions;

public class AquamarineArmorSet extends FullEffectArmorSet {
    public AquamarineArmorSet() {
        super(CommonFunctions.getLoc("aquamarine_set"),
                AquamarineArmorSet::getActualEffects,
                AquamarineArmorSet::getFiller,
                AquamarineArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        //AquamarineData data = MUConfigHelper.getAquamarineValues();
        return new EffectList.Builder()
                .addInfiniteEffect(MobEffects.DOLPHINS_GRACE, 0,
                        true, false, true)
                .addInfiniteEffect(MobEffects.CONDUIT_POWER, 0,
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
