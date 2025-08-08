package net.trique.mythicupgrades.config;


import net.trique.mythicupgrades.networking.packet.config.*;

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


    public void processAquamarinePacket(AquamarineClientConfigPacket packet) {
        tools_freeze_duration = packet.tools_freeze_duration();
        ice_shield_amplifier = packet.ice_shield_amplifier();
        ice_shield_slowness_duration = packet.ice_shield_slowness_duration();
    }
    public AquamarineConfigPacket makeAquamarinePacket() {
        return new AquamarineConfigPacket(tools_freeze_duration, ice_shield_slowness_duration,
                ice_shield_amplifier);
    }

    public void processTopazPacket(TopazClientConfigPacket packet) {
        topaz_tools_fire_seconds = packet.topaz_tools_fire_seconds();
        item_mastery_amplifier = packet.item_mastery_amplifier();
    }
    public TopazConfigPacket makeTopazPacket() {
        return new TopazConfigPacket(topaz_tools_fire_seconds, item_mastery_amplifier);
    }

    public void processPeridotPacket(PeridotClientConfigPacket packet) {
        poisonous_thorns_amplifier = packet.poisonous_thorns_amplifier();
        poisonous_thorns_nausea_duration = packet.poisonous_thorns_nausea_duration();
        poisonous_thorns_poison_duration = packet.poisonous_thorns_poison_duration();
        tools_effects_amplifier = packet.tools_effects_amplifier();
        tools_nausea_duration = packet.tools_nausea_duration();
        tools_poison_duration = packet.tools_poison_duration();
    }
    public PeridotConfigPacket makePeridotPacket() {
        return new PeridotConfigPacket(tools_effects_amplifier, tools_poison_duration, tools_nausea_duration,
                poisonous_thorns_amplifier, poisonous_thorns_poison_duration, poisonous_thorns_nausea_duration);
    }

    public void processSapphirePacket(SapphireClientConfigPacket packet) {
        tools_percentage_damage_percent = packet.tools_percentage_damage_percent();
        damage_deflection_amplifier = packet.damage_deflection_amplifier();
    }
    public SapphireConfigPacket makeSapphirePacket() {
        return new SapphireConfigPacket(tools_percentage_damage_percent, damage_deflection_amplifier);
    }

    public void processRubyPacket(RubyClientConfigPacket packet) {
        spelunker_amplifier = packet.spelunker_amplifier();
        tools_haste_amplifier = packet.tools_haste_amplifier();
    }
    public RubyConfigPacket makeRubyPacket() {
        return new RubyConfigPacket(tools_haste_amplifier, spelunker_amplifier);
    }

    public void processAmetrinePacket(AmetrineClientConfigPacket packet) {
        tools_levitation_amplifier = packet.tools_levitation_amplifier();
        tools_levitation_duration = packet.tools_levitation_duration();
        arcane_aura_amplifier = packet.arcane_aura_amplifier();
        arcane_aura_levitation_duration = packet.arcane_aura_levitation_duration();
    }
    public AmetrineConfigPacket makeAmetrinePacket() {
        return new AmetrineConfigPacket(tools_levitation_duration, tools_levitation_amplifier,
                arcane_aura_levitation_duration, arcane_aura_amplifier);
    }

    public void processJadePacket(JadeClientConfigPacket packet) {
        tools_bouncer_amplifier = packet.tools_bouncer_amplifier();
        speed_amplifier = packet.speed_amplifier();
        tools_bouncer_jump_boost_duration = packet.tools_bouncer_jump_boost_duration();
        jump_boost_amplifier = packet.jump_boost_amplifier();
    }
    public JadeConfigPacket makeJadePacket() {
        return new JadeConfigPacket(tools_bouncer_jump_boost_duration, tools_bouncer_amplifier,
                speed_amplifier, jump_boost_amplifier);
    }
    
}
