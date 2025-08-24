package net.trique.mythicupgrades.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.effect.*;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;

import java.util.function.Supplier;

public class EffectRegistry {
    public static final Holder<MobEffect> POISONOUS_THORNS;
    public static final Holder<MobEffect> ICE_SHIELD;
    public static final Holder<MobEffect> FREEZE;
    public static final Holder<MobEffect> DAMAGE_DEFLECTION;
    public static final Holder<MobEffect> ITEM_MASTERY;
    public static final Holder<MobEffect> ARCANE_AURA;
    public static final Holder<MobEffect> BOUNCER;
    public static final Holder<MobEffect> SPELUNKER;

    protected static final RegistrationProvider<MobEffect> EFFECTS = RegistrationProvider.get(Registries.MOB_EFFECT, Constants.MOD_ID);


    public static <T extends MobEffect> Holder<MobEffect> registerEffect(String name, Supplier<T> effectSupplier) {
        RegistryObject<MobEffect, T> effectObject = EFFECTS.register(name, effectSupplier);
        return effectObject.asHolder();
    }


    public static void init() {
        Constants.LOGGER.info("Registering Effects...");
    }

    static {
        POISONOUS_THORNS = registerEffect("poisonous_thorns", () -> new PoisonousThornsEffect(MobEffectCategory.BENEFICIAL, 11524864));
        ICE_SHIELD = registerEffect("ice_shield", () -> new IceShieldEffect(MobEffectCategory.BENEFICIAL, 52218));
        FREEZE = registerEffect("freeze", () -> new FreezeEffect(MobEffectCategory.HARMFUL, 52218));
        DAMAGE_DEFLECTION = registerEffect("damage_deflection", () -> new DamageDeflectionEffect(MobEffectCategory.BENEFICIAL, 18170));
        ITEM_MASTERY = registerEffect("item_mastery", () -> new ItemMasteryEffect(MobEffectCategory.BENEFICIAL, 16747551));
        ARCANE_AURA = registerEffect("arcane_aura", () -> new ArcaneAuraEffect(MobEffectCategory.BENEFICIAL, 12525567));
        BOUNCER = registerEffect("bouncer", () -> new BouncerEffect(MobEffectCategory.BENEFICIAL, 3652380));
        SPELUNKER = registerEffect("spelunker", () -> new SpelunkerEffect(MobEffectCategory.BENEFICIAL, 6317));
    }
}