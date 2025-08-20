package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.SapphireData;

import static net.trique.mythicupgrades.registry.EffectRegistry.DAMAGE_DEFLECTION;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class SapphireArmorSet extends EffectArmorSet {
    public SapphireArmorSet() {
        super(getLoc("sapphire_set"));
    }

    @Override
    public EffectList getEffectsWhenWearing(LivingEntity livingEntity) {
        SapphireData data = MUConfigHelper.getSapphireValues();
        return new EffectList.Builder().addPartiallyVisibleEffect(DAMAGE_DEFLECTION,
                MobEffectInstance.INFINITE_DURATION, data.damage_deflection_amplifier()).build();
    }

    @Override
    public EffectList getEffectsForSelfWhenHit(DamageSource damageSource, float v) {
        return EffectList.EMPTY;
    }

    @Override
    public EffectList getEffectsForAttackerWhenHit(DamageSource damageSource, float v) {
        return EffectList.EMPTY;
    }
}
