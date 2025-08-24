package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.RubyData;

import static net.trique.mythicupgrades.registry.EffectRegistry.SPELUNKER;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class RubyArmorSet extends FullEffectArmorSet {
    public RubyArmorSet() {
        super(getLoc("ruby_set"),
                RubyArmorSet::getActualEffects,
                RubyArmorSet::getFiller,
                RubyArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity entity) {
        RubyData data = MUConfigHelper.getRubyValues();
        return new EffectList.Builder()
                .addInfiniteEffect(SPELUNKER, data.spelunker_amplifier(),
                        true, false, true)
                .build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
