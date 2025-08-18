package net.trique.mythicupgrades.item.misc.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.trique.mythicupgrades.registry.EffectRegistry;

public class MUPotions {

    public static FoodProperties getAquamarinePotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(EffectRegistry.ICE_SHIELD, 3600, 0), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getPeridotPotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(EffectRegistry.POISONOUS_THORNS, 3600, 0), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getRubyPotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0), 1.0F).
                effect(new MobEffectInstance(EffectRegistry.SPELUNKER, 3600, 2), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getSapphirePotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(EffectRegistry.DAMAGE_DEFLECTION, 3600, 2), 1.0F).
                effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getTopazPotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1.0F).
                effect(new MobEffectInstance(EffectRegistry.ITEM_MASTERY, 3600, 2), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getAmetrinePotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(EffectRegistry.ARCANE_AURA, 3600, 2), 1.0F).
                alwaysEdible().build();
    }

    public static FoodProperties getJadePotion() {
        return (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).
                effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F).
                effect(new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0F).
                alwaysEdible().build();
    }

}