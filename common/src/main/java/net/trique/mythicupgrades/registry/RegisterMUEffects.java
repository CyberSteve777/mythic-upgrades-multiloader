package net.trique.mythicupgrades.registry;

import net.minecraft.world.effect.MobEffect;
import net.trique.mythicupgrades.effect.MUEffects;

import java.util.HashMap;

public class RegisterMUEffects {

    public static HashMap<String, MobEffect> ALL_EFFECTS = new HashMap<>();


    public static void setEffect(MobEffect effect, String name) {
        ALL_EFFECTS.put(name, effect);
    }
    public static void setEffects() {
        setEffect(MUEffects.OCEAN_SHIELD, "ocean_shield");
        setEffect(MUEffects.HINDERING, "hindering");
        setEffect(MUEffects.POISONOUS_THORNS, "poisonous_thorns");
        setEffect(MUEffects.ICE_SHIELD, "ice_shield");
        setEffect(MUEffects.FREEZE, "freeze");
        setEffect(MUEffects.DAMAGE_DEFLECTION, "damage_deflection");
        setEffect(MUEffects.ITEM_MASTERY, "item_mastery");
        setEffect(MUEffects.ARCANE_AURA, "arcane_aura");
    }
}