package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.RubyData;
import net.trique.mythicupgrades.registry.EffectRegistry;
import net.trique.mythicupgrades.util.CommonFunctions;

public class RubyArmorSet extends FullEffectArmorSet {
    public RubyArmorSet() {
        super(CommonFunctions.getLoc("ruby_set"),
                RubyArmorSet::getActualEffects,
                RubyArmorSet::getFiller,
                RubyArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        RubyData data = MUConfigHelper.getRubyValues();
        return new EffectList.Builder()
                .addInfiniteEffect(EffectRegistry.VEINMINER, 0,
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
