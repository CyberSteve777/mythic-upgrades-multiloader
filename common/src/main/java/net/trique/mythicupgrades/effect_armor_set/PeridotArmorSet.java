package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.PeridotData;

import static net.trique.mythicupgrades.registry.EffectRegistry.POISONOUS_THORNS;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class PeridotArmorSet extends FullEffectArmorSet {
    public PeridotArmorSet() {
        super(getLoc("peridot_set"),
                PeridotArmorSet::getActualEffects,
                PeridotArmorSet::getFiller,
                PeridotArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        PeridotData data = MUConfigHelper.getPeridotValues();
        return new EffectList.Builder()
                .addInfiniteEffect(POISONOUS_THORNS, data.poisonous_thorns_amplifier(),
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
