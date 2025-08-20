package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.AquamarineData;

import static net.trique.mythicupgrades.registry.EffectRegistry.ICE_SHIELD;
import static net.trique.mythicupgrades.util.CommonFunctions.getLoc;

public class AquamarineArmorSet extends EffectArmorSet {
    public AquamarineArmorSet() {
        super(getLoc("aquamarine_set"));
    }

    @Override
    public EffectList getEffectsWhenWearing(LivingEntity entity) {
        AquamarineData data = MUConfigHelper.getAquamarineValues();
        return new EffectList.Builder()
                .addPartiallyVisibleEffect(ICE_SHIELD, MobEffectInstance.INFINITE_DURATION,
                        data.ice_shield_amplifier())
                .build();
    }

    @Override
    public EffectList getEffectsForSelfWhenHit(DamageSource source, float amount) {
        return EffectList.EMPTY;
    }

    @Override
    public EffectList getEffectsForAttackerWhenHit(DamageSource source, float amount) {
        return EffectList.EMPTY;
    }
}
