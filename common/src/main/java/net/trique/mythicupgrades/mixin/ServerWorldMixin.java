package net.trique.mythicupgrades.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.trique.mythicupgrades.effect.MUEffects;
import net.trique.mythicupgrades.util.ItemEffectsList;
import net.trique.mythicupgrades.util.ItemEffectsListBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static net.trique.mythicupgrades.config.Config.*;
import static net.trique.mythicupgrades.effect.MUEffects.*;
import static net.trique.mythicupgrades.item.MUItems.*;

@Mixin(ServerLevel.class)
public abstract class ServerWorldMixin {
    @Inject(method = "tick", at = @At(value = "HEAD"))

    private void updateByConfigs(CallbackInfo ci) {
        ItemEffectsList aquamarineArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(OCEAN_SHIELD, OCEAN_SHIELD_AMPLIFIER.get()).addForEquipmentBuffs(MobEffects.DOLPHINS_GRACE, 0).addForEquipmentBuffs(MobEffects.WATER_BREATHING, 0).build();
        List<Integer> aquamarineAmplifiers = List.of(OCEAN_SHIELD_AMPLIFIER.get());

        ItemEffectsList citrineArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(HINDERING, HINDERING_AMPLIFIER.get()).build();
        List<Integer> citrineAmplifiers = List.of(HINDERING_AMPLIFIER.get());

        ItemEffectsList peridotArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(MUEffects.POISONOUS_THORNS, POISONOUS_THORNS_AMPLIFIER.get()).build();
        List<Integer> peridotAmplifiers = List.of(POISONOUS_THORNS_AMPLIFIER.get());

        ItemEffectsList zirconArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(ICE_SHIELD, ICE_SHIELD_AMPLIFIER.get()).build();
        List<Integer> zirconAmplifiers = List.of(ICE_SHIELD_AMPLIFIER.get());

        ItemEffectsList sapphireArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(MUEffects.DAMAGE_DEFLECTION, DAMAGE_DEFLECTION_AMPLIFIER.get()).build();
        List<Integer> sapphireAmplifiers = List.of(DAMAGE_DEFLECTION_AMPLIFIER.get());

        ItemEffectsList topazArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(ITEM_MASTERY, ITEM_MASTERY_AMPLIFIER.get()).addForEquipmentBuffs(MobEffects.FIRE_RESISTANCE, 0).build();
        List<Integer> topazAmplifiers = List.of(ITEM_MASTERY_AMPLIFIER.get());

        ItemEffectsList ametrineArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(ARCANE_AURA, ARCANE_AURA_AMPLIFIER.get()).build();
        List<Integer> ametrineAmplifiers = List.of(ARCANE_AURA_AMPLIFIER.get());

        ItemEffectsList jadeArmorEffects = new ItemEffectsListBuilder().addForEquipmentBuffs(MobEffects.MOVEMENT_SPEED, SPEED_AMPLIFIER.get()).addForEquipmentBuffs(MobEffects.JUMP, JUMP_BOOST_AMPLIFIER.get()).build();
        List<Integer> jadeAmplifiers = List.of(SPEED_AMPLIFIER.get(), JUMP_BOOST_AMPLIFIER.get());

        ItemEffectsList hinderingAxeItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.WEAKNESS, (int)(WEAPONS_WEAKNESS_DURATION.get() * 20), WEAPONS_WEAKNESS_AMPLIFIER.get()).addForHit(MobEffects.MOVEMENT_SLOWDOWN, (int)(WEAPONS_SLOWNESS_DURATION.get() * 20), WEAPONS_SLOWNESS_AMPLIFIER.get()).addForHit(MobEffects.HUNGER, (int)(WEAPONS_HUNGER_DURATION.get() * 20), WEAPONS_HUNGER_AMPLIFIER.get()).build();
        ItemEffectsList hinderingSwordItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.WEAKNESS, (int)(WEAPONS_WEAKNESS_DURATION.get() * 20), WEAPONS_WEAKNESS_AMPLIFIER.get()).addForHit(MobEffects.MOVEMENT_SLOWDOWN, (int)(WEAPONS_SLOWNESS_DURATION.get() * 20), WEAPONS_SLOWNESS_AMPLIFIER.get()).addForHit(MobEffects.HUNGER, (int)(WEAPONS_HUNGER_DURATION.get() * 20), WEAPONS_HUNGER_AMPLIFIER.get()).build();

        ItemEffectsList poisonSwordItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.POISON, (int)(WEAPONS_POISON_DURATION.get() * 20), WEAPONS_POISON_AMPLIFIER.get()).build();
        ItemEffectsList poisonAxeItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.POISON, (int)(WEAPONS_POISON_DURATION.get() * 20), WEAPONS_POISON_AMPLIFIER.get()).build();

        ItemEffectsList freezeAxeItemEffects = new ItemEffectsListBuilder().addForHit(MUEffects.FREEZE, (int)(WEAPONS_FREEZE_DURATION.get() * 20), 0).build();
        ItemEffectsList freezeSwordItemEffects = new ItemEffectsListBuilder().addForHit(MUEffects.FREEZE, (int)(WEAPONS_FREEZE_DURATION.get() * 20), 0).build();

        ItemEffectsList hasteAxeItemEffects = new ItemEffectsListBuilder().addForMainHand(MobEffects.DIG_SPEED, MobEffectInstance.INFINITE_DURATION, TOOLS_HASTE_AMPLIFIER.get()).build();
        ItemEffectsList hastePickaxeItemEffects = new ItemEffectsListBuilder().addForMainHand(MobEffects.DIG_SPEED, MobEffectInstance.INFINITE_DURATION, TOOLS_HASTE_AMPLIFIER.get()).build();
        ItemEffectsList hasteHoeItemEffects = new ItemEffectsListBuilder().addForMainHand(MobEffects.DIG_SPEED, MobEffectInstance.INFINITE_DURATION, TOOLS_HASTE_AMPLIFIER.get()).build();
        ItemEffectsList hasteShovelItemEffects = new ItemEffectsListBuilder().addForMainHand(MobEffects.DIG_SPEED, MobEffectInstance.INFINITE_DURATION, TOOLS_HASTE_AMPLIFIER.get()).build();

        ItemEffectsList levitationAxeItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.LEVITATION, (int)(WEAPONS_LEVITATION_DURATION.get() * 20), WEAPONS_LEVITATION_AMPLIFIER.get()).build();
        ItemEffectsList levitationSwordItemEffects = new ItemEffectsListBuilder().addForHit(MobEffects.LEVITATION, (int)(WEAPONS_LEVITATION_DURATION.get() * 20), WEAPONS_LEVITATION_AMPLIFIER.get()).build();

        CITRINE_AXE.setNewEffects(hinderingAxeItemEffects);
        CITRINE_SWORD.setNewEffects(hinderingSwordItemEffects);

        PERIDOT_AXE.setNewEffects(poisonAxeItemEffects);
        PERIDOT_SWORD.setNewEffects(poisonSwordItemEffects);

        ZIRCON_AXE.setNewEffects(freezeAxeItemEffects);
        ZIRCON_SWORD.setNewEffects(freezeSwordItemEffects);

        RUBY_AXE.setNewEffects(hasteAxeItemEffects);
        RUBY_PICKAXE.setNewEffects(hastePickaxeItemEffects);
        RUBY_SHOVEL.setNewEffects(hasteShovelItemEffects);
        RUBY_HOE.setNewEffects(hasteHoeItemEffects);

        SAPPHIRE_SWORD.setPercent(WEAPONS_PERCENTAGE_DAMAGE_PERCENT.get());
        SAPPHIRE_AXE.setPercent(WEAPONS_PERCENTAGE_DAMAGE_PERCENT.get());

        AMETRINE_AXE.setNewEffects(levitationAxeItemEffects);
        AMETRINE_SWORD.setNewEffects(levitationSwordItemEffects);

        AQUAMARINE_HELMET.setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_CHESTPLATE.setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_LEGGINGS.setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);
        AQUAMARINE_BOOTS.setNewEffects(aquamarineArmorEffects, aquamarineAmplifiers);

        CITRINE_HELMET.setNewEffects(citrineArmorEffects, citrineAmplifiers);
        CITRINE_CHESTPLATE.setNewEffects(citrineArmorEffects, citrineAmplifiers);
        CITRINE_LEGGINGS.setNewEffects(topazArmorEffects, citrineAmplifiers);
        CITRINE_BOOTS.setNewEffects(topazArmorEffects, citrineAmplifiers);

        PERIDOT_HELMET.setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_CHESTPLATE.setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_LEGGINGS.setNewEffects(peridotArmorEffects, peridotAmplifiers);
        PERIDOT_BOOTS.setNewEffects(peridotArmorEffects, peridotAmplifiers);

        ZIRCON_HELMET.setNewEffects(zirconArmorEffects, zirconAmplifiers);
        ZIRCON_CHESTPLATE.setNewEffects(zirconArmorEffects, zirconAmplifiers);
        ZIRCON_LEGGINGS.setNewEffects(zirconArmorEffects, zirconAmplifiers);
        ZIRCON_BOOTS.setNewEffects(zirconArmorEffects, zirconAmplifiers);

        SAPPHIRE_HELMET.setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_CHESTPLATE.setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_LEGGINGS.setNewEffects(sapphireArmorEffects, sapphireAmplifiers);
        SAPPHIRE_BOOTS.setNewEffects(sapphireArmorEffects, sapphireAmplifiers);

        TOPAZ_HELMET.setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_CHESTPLATE.setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_LEGGINGS.setNewEffects(topazArmorEffects, topazAmplifiers);
        TOPAZ_BOOTS.setNewEffects(topazArmorEffects, topazAmplifiers);

        AMETRINE_HELMET.setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_CHESTPLATE.setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_LEGGINGS.setNewEffects(ametrineArmorEffects, ametrineAmplifiers);
        AMETRINE_BOOTS.setNewEffects(ametrineArmorEffects, ametrineAmplifiers);

        JADE_HELMET.setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_CHESTPLATE.setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_LEGGINGS.setNewEffects(jadeArmorEffects, jadeAmplifiers);
        JADE_BOOTS.setNewEffects(jadeArmorEffects, jadeAmplifiers);
    }
}