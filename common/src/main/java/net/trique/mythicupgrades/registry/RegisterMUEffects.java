package net.trique.mythicupgrades.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.effect.MUEffects;

public class RegisterMUEffects {
    public static void registerEffect(MobEffect effect, String name) {
        Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(Constants.MOD_ID, name), effect);
    }
    public static void registerEffects() {
        registerEffect(MUEffects.OCEAN_SHIELD, "ocean_shield");
        registerEffect(MUEffects.HINDERING, "hindering");
        registerEffect(MUEffects.POISONOUS_THORNS, "poisonous_thorns");
        registerEffect(MUEffects.ICE_SHIELD, "ice_shield");
        registerEffect(MUEffects.FREEZE, "freeze");
        registerEffect(MUEffects.DAMAGE_DEFLECTION, "damage_deflection");
        registerEffect(MUEffects.ITEM_MASTERY, "item_mastery");
        registerEffect(MUEffects.ARCANE_AURA, "arcane_aura");
    }
}