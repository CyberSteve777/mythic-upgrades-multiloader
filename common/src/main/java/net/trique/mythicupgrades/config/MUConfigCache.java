package net.trique.mythicupgrades.config;


import net.trique.mythicupgrades.networking.packet.MUConfigPacket;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;

public class MUConfigCache {
    private double tools_freeze_duration;
    private double ice_shield_slowness_duration;
    private int ice_shield_amplifier;

    private int tools_effects_amplifier;
    private double tools_poison_duration;
    private double tools_nausea_duration;
    private int poisonous_thorns_amplifier;
    private double poisonous_thorns_poison_duration;
    private double poisonous_thorns_nausea_duration;

    private double topaz_tools_fire_seconds;
    private int item_mastery_amplifier;

    private int tools_haste_amplifier;
    private int spelunker_amplifier;

    private double tools_percentage_damage_percent;
    private int damage_deflection_amplifier;

    private double tools_levitation_duration;
    private int tools_levitation_amplifier;
    private double arcane_aura_levitation_duration;
    private int arcane_aura_amplifier;

    private double tools_bouncer_jump_boost_duration;
    private int tools_bouncer_amplifier;
    private int speed_amplifier;
    private int jump_boost_amplifier;

    public MUConfigCache() {
        tools_freeze_duration = CONFIG.tools_freeze_duration.getDefault();
        ice_shield_amplifier = CONFIG.ice_shield_amplifier.getDefault();
        ice_shield_slowness_duration = CONFIG.ice_shield_slowness_duration.getDefault();

        topaz_tools_fire_seconds = CONFIG.topaz_tools_fire_seconds.getDefault();
        item_mastery_amplifier = CONFIG.item_mastery_amplifier.getDefault();

        poisonous_thorns_amplifier = CONFIG.poisonous_thorns_amplifier.getDefault();
        poisonous_thorns_nausea_duration = CONFIG.poisonous_thorns_nausea_duration.getDefault();
        poisonous_thorns_poison_duration = CONFIG.poisonous_thorns_poison_duration.getDefault();
        tools_effects_amplifier = CONFIG.tools_effects_amplifier.getDefault();
        tools_nausea_duration = CONFIG.tools_nausea_duration.getDefault();
        tools_poison_duration = CONFIG.tools_poison_duration.getDefault();

        tools_percentage_damage_percent = CONFIG.tools_percentage_damage_percent.getDefault();
        damage_deflection_amplifier = CONFIG.damage_deflection_amplifier.getDefault();

        spelunker_amplifier = CONFIG.spelunker_amplifier.getDefault();
        tools_haste_amplifier = CONFIG.tools_haste_amplifier.getDefault();

        tools_levitation_amplifier = CONFIG.tools_levitation_amplifier.getDefault();
        tools_levitation_duration = CONFIG.tools_levitation_duration.getDefault();
        arcane_aura_amplifier = CONFIG.arcane_aura_amplifier.getDefault();
        arcane_aura_levitation_duration = CONFIG.arcane_aura_levitation_duration.getDefault();

        tools_bouncer_amplifier = CONFIG.tools_bouncer_amplifier.getDefault();
        speed_amplifier = CONFIG.speed_amplifier.getDefault();
        tools_bouncer_jump_boost_duration = CONFIG.tools_bouncer_jump_boost_duration.getDefault();
        jump_boost_amplifier = CONFIG.jump_boost_amplifier.getDefault();
    }


//    public MUConfigCache(MUConfig config) {
//        tools_freeze_duration = config.tools_freeze_duration.getDefault();
//        ice_shield_amplifier = config.ice_shield_amplifier.getDefault();
//        ice_shield_slowness_duration = config.ice_shield_slowness_duration.getDefault();
//
//        topaz_tools_fire_seconds = config.topaz_tools_fire_seconds.getDefault();
//        item_mastery_amplifier = config.item_mastery_amplifier.getDefault();
//
//        poisonous_thorns_amplifier = config.poisonous_thorns_amplifier.getDefault();
//        poisonous_thorns_nausea_duration = config.poisonous_thorns_nausea_duration.getDefault();
//        poisonous_thorns_poison_duration = config.poisonous_thorns_poison_duration.getDefault();
//        tools_effects_amplifier = config.tools_effects_amplifier.getDefault();
//        tools_nausea_duration = config.tools_nausea_duration.getDefault();
//        tools_poison_duration = config.tools_poison_duration.getDefault();
//
//        tools_percentage_damage_percent = config.tools_percentage_damage_percent.getDefault();
//        damage_deflection_amplifier = config.damage_deflection_amplifier.getDefault();
//
//        spelunker_amplifier = config.spelunker_amplifier.getDefault();
//        tools_haste_amplifier = config.tools_haste_amplifier.getDefault();
//
//        tools_levitation_amplifier = config.tools_levitation_amplifier.getDefault();
//        tools_levitation_duration = config.tools_levitation_duration.getDefault();
//        arcane_aura_amplifier = config.arcane_aura_amplifier.getDefault();
//        arcane_aura_levitation_duration = config.arcane_aura_levitation_duration.getDefault();
//
//        tools_bouncer_amplifier = config.tools_bouncer_amplifier.getDefault();
//        speed_amplifier = config.speed_amplifier.getDefault();
//        tools_bouncer_jump_boost_duration = config.tools_bouncer_jump_boost_duration.getDefault();
//        jump_boost_amplifier = config.jump_boost_amplifier.getDefault();
//    }
//
//    public MUConfigCache(MUConfigPacket muConfigPacket) {
//        tools_freeze_duration = muConfigPacket.tools_freeze_duration();
//        ice_shield_amplifier = muConfigPacket.ice_shield_amplifier();
//        ice_shield_slowness_duration = muConfigPacket.ice_shield_slowness_duration();
//
//        topaz_tools_fire_seconds = muConfigPacket.topaz_tools_fire_seconds();
//        item_mastery_amplifier = muConfigPacket.item_mastery_amplifier();
//
//        poisonous_thorns_amplifier = muConfigPacket.poisonous_thorns_amplifier();
//        poisonous_thorns_nausea_duration = muConfigPacket.poisonous_thorns_nausea_duration();
//        poisonous_thorns_poison_duration = muConfigPacket.poisonous_thorns_poison_duration();
//        tools_effects_amplifier = muConfigPacket.tools_effects_amplifier();
//        tools_nausea_duration = muConfigPacket.tools_nausea_duration();
//        tools_poison_duration = muConfigPacket.tools_poison_duration();
//
//        tools_percentage_damage_percent = muConfigPacket.tools_percentage_damage_percent();
//        damage_deflection_amplifier = muConfigPacket.damage_deflection_amplifier();
//
//        spelunker_amplifier = muConfigPacket.spelunker_amplifier();
//        tools_haste_amplifier = muConfigPacket.tools_haste_amplifier();
//
//        tools_levitation_amplifier = muConfigPacket.tools_levitation_amplifier();
//        tools_levitation_duration = muConfigPacket.tools_levitation_duration();
//        arcane_aura_amplifier = muConfigPacket.arcane_aura_amplifier();
//        arcane_aura_levitation_duration = muConfigPacket.arcane_aura_levitation_duration();
//
//        tools_bouncer_amplifier = muConfigPacket.tools_bouncer_amplifier();
//        speed_amplifier = muConfigPacket.speed_amplifier();
//        tools_bouncer_jump_boost_duration = muConfigPacket.tools_bouncer_jump_boost_duration();
//        jump_boost_amplifier = muConfigPacket.jump_boost_amplifier();
//    }

