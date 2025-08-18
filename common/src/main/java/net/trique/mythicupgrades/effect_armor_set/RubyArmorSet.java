package net.trique.mythicupgrades.effect_armor_set;

import me.cybersteve.equiplib.item.armor.base.ArmorSet;
import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.RubyData;

import static net.trique.mythicupgrades.registry.EffectRegistry.SPELUNKER;

public class RubyArmorSet extends EffectArmorSet {
    public RubyArmorSet(ArmorSet armorSet) {
        super(armorSet);
    }

    @Override
    public EffectList getEffectsWhenWearing(LivingEntity entity) {
        RubyData data = MUConfigHelper.getRubyValues();
        return new EffectList.Builder()
                .addPartiallyVisibleEffect(SPELUNKER, MobEffectInstance.INFINITE_DURATION,
                        data.spelunker_amplifier())
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
