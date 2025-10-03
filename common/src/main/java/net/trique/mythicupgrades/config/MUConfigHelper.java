package net.trique.mythicupgrades.config;

import net.trique.mythicupgrades.config.gem_data.*;

public class MUConfigHelper {

    public static AquamarineData getAquamarineValues() {
        return new AquamarineData(MUConfig.CONFIG.tools_freeze_duration.get(),
                MUConfig.CONFIG.ice_shield_slowness_duration.get(),
                MUConfig.CONFIG.ice_shield_amplifier.get());
    }

    public static PeridotData getPeridotValues() {
        return new PeridotData(MUConfig.CONFIG.tools_effects_amplifier.get(),
                MUConfig.CONFIG.tools_poison_duration.get(),
                MUConfig.CONFIG.tools_nausea_duration.get(),
                MUConfig.CONFIG.poisonous_thorns_amplifier.get(),
                MUConfig.CONFIG.poisonous_thorns_poison_duration.get(),
                MUConfig.CONFIG.poisonous_thorns_nausea_duration.get());
    }

    public static TopazData getTopazValues() {
        return new TopazData(MUConfig.CONFIG.topaz_tools_fire_seconds.get(),
                MUConfig.CONFIG.item_mastery_amplifier.get());
    }

    public static RubyData getRubyValues() {
        return new RubyData(MUConfig.CONFIG.tools_haste_amplifier.get(),
                MUConfig.CONFIG.spelunker_amplifier.get());
    }

    public static SapphireData getSapphireValues() {
        return new SapphireData(MUConfig.CONFIG.tools_percentage_damage_percent.get(),
                MUConfig.CONFIG.damage_deflection_amplifier.get());
    }

    public static JadeData getJadeValues() {
        return new JadeData(MUConfig.CONFIG.tools_bouncer_jump_boost_duration.get(),
                MUConfig.CONFIG.tools_bouncer_amplifier.get(),
                MUConfig.CONFIG.speed_amplifier.get(),
                MUConfig.CONFIG.jump_boost_amplifier.get());
    }

    public static AmetrineData getAmetrineValues() {
        return new AmetrineData(MUConfig.CONFIG.tools_levitation_duration.get(),
                MUConfig.CONFIG.tools_levitation_amplifier.get(),
                MUConfig.CONFIG.arcane_aura_levitation_duration.get(),
                MUConfig.CONFIG.arcane_aura_amplifier.get());
    }
}