    public void updateByConfig(MUConfig config) {
        tools_freeze_duration = config.tools_freeze_duration.get();
        ice_shield_amplifier = config.ice_shield_amplifier.get();
        ice_shield_slowness_duration = config.ice_shield_slowness_duration.get();

        topaz_tools_fire_seconds = config.topaz_tools_fire_seconds.get();
        item_mastery_amplifier = config.item_mastery_amplifier.get();

        poisonous_thorns_amplifier = config.poisonous_thorns_amplifier.get();
        poisonous_thorns_nausea_duration = config.poisonous_thorns_nausea_duration.get();
        poisonous_thorns_poison_duration = config.poisonous_thorns_poison_duration.get();
        tools_effects_amplifier = config.tools_effects_amplifier.get();
        tools_nausea_duration = config.tools_nausea_duration.get();
        tools_poison_duration = config.tools_poison_duration.get();

        tools_percentage_damage_percent = config.tools_percentage_damage_percent.get();
        damage_deflection_amplifier = config.damage_deflection_amplifier.get();

        spelunker_amplifier = config.spelunker_amplifier.get();
        tools_haste_amplifier = config.tools_haste_amplifier.get();

        tools_levitation_amplifier = config.tools_levitation_amplifier.get();
        tools_levitation_duration = config.tools_levitation_duration.get();
        arcane_aura_amplifier = config.arcane_aura_amplifier.get();
        arcane_aura_levitation_duration = config.arcane_aura_levitation_duration.get();

        tools_bouncer_amplifier = config.tools_bouncer_amplifier.get();
        speed_amplifier = config.speed_amplifier.get();
        tools_bouncer_jump_boost_duration = config.tools_bouncer_jump_boost_duration.get();
        jump_boost_amplifier = config.jump_boost_amplifier.get();
    }
    
