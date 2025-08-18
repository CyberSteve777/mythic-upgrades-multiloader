package net.trique.mythicupgrades.config;

import net.trique.mythicupgrades.config.gem_data.*;
import net.trique.mythicupgrades.networking.packet.MUConfigPacket;

public class MUConfigHelper {
    private static MUConfigCache CLIENT_CACHE;
    private static MUConfigCache CURRENT_VALUES;


    public static void initCaches() {
        CLIENT_CACHE = new MUConfigCache();
        CURRENT_VALUES = new MUConfigCache();
    }

    public static void cacheValuesBeforeJoin() {
        CLIENT_CACHE.updateByConfig(MUConfig.CONFIG);
    }

    public static void updateCurrentValuesOnChange(MUConfig config) {
        CURRENT_VALUES.updateByConfig(config);
    }

    public static void updateValuesOnJoin(MUConfigPacket packet) {
        CURRENT_VALUES.updateByPacket(packet);
    }

    public static void restoreClientValues() {
        CURRENT_VALUES.updateByOtherCache(CLIENT_CACHE);
    }

    public static AquamarineData getAquamarineValues() {
        return new AquamarineData(CURRENT_VALUES.getTools_freeze_duration(),
                CURRENT_VALUES.getIce_shield_slowness_duration(),
                CURRENT_VALUES.getIce_shield_amplifier());
    }

    public static PeridotData getPeridotValues() {
        return new PeridotData(CURRENT_VALUES.getTools_effects_amplifier(),
                CURRENT_VALUES.getTools_poison_duration(),
                CURRENT_VALUES.getTools_nausea_duration(),
                CURRENT_VALUES.getPoisonous_thorns_amplifier(),
                CURRENT_VALUES.getPoisonous_thorns_poison_duration(),
                CURRENT_VALUES.getPoisonous_thorns_nausea_duration());
    }

    public static TopazData getTopazValues() {
        return new TopazData(CURRENT_VALUES.getTopaz_tools_fire_seconds(),
                CURRENT_VALUES.getItem_mastery_amplifier());
    }

    public static RubyData getRubyValues() {
        return new RubyData(CURRENT_VALUES.getTools_haste_amplifier(),
                CURRENT_VALUES.getSpelunker_amplifier());
    }

    public static SapphireData getSapphireValues() {
        return new SapphireData(CURRENT_VALUES.getTools_percentage_damage_percent(),
                CURRENT_VALUES.getDamage_deflection_amplifier());
    }

    public static JadeData getJadeValues() {
        return new JadeData(CURRENT_VALUES.getTools_bouncer_jump_boost_duration(),
                CURRENT_VALUES.getTools_bouncer_amplifier(),
                CURRENT_VALUES.getSpeed_amplifier(),
                CURRENT_VALUES.getJump_boost_amplifier());
    }

    public static AmetrineData getAmetrineValues() {
        return new AmetrineData(CURRENT_VALUES.getTools_levitation_duration(),
                CURRENT_VALUES.getTools_levitation_amplifier(),
                CURRENT_VALUES.getArcane_aura_levitation_duration(),
                CURRENT_VALUES.getArcane_aura_amplifier());
    }
}
