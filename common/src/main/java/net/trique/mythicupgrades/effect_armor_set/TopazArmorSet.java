package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.TopazData;

import static net.minecraft.world.effect.MobEffects.FIRE_RESISTANCE;
import static net.trique.mythicupgrades.registry.EffectRegistry.ITEM_MASTERY;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class TopazArmorSet extends FullEffectArmorSet {
    public TopazArmorSet() {
        super(getLoc("topaz_set"),
                TopazArmorSet::getActualEffects,
                TopazArmorSet::getFiller,
                TopazArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        TopazData data = MUConfigHelper.getTopazValues();
        return new EffectList.Builder()
                .addInfiniteEffect(FIRE_RESISTANCE, 0, true, false, true)
                .addInfiniteEffect(ITEM_MASTERY, data.item_mastery_amplifier(), true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