    public void updateByPacket(MUConfigPacket muConfigPacket) {
        tools_freeze_duration = muConfigPacket.tools_freeze_duration();
        ice_shield_amplifier = muConfigPacket.ice_shield_amplifier();
        ice_shield_slowness_duration = muConfigPacket.ice_shield_slowness_duration();

        topaz_tools_fire_seconds = muConfigPacket.topaz_tools_fire_seconds();
        item_mastery_amplifier = muConfigPacket.item_mastery_amplifier();

        poisonous_thorns_amplifier = muConfigPacket.poisonous_thorns_amplifier();
        poisonous_thorns_nausea_duration = muConfigPacket.poisonous_thorns_nausea_duration();
        poisonous_thorns_poison_duration = muConfigPacket.poisonous_thorns_poison_duration();
        tools_effects_amplifier = muConfigPacket.tools_effects_amplifier();
        tools_nausea_duration = muConfigPacket.tools_nausea_duration();
        tools_poison_duration = muConfigPacket.tools_poison_duration();

        tools_percentage_damage_percent = muConfigPacket.tools_percentage_damage_percent();
        damage_deflection_amplifier = muConfigPacket.damage_deflection_amplifier();

        spelunker_amplifier = muConfigPacket.spelunker_amplifier();
        tools_haste_amplifier = muConfigPacket.tools_haste_amplifier();

        tools_levitation_amplifier = muConfigPacket.tools_levitation_amplifier();
        tools_levitation_duration = muConfigPacket.tools_levitation_duration();
        arcane_aura_amplifier = muConfigPacket.arcane_aura_amplifier();
        arcane_aura_levitation_duration = muConfigPacket.arcane_aura_levitation_duration();

        tools_bouncer_amplifier = muConfigPacket.tools_bouncer_amplifier();
        speed_amplifier = muConfigPacket.speed_amplifier();
        tools_bouncer_jump_boost_duration = muConfigPacket.tools_bouncer_jump_boost_duration();
        jump_boost_amplifier = muConfigPacket.jump_boost_amplifier();
    }
    
