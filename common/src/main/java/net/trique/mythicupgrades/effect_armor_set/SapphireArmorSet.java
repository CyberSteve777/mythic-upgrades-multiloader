package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.armorset.impl.FullEffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.SapphireData;

import static net.trique.mythicupgrades.registry.EffectRegistry.DAMAGE_DEFLECTION;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class SapphireArmorSet extends FullEffectArmorSet {
    public SapphireArmorSet() {
        super(getLoc("sapphire_set"),
                SapphireArmorSet::getActualEffects,
                SapphireArmorSet::getFiller,
                SapphireArmorSet::getFiller);
    }

    private static EffectList getActualEffects(LivingEntity livingEntity) {
        SapphireData data = MUConfigHelper.getSapphireValues();
        return new EffectList.Builder()
                .addInfiniteEffect(DAMAGE_DEFLECTION, data.damage_deflection_amplifier(),
                        true, false, true).build();
    }

    private static EffectList getFiller(DamageSource source, LivingEntity target, float amount) {
        return EffectList.getEmptyList();
    }
}
