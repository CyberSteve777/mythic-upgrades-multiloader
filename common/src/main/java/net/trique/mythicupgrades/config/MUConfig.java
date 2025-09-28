package net.trique.mythicupgrades.config;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.trique.mythicupgrades.util.CommonFunctions;


public final class MUConfig {

    public static final ModConfigSpec CONFIG_SPEC;
    public static final MUConfig CONFIG;

    public final ModConfigSpec.DoubleValue tools_freeze_duration;
    public final ModConfigSpec.DoubleValue ice_shield_slowness_duration;
    public final ModConfigSpec.IntValue ice_shield_amplifier;

    public final ModConfigSpec.IntValue tools_effects_amplifier;
    public final ModConfigSpec.DoubleValue tools_poison_duration;
    public final ModConfigSpec.DoubleValue tools_nausea_duration;
    public final ModConfigSpec.IntValue poisonous_thorns_amplifier;
    public final ModConfigSpec.DoubleValue poisonous_thorns_poison_duration;
    public final ModConfigSpec.DoubleValue poisonous_thorns_nausea_duration;

    public final ModConfigSpec.DoubleValue topaz_tools_fire_seconds;
    public final ModConfigSpec.IntValue item_mastery_amplifier;

    public final ModConfigSpec.IntValue tools_haste_amplifier;
    public final ModConfigSpec.IntValue spelunker_amplifier;

    public final ModConfigSpec.DoubleValue tools_percentage_damage_percent;
    public final ModConfigSpec.IntValue damage_deflection_amplifier;

    public final ModConfigSpec.DoubleValue tools_levitation_duration;
    public final ModConfigSpec.IntValue tools_levitation_amplifier;
    public final ModConfigSpec.DoubleValue arcane_aura_levitation_duration;
    public final ModConfigSpec.IntValue arcane_aura_amplifier;

    public final ModConfigSpec.DoubleValue tools_bouncer_jump_boost_duration;
    public final ModConfigSpec.IntValue tools_bouncer_amplifier;
    public final ModConfigSpec.IntValue speed_amplifier;
    public final ModConfigSpec.IntValue jump_boost_amplifier;

