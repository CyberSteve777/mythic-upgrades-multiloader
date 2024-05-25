package net.trique.mythicupgrades.config;

import net.minecraftforge.common.ForgeConfigSpec;
import static net.trique.mythicupgrades.Constants.MOD_ID;


public class Config {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue OCEAN_SHIELD_AMPLIFIER;
    public static final ForgeConfigSpec.DoubleValue OCEAN_SHIELD_MINING_FATIGUE_DURATION;

    public static final ForgeConfigSpec.DoubleValue HINDERING_EFFECTS_DURATION;
    public static final ForgeConfigSpec.IntValue HINDERING_AMPLIFIER;
    public static final ForgeConfigSpec.IntValue WEAPONS_WEAKNESS_AMPLIFIER;
    public static final ForgeConfigSpec.IntValue WEAPONS_SLOWNESS_AMPLIFIER;
    public static final ForgeConfigSpec.IntValue WEAPONS_HUNGER_AMPLIFIER;
    public static final ForgeConfigSpec.DoubleValue WEAPONS_WEAKNESS_DURATION;
    public static final ForgeConfigSpec.DoubleValue WEAPONS_SLOWNESS_DURATION;
    public static final ForgeConfigSpec.DoubleValue WEAPONS_HUNGER_DURATION;

    public static final ForgeConfigSpec.DoubleValue WEAPONS_POISON_DURATION;
    public static final ForgeConfigSpec.IntValue WEAPONS_POISON_AMPLIFIER;
    public static final ForgeConfigSpec.DoubleValue POISONOUS_THORNS_POISON_DURATION;
    public static final ForgeConfigSpec.IntValue POISONOUS_THORNS_AMPLIFIER;

    public static final ForgeConfigSpec.DoubleValue WEAPONS_FREEZE_DURATION;
    public static final ForgeConfigSpec.DoubleValue ICE_SHIELD_SLOWNESS_DURATION;
    public static final ForgeConfigSpec.IntValue ICE_SHIELD_AMPLIFIER;

    public static final ForgeConfigSpec.IntValue TOOLS_HASTE_AMPLIFIER;

    public static final ForgeConfigSpec.IntValue WEAPONS_PERCENTAGE_DAMAGE_PERCENT;
    public static final ForgeConfigSpec.IntValue DAMAGE_DEFLECTION_AMPLIFIER;

    public static final ForgeConfigSpec.IntValue ITEM_MASTERY_AMPLIFIER;

    public static final ForgeConfigSpec.DoubleValue WEAPONS_LEVITATION_DURATION;
    public static final ForgeConfigSpec.IntValue WEAPONS_LEVITATION_AMPLIFIER;
    public static final ForgeConfigSpec.DoubleValue ARCANE_AURA_LEVITATION_DURATION;
    public static final ForgeConfigSpec.IntValue ARCANE_AURA_AMPLIFIER;

    public static final ForgeConfigSpec.IntValue SPEED_AMPLIFIER;
    public static final ForgeConfigSpec.IntValue JUMP_BOOST_AMPLIFIER;


