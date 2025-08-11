package net.trique.mythicupgrades.config;


import net.trique.mythicupgrades.networking.packet.config.*;


import static net.trique.mythicupgrades.config.MUConfig.CONFIG;
import static net.trique.mythicupgrades.config.MUConfig.CONFIG_SPEC;

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


    public void cacheAquamarineValues() {
        tools_freeze_duration = CONFIG.tools_freeze_duration.getAsDouble();
        ice_shield_amplifier = CONFIG.ice_shield_amplifier.getAsInt();
        ice_shield_slowness_duration = CONFIG.ice_shield_slowness_duration.getAsDouble();
    }
    public AquamarineConfigPacket makeAquamarinePacket() {
        return new AquamarineConfigPacket(tools_freeze_duration, ice_shield_slowness_duration, ice_shield_amplifier);
    }

    public void cacheTopazValues() {
        topaz_tools_fire_seconds = CONFIG.topaz_tools_fire_seconds.getAsDouble();
        item_mastery_amplifier = CONFIG.item_mastery_amplifier.getAsInt();
    }
    public TopazConfigPacket makeTopazPacket() {
        return new TopazConfigPacket(topaz_tools_fire_seconds, item_mastery_amplifier);
    }

    public void cachePeridotValues() {
        poisonous_thorns_amplifier = CONFIG.poisonous_thorns_amplifier.getAsInt();
        poisonous_thorns_nausea_duration = CONFIG.poisonous_thorns_nausea_duration.getAsDouble();
        poisonous_thorns_poison_duration = CONFIG.poisonous_thorns_poison_duration.getAsDouble();
        tools_effects_amplifier = CONFIG.tools_effects_amplifier.getAsInt();
        tools_nausea_duration = CONFIG.tools_nausea_duration.getAsDouble();
        tools_poison_duration = CONFIG.tools_poison_duration.getAsDouble();
    }
    public PeridotConfigPacket makePeridotPacket() {
        return new PeridotConfigPacket(tools_effects_amplifier, tools_poison_duration, tools_nausea_duration,
                poisonous_thorns_amplifier, poisonous_thorns_poison_duration, poisonous_thorns_nausea_duration);
    }

    public void cacheSapphireValues() {
        tools_percentage_damage_percent = CONFIG.tools_percentage_damage_percent.getAsDouble();
        damage_deflection_amplifier = CONFIG.damage_deflection_amplifier.getAsInt();
    }
    public SapphireConfigPacket makeSapphirePacket() {
        return new SapphireConfigPacket(tools_percentage_damage_percent, damage_deflection_amplifier);
    }

    public void cacheRubyValues() {
        spelunker_amplifier = CONFIG.spelunker_amplifier.getAsInt();
        tools_haste_amplifier = CONFIG.tools_haste_amplifier.getAsInt();
    }
    public RubyConfigPacket makeRubyPacket() {
        return new RubyConfigPacket(tools_haste_amplifier, spelunker_amplifier);
    }

    public void cacheAmetrineValues() {
        tools_levitation_amplifier = CONFIG.tools_levitation_amplifier.getAsInt();
        tools_levitation_duration = CONFIG.tools_levitation_duration.getAsDouble();
        arcane_aura_amplifier = CONFIG.arcane_aura_amplifier.getAsInt();
        arcane_aura_levitation_duration = CONFIG.arcane_aura_levitation_duration.getAsDouble();
    }
    public AmetrineConfigPacket makeAmetrinePacket() {
        return new AmetrineConfigPacket(tools_levitation_duration, tools_levitation_amplifier,
                arcane_aura_levitation_duration, arcane_aura_amplifier);
    }

    public void cacheJadeValues() {
        tools_bouncer_amplifier = CONFIG.tools_bouncer_amplifier.getAsInt();
        speed_amplifier = CONFIG.speed_amplifier.getAsInt();
        tools_bouncer_jump_boost_duration = CONFIG.tools_bouncer_jump_boost_duration.getAsDouble();
        jump_boost_amplifier = CONFIG.jump_boost_amplifier.getAsInt();
    }
    public JadeConfigPacket makeJadePacket() {
        return new JadeConfigPacket(tools_bouncer_jump_boost_duration, tools_bouncer_amplifier,
                speed_amplifier, jump_boost_amplifier);
    }
    
}
