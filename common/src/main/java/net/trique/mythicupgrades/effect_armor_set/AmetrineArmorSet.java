package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.AmetrineData;

import static net.trique.mythicupgrades.registry.EffectRegistry.ARCANE_AURA;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class AmetrineArmorSet extends FullEffectArmorSet {
    public AmetrineArmorSet() {
        super(getLoc("ametrine_set"),
                AmetrineArmorSet::getActualEffects,
                AmetrineArmorSet::getFiller,
                AmetrineArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        AmetrineData data = MUConfigHelper.getAmetrineValues();
        return new EffectList.Builder()
                .addInfiniteEffect(ARCANE_AURA, data.arcane_aura_amplifier(),
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