    static {
        OCEAN_SHIELD_AMPLIFIER = BUILDER.comment("Ocean Shield Amplifier").defineInRange(MOD_ID + ".ocean_shield_amplifier", 2, 0, 4);
        OCEAN_SHIELD_MINING_FATIGUE_DURATION = BUILDER.comment("Ocean Shield Mining Fatigue Duration").defineInRange(MOD_ID + ".ocean_shield_mining_fatigue_duration", 2f, 0f, 4f);

        HINDERING_EFFECTS_DURATION = BUILDER.comment("Hindering Effects Duration").defineInRange(MOD_ID + ".hindering_effects_duration", 5f, 1f, 10f);
        HINDERING_AMPLIFIER = BUILDER.comment("Hindering Amplifier").defineInRange(MOD_ID + ".hindering_amplifier", 0, 0, 2);
        WEAPONS_WEAKNESS_AMPLIFIER = BUILDER.comment("Weapons Weakness Amplifier").defineInRange(MOD_ID + ".weapons_weakness_amplifier", 0, 0, 2);
        WEAPONS_HUNGER_AMPLIFIER = BUILDER.comment("Weapons Weakness Amplifier").defineInRange(MOD_ID + ".weapons_hunger_amplifier", 0, 0, 2);
        WEAPONS_SLOWNESS_AMPLIFIER = BUILDER.comment("Weapons Weakness Amplifier").defineInRange(MOD_ID + ".weapons_slowness_amplifier", 0, 0, 2);
        WEAPONS_WEAKNESS_DURATION = BUILDER.comment("Weapons Weakness Duration").defineInRange(MOD_ID + ".weapons_weakness_duration", 5f, 2f, 7f);
        WEAPONS_HUNGER_DURATION = BUILDER.comment("Weapons Weakness Duration").defineInRange(MOD_ID + ".weapons_hunger_duration", 5f, 2f, 7f);
        WEAPONS_SLOWNESS_DURATION = BUILDER.comment("Weapons Weakness Duration").defineInRange(MOD_ID + ".weapons_slowness_duration", 5f, 2f, 7f);

        WEAPONS_POISON_AMPLIFIER = BUILDER.comment("Weapons Poison Amplifier").defineInRange(MOD_ID + ".weapons_poison_amplifier", 2, 0, 5);
        WEAPONS_POISON_DURATION = BUILDER.comment("Weapons Poison Duration").defineInRange(MOD_ID + ".weapons_poison_duration", 1.5f, .1f, 3f);
        POISONOUS_THORNS_AMPLIFIER = BUILDER.comment("Poisonous Thorns Amplifier").defineInRange(MOD_ID + ".poisonous_thorns_amplifier", 0, 0, 4);
        POISONOUS_THORNS_POISON_DURATION = BUILDER.comment("Poisonous Thorns Poison Duration").defineInRange(MOD_ID + ".poisonous_thorns_poison_duration", 5f, .1f, 7f);

        WEAPONS_FREEZE_DURATION = BUILDER.comment("Weapons Freeze Duration").defineInRange(MOD_ID + ".weapons_freeze_duration", .5f, .1f, 1f);
        ICE_SHIELD_AMPLIFIER = BUILDER.comment("Ice Shield Amplifier").defineInRange(MOD_ID + ".ice_shield_amplifier", 2, 0, 4);
        ICE_SHIELD_SLOWNESS_DURATION = BUILDER.comment("Ice Shield Slowness Duration").defineInRange(MOD_ID + ".ice_shield_slowness_duration", 1f, .1f, 3f);

        TOOLS_HASTE_AMPLIFIER = BUILDER.comment("Tools Haste Amplifier").defineInRange(MOD_ID + ".tools_haste_amplifier", 0, 0, 2);

        WEAPONS_PERCENTAGE_DAMAGE_PERCENT = BUILDER.comment("Weapons Percentage Damage Percent").defineInRange(MOD_ID + ".weapons_percentage_damage_percent", 4, 1, 7);
        DAMAGE_DEFLECTION_AMPLIFIER = BUILDER.comment("Damage Deflection Amplifier").defineInRange(MOD_ID + ".damage_deflection_amplifier", 2, 0, 4);

        ITEM_MASTERY_AMPLIFIER = BUILDER.comment("Item Mastery Amplifier").defineInRange(MOD_ID + ".item_mastery_amplifier", 4, 0, 6);

        WEAPONS_LEVITATION_AMPLIFIER = BUILDER.comment("Weapons Levitation Amplifier").defineInRange(MOD_ID + ".weapons_levitation_amplifier", 4, 4, 6);
        WEAPONS_LEVITATION_DURATION = BUILDER.comment("Weapons Levitation Duration").defineInRange(MOD_ID + ".weapons_levitation_duration", .75f, .1f, 2f);
        ARCANE_AURA_AMPLIFIER = BUILDER.comment("Arcane Aura Amplifier").defineInRange(MOD_ID + ".arcane_aura_amplifier", 2, 0, 4);
        ARCANE_AURA_LEVITATION_DURATION = BUILDER.comment("Arcane Aura Levitation Duration").defineInRange(MOD_ID + ".arcane_aura_levitation_duration", .75f, .5f, 3f);

        SPEED_AMPLIFIER = BUILDER.comment("Speed Amplifier").defineInRange(MOD_ID + ".speed_amplifier", 2, 0, 4);
        JUMP_BOOST_AMPLIFIER = BUILDER.comment("Jump Boost Amplifier").defineInRange(MOD_ID + ".jump_boost_amplifier", 2, 0, 4);

        SPEC = BUILDER.build();
    }
}
