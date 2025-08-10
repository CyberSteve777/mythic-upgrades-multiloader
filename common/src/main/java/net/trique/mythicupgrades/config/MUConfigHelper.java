package net.trique.mythicupgrades.config;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.trique.mythicupgrades.networking.packet.config.*;
import net.trique.mythicupgrades.util.ItemEffectsList;

import java.util.List;

import static net.trique.mythicupgrades.registry.EffectRegistry.*;
import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class MUConfigHelper {

    private static final MUConfigCache PLAYER_CACHE = new MUConfigCache();

    public static void updateJadeValues(JadeConfigPacket packet) {
        ItemEffectsList jadeArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(MobEffects.MOVEMENT_SPEED, packet.speed_amplifier()).addForEquipmentBuffs(MobEffects.JUMP, packet.jump_boost_amplifier()).build();
        List<Integer> jadeAmplifiers = List.of(packet.speed_amplifier(), packet.jump_boost_amplifier());

        ItemEffectsList bouncerToolEffect = new ItemEffectsList.Builder().addForMainHand(BOUNCER, MobEffectInstance.INFINITE_DURATION, packet.tools_bouncer_amplifier()).build();

        JADE_AXE.get().setNewEffects(bouncerToolEffect);
        JADE_SHOVEL.get().setNewEffects(bouncerToolEffect);
        JADE_PICKAXE.get().setNewEffects(bouncerToolEffect);
        JADE_HOE.get().setNewEffects(bouncerToolEffect);
        JADE_SWORD.get().setNewEffects(bouncerToolEffect);


        JADE_HELMET.get().setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_CHESTPLATE.get().setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_LEGGINGS.get().setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_BOOTS.get().setNewEffects(jadeArmorEffects, jadeAmplifiers);
    }

    public static void updatePeridotValues(PeridotConfigPacket packet) {
        ItemEffectsList peridotArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(POISONOUS_THORNS, packet.poisonous_thorns_amplifier()).build();
        List<Integer> peridotAmplifiers = List.of(packet.poisonous_thorns_amplifier());

        ItemEffectsList poisonToolEffects = new ItemEffectsList.Builder().addForHitToEnemy(MobEffects.POISON, (int) (packet.tools_poison_duration() * 20), packet.tools_effects_amplifier()).
                addForHitToEnemy(MobEffects.CONFUSION, (int) (packet.tools_nausea_duration() * 20), packet.tools_effects_amplifier()).build();

        PERIDOT_AXE.get().setNewEffects(poisonToolEffects);
        PERIDOT_SHOVEL.get().setNewEffects(poisonToolEffects);
        PERIDOT_PICKAXE.get().setNewEffects(poisonToolEffects);
        PERIDOT_HOE.get().setNewEffects(poisonToolEffects);
        PERIDOT_SWORD.get().setNewEffects(poisonToolEffects);

        PERIDOT_HELMET.get().setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_CHESTPLATE.get().setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_LEGGINGS.get().setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_BOOTS.get().setNewEffects(peridotArmorEffects, peridotAmplifiers);

    }

    public static void updateAquamarineValues(AquamarineConfigPacket packet) {
        ItemEffectsList aquamarineArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(ICE_SHIELD, packet.ice_shield_amplifier()).build();
        List<Integer> aquamarineAmplifiers = List.of(packet.ice_shield_amplifier());

        ItemEffectsList freezeToolEffects = new ItemEffectsList.Builder().addForHitToEnemy(FREEZE, (int) (packet.tools_freeze_duration() * 20), 0).build();

        AQUAMARINE_AXE.get().setNewEffects(freezeToolEffects);
        AQUAMARINE_PICKAXE.get().setNewEffects(freezeToolEffects);
        AQUAMARINE_SHOVEL.get().setNewEffects(freezeToolEffects);
        AQUAMARINE_HOE.get().setNewEffects(freezeToolEffects);
        AQUAMARINE_SWORD.get().setNewEffects(freezeToolEffects);

        AQUAMARINE_HELMET.get().setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_CHESTPLATE.get().setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_LEGGINGS.get().setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_BOOTS.get().setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);

    }

    public static void updateTopazValues(TopazConfigPacket packet) {
        ItemEffectsList topazArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(ITEM_MASTERY, packet.item_mastery_amplifier()).addForEquipmentBuffs(MobEffects.FIRE_RESISTANCE, 0).build();
        List<Integer> topazAmplifiers = List.of(packet.item_mastery_amplifier());

        TOPAZ_HELMET.get().setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_CHESTPLATE.get().setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_LEGGINGS.get().setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_BOOTS.get().setNewEffects(topazArmorEffects, topazAmplifiers);

    }

    public static void updateRubyValues(RubyConfigPacket packet) {
        ItemEffectsList rubyArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(SPELUNKER, packet.spelunker_amplifier()).build();
        List<Integer> rubyAmplifiers = List.of(packet.spelunker_amplifier());

        ItemEffectsList hasteToolEffects = new ItemEffectsList.Builder().addForMainHand(MobEffects.DIG_SPEED, MobEffectInstance.INFINITE_DURATION, packet.tools_haste_amplifier()).build();

        RUBY_AXE.get().setNewEffects(hasteToolEffects);
        RUBY_PICKAXE.get().setNewEffects(hasteToolEffects);
        RUBY_SHOVEL.get().setNewEffects(hasteToolEffects);
        RUBY_HOE.get().setNewEffects(hasteToolEffects);
        RUBY_SWORD.get().setNewEffects(hasteToolEffects);

        RUBY_HELMET.get().setNewEffects(rubyArmorEffects, rubyAmplifiers);
        RUBY_CHESTPLATE.get().setNewEffects(rubyArmorEffects, rubyAmplifiers);
        RUBY_LEGGINGS.get().setNewEffects(rubyArmorEffects, rubyAmplifiers);
        RUBY_BOOTS.get().setNewEffects(rubyArmorEffects, rubyAmplifiers);
    }

    public static void updateSapphireValues(SapphireConfigPacket packet) {
        ItemEffectsList sapphireArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(DAMAGE_DEFLECTION, packet.damage_deflection_amplifier()).build();
        List<Integer> sapphireAmplifiers = List.of(packet.damage_deflection_amplifier());

        SAPPHIRE_AXE.get().setPercent(packet.tools_percentage_damage_percent());
        SAPPHIRE_SHOVEL.get().setPercent(packet.tools_percentage_damage_percent());
        SAPPHIRE_PICKAXE.get().setPercent(packet.tools_percentage_damage_percent());
        SAPPHIRE_HOE.get().setPercent(packet.tools_percentage_damage_percent());
        SAPPHIRE_SWORD.get().setPercent(packet.tools_percentage_damage_percent());

        SAPPHIRE_HELMET.get().setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_CHESTPLATE.get().setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_LEGGINGS.get().setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_BOOTS.get().setNewEffects(sapphireArmorEffects, sapphireAmplifiers);


    }

    public static void updateAmetrineValues(AmetrineConfigPacket packet) {
        ItemEffectsList ametrineArmorEffects = new ItemEffectsList.Builder().addForEquipmentBuffs(ARCANE_AURA, packet.arcane_aura_amplifier()).build();
        List<Integer> ametrineAmplifiers = List.of(packet.arcane_aura_amplifier());

        ItemEffectsList levitationToolEffects = new ItemEffectsList.Builder().addForHitToEnemy(MobEffects.LEVITATION, (int) (packet.tools_levitation_duration() * 20), packet.tools_levitation_amplifier()).build();

        AMETRINE_AXE.get().setNewEffects(levitationToolEffects);
        AMETRINE_SHOVEL.get().setNewEffects(levitationToolEffects);
        AMETRINE_PICKAXE.get().setNewEffects(levitationToolEffects);
        AMETRINE_HOE.get().setNewEffects(levitationToolEffects);
        AMETRINE_SWORD.get().setNewEffects(levitationToolEffects);

        AMETRINE_HELMET.get().setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_CHESTPLATE.get().setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_LEGGINGS.get().setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_BOOTS.get().setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
    }

    public static void cachePlayerAquamarineValues() {
        PLAYER_CACHE.cacheAquamarineValues();
    }

    public static void cachePlayerTopazValues() {
        PLAYER_CACHE.cacheTopazValues();
    }

    public static void cachePlayerPeridotValues() {
        PLAYER_CACHE.cachePeridotValues();
    }

    public static void cachePlayerRubyValues() {
        PLAYER_CACHE.cacheRubyValues();
    }

    public static void cachePlayerSapphireValues() {
        PLAYER_CACHE.cacheSapphireValues();
    }

    public static void cachePlayerAmetrineValues() {
        PLAYER_CACHE.cacheAmetrineValues();
    }

    public static void cachePlayerJadeValues() {
        PLAYER_CACHE.cacheJadeValues();
    }

    public static AquamarineConfigPacket getPlayerAquamarineCache() {
        return PLAYER_CACHE.makeAquamarinePacket();
    }

    public static TopazConfigPacket getPlayerTopazCache() {
        return PLAYER_CACHE.makeTopazPacket();
    }

    public static PeridotConfigPacket getPlayerPeridotCache() {
        return PLAYER_CACHE.makePeridotPacket();
    }

    public static SapphireConfigPacket getPlayerSapphireCache() {
        return PLAYER_CACHE.makeSapphirePacket();
    }

    public static RubyConfigPacket getPlayerRubyCache() {
        return PLAYER_CACHE.makeRubyPacket();
    }


    public static AmetrineConfigPacket getPlayerAmetrinePacket() {
        return PLAYER_CACHE.makeAmetrinePacket();
    }

    public static JadeConfigPacket getPlayerJadePacket() {
        return PLAYER_CACHE.makeJadePacket();
    }
}
