package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.AquamarineData;

import static net.trique.mythicupgrades.registry.EffectRegistry.ICE_SHIELD;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class AquamarineArmorSet extends FullEffectArmorSet {
    public AquamarineArmorSet() {
        super(getLoc("aquamarine_set"),
                AquamarineArmorSet::getActualEffects,
                AquamarineArmorSet::getFiller,
                AquamarineArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        AquamarineData data = MUConfigHelper.getAquamarineValues();
        return new EffectList.Builder()
                .addInfiniteEffect(ICE_SHIELD, data.ice_shield_amplifier(),
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