    private MUConfig(ModConfigSpec.Builder builder) {
        tools_freeze_duration = builder.comment("Duration in seconds of freezing effect that tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("aquamarine_tools_freeze_duration"))
                .defineInRange("tools_freeze_duration", 0.5, 0.1, 1);
        ice_shield_slowness_duration = builder.comment("Duration of Slowness effect enemies get when attack you with Ice Shield effect")
                .translation(CommonFunctions.getTranslationKey("aquamarine_ice_shield_slowness_duration"))
                .defineInRange("ixe_shield_slowness_duration", 1, 0.1, 3);
        ice_shield_amplifier = builder.comment("Amplifier of Ice Shield effect when entity wears full set of aquamarine armor")
                .translation(CommonFunctions.getTranslationKey("aquamarine_ice_shield_amplifier"))
                .defineInRange("ice_shield_amplifier", 2, 0, 4);

        tools_effects_amplifier = builder.comment("Amplifier of effects peridot tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("peridot_tools_effects_amplifier"))
                .defineInRange("tools_effects_amplifier", 2, 0, 4);
        tools_poison_duration = builder.comment("Duration of poison effect peridot tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("peridot_tools_poison_duration"))
                .defineInRange("tools_poison_duration", 3, 0.1, 5);
        tools_nausea_duration = builder.comment("Duration of nausea effect peridot tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("peridot_tools_nausea_duration"))
                .defineInRange("tools_nausea_duration", 12, 0.1, 20);
        poisonous_thorns_amplifier = builder.comment("Amplifier of Poisonous Thorns effect wearer of full set of peridot armor gets")
                .translation(CommonFunctions.getTranslationKey("peridot_poisonous_thorns_amplifier"))
                .defineInRange("poisonous_thorns_amplifier", 2, 0, 4);
        poisonous_thorns_poison_duration = builder.comment("Duration of poison effect peridot tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("peridot_poisonous_thorns_poison_duration"))
                .defineInRange("poisonous_thorns_poison_duration", 3, 0.1, 5);
        poisonous_thorns_nausea_duration = builder.comment("Duration of nausea effect peridot tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("peridot_poisonous_thorns_nausea_duration"))
                .defineInRange("poisonous_thorns_nausea_duration", 9, 0.1, 20);

        topaz_tools_fire_seconds = builder.comment("The time in seconds that the entity is set on fire by topaz tools")
                .translation(CommonFunctions.getTranslationKey("topaz_tools_fire_seconds"))
                .defineInRange("topaz_tools_fire_seconds", 10., 1, 30);
        item_mastery_amplifier = builder.comment("Amplifier of Item Mastery effect that is received when full set of topaz armor is equipped")
                .translation(CommonFunctions.getTranslationKey("topaz_item_mastery_amplifier"))
                .defineInRange("item_mastery_amplifier", 4, 0, 6);

        tools_haste_amplifier = builder.comment("Amplifier of Haste effect that entity receive when they hold ruby tool in main hand")
                .translation(CommonFunctions.getTranslationKey("ruby_tools_haste_amplifier"))
                .defineInRange("tools_haste_amplifier", 0, 0, 2);
        spelunker_amplifier = builder.comment("Amplifier of Spelunker effect that is received when full set of ruby armor is equipped")
                .translation(CommonFunctions.getTranslationKey("ruby_spelunker_amplifier"))
                .defineInRange("spelunker_amplifier", 5, 0, 10);

        tools_percentage_damage_percent = builder.comment("% of max health of entity that they take as extra damage")
                .translation(CommonFunctions.getTranslationKey("sapphire_tools_percentage_damage_percent"))
                .defineInRange("tools_percentage_damage_percent", 5., 1, 7);
        damage_deflection_amplifier = builder.comment("Amplifier of Damage Deflection effect wearer of full set of sapphire armor gets")
                .translation(CommonFunctions.getTranslationKey("sapphire_damage_deflection_amplifier"))
                .defineInRange("damage_deflection_amplifier", 2, 0, 4);

        tools_levitation_duration = builder.comment("Duration of Levitation effect ametrine tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("ametrine_tools_levitation_duration"))
                .defineInRange("tools_levitation_duration", 0.75, 0.1, 3);
        tools_levitation_amplifier = builder.comment("Amplifier of Levitation effect ametrine tools apply on hit")
                .translation(CommonFunctions.getTranslationKey("ametrine_tools_levitation_amplifier"))
                .defineInRange("tools_levitation_amplifier", 4, 4, 6);
        arcane_aura_levitation_duration = builder.comment("Duration of Levitation effect Arcane Aura applies to enemies that hit wearer of the effect")
                .translation(CommonFunctions.getTranslationKey("ametrine_arcane_aura_levitation_duration"))
                .defineInRange("arcane_aura_levitation_duration", 0.75, 0.5, 3);
        arcane_aura_amplifier = builder.comment("Amplifier of Arcane Aura effect when full set of ametrine armor is equipped")
                .translation(CommonFunctions.getTranslationKey("ametrine_arcane_aura_amplifier"))
                .defineInRange("arcane_aura_amplifier", 2, 0, 4);

        tools_bouncer_jump_boost_duration = builder.comment("Duration of jump boost from bouncer effect")
                .translation(CommonFunctions.getTranslationKey("jade_tools_bouncer_jump_boost_duration"))
                .defineInRange("tools_bouncer_jump_boost_duration", 2, 0.1, 5);
        tools_bouncer_amplifier = builder.comment("Bouncer amplifier on tools")
                .translation(CommonFunctions.getTranslationKey("jade_tools_bouncer_amplifier"))
                .defineInRange("tools_bouncer_amplifier", 4, 2, 6);
        speed_amplifier = builder.comment("Speed amplifier on jade armor")
                .translation(CommonFunctions.getTranslationKey("jade_speed_amplifier"))
                .defineInRange("speed_amplifier", 2, 0, 4);
        jump_boost_amplifier = builder.comment("Jump boost amplifier on jade armor")
                .translation(CommonFunctions.getTranslationKey("jade_jump_boost_amplifier"))
                .defineInRange("speed_amplififer", 2, 0, 4);
    }


    static {
        ModConfigSpec.Builder configBuilder = new ModConfigSpec.Builder();
        CONFIG = new MUConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }

}