    public void updateByOtherCache(MUConfigCache configCache) {
        tools_freeze_duration = configCache.getTools_freeze_duration();
        ice_shield_amplifier = configCache.getIce_shield_amplifier();
        ice_shield_slowness_duration = configCache.getIce_shield_slowness_duration();

        topaz_tools_fire_seconds = configCache.getTopaz_tools_fire_seconds();
        item_mastery_amplifier = configCache.getItem_mastery_amplifier();

        poisonous_thorns_amplifier = configCache.getPoisonous_thorns_amplifier();
        poisonous_thorns_nausea_duration = configCache.getPoisonous_thorns_nausea_duration();
        poisonous_thorns_poison_duration = configCache.getPoisonous_thorns_poison_duration();
        tools_effects_amplifier = configCache.getTools_effects_amplifier();
        tools_nausea_duration = configCache.getTools_nausea_duration();
        tools_poison_duration = configCache.getTools_poison_duration();

        tools_percentage_damage_percent = configCache.getTools_percentage_damage_percent();
        damage_deflection_amplifier = configCache.getDamage_deflection_amplifier();

        spelunker_amplifier = configCache.getSpelunker_amplifier();
        tools_haste_amplifier = configCache.getTools_haste_amplifier();

        tools_levitation_amplifier = configCache.getTools_levitation_amplifier();
        tools_levitation_duration = configCache.getTools_levitation_duration();
        arcane_aura_amplifier = configCache.getArcane_aura_amplifier();
        arcane_aura_levitation_duration = configCache.getArcane_aura_levitation_duration();

        tools_bouncer_amplifier = configCache.getTools_bouncer_amplifier();
        speed_amplifier = configCache.getSpeed_amplifier();
        tools_bouncer_jump_boost_duration = configCache.getTools_bouncer_jump_boost_duration();
        jump_boost_amplifier = configCache.getJump_boost_amplifier();
    }
        
    public double getTools_freeze_duration() {
        return tools_freeze_duration;
    }

    public double getIce_shield_slowness_duration() {
        return ice_shield_slowness_duration;
    }

    public int getIce_shield_amplifier() {
        return ice_shield_amplifier;
    }

    public int getTools_effects_amplifier() {
        return tools_effects_amplifier;
    }

    public double getTools_poison_duration() {
        return tools_poison_duration;
    }

    public double getTools_nausea_duration() {
        return tools_nausea_duration;
    }

    public int getPoisonous_thorns_amplifier() {
        return poisonous_thorns_amplifier;
    }

    public double getPoisonous_thorns_poison_duration() {
        return poisonous_thorns_poison_duration;
    }

    public double getPoisonous_thorns_nausea_duration() {
        return poisonous_thorns_nausea_duration;
    }

    public double getTopaz_tools_fire_seconds() {
        return topaz_tools_fire_seconds;
    }

    public int getItem_mastery_amplifier() {
        return item_mastery_amplifier;
    }

    public int getTools_haste_amplifier() {
        return tools_haste_amplifier;
    }

    public int getSpelunker_amplifier() {
        return spelunker_amplifier;
    }

    public double getTools_percentage_damage_percent() {
        return tools_percentage_damage_percent;
    }

    public int getDamage_deflection_amplifier() {
        return damage_deflection_amplifier;
    }

    public double getTools_levitation_duration() {
        return tools_levitation_duration;
    }

    public int getTools_levitation_amplifier() {
        return tools_levitation_amplifier;
    }

    public double getArcane_aura_levitation_duration() {
        return arcane_aura_levitation_duration;
    }

    public int getArcane_aura_amplifier() {
        return arcane_aura_amplifier;
    }

    public double getTools_bouncer_jump_boost_duration() {
        return tools_bouncer_jump_boost_duration;
    }

    public int getTools_bouncer_amplifier() {
        return tools_bouncer_amplifier;
    }

    public int getSpeed_amplifier() {
        return speed_amplifier;
    }

    public int getJump_boost_amplifier() {
        return jump_boost_amplifier;
    }
}