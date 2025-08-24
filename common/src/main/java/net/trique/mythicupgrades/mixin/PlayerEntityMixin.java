package net.trique.mythicupgrades.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import me.cybersteve.equiplib.item.handheld.base.IEffectHandHeldItem;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.JadeData;
import net.trique.mythicupgrades.config.gem_data.SapphireData;
import net.trique.mythicupgrades.config.gem_data.TopazData;
import net.trique.mythicupgrades.util.MUDamageTypes;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import me.cybersteve.equiplib.util.EffectMeta;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.trique.mythicupgrades.registry.EffectRegistry.*;
import static net.trique.mythicupgrades.util.CommonFunctions.getEnchantmentLevel;

@Debug(export = true)
@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }


    protected void percentHit(Entity entity) {

    }


    @WrapOperation(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private boolean applyEffectsOnSweeping(LivingEntity target, DamageSource source, float amount, Operation<Boolean> original) {
        Item weapon = this.getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof SwordItem && weapon instanceof IEffectHandHeldItem sword) {
            for (var effectEntry : sword.getEffectsForTargetOnAttack(source, this, amount).data().entrySet()) {
                Holder<MobEffect> effect = effectEntry.getKey();
                EffectMeta meta = effectEntry.getValue();
                int duration = meta.duration();
                int amplifier = meta.amplifier();
                boolean ambient = meta.ambient();
                boolean showIcon = meta.showIcon();
                boolean showParticles = meta.showParticles();
                double sweeping_amplifier = this.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO);
                target.addEffect(new MobEffectInstance(effect, duration, Math.max(0, (int) (amplifier - 0.75 + sweeping_amplifier)), ambient, showParticles, showIcon));
            }
        }
        return original.call(target, source, amount);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applySapphirePercentageDamage(Entity entity, CallbackInfo ci, @Local(ordinal = 2) float h) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.SAPPHIRE)) {
            SapphireData data = MUConfigHelper.getSapphireValues();
            double percent = data.tools_percentage_damage_percent();
            DamageSource source = MUDamageTypes.percentage_damage(this);
            float dmg = ((float) percent / 100f) * h * h;
            if (entity.invulnerableTime <= 10) {
                if (entity instanceof EnderDragonPart part) {
                    EnderDragon dragon = part.parentMob;
                    dmg *= dragon.getMaxHealth();
                    dragon.hurt(part, source, dmg);
                    percentHit(entity);
                } else if (entity instanceof LivingEntity target) {
                    dmg *= target.getMaxHealth();
                    target.hurt(source, dmg);
                    percentHit(target);
                }
                entity.invulnerableTime = 0;
            }
        }
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applySapphirePercentageDamageOnSweeping(Entity entity, CallbackInfo ci,
                                                         @Local(ordinal = 0) LivingEntity livingEntity) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.TOPAZ)) {
            SapphireData data = MUConfigHelper.getSapphireValues();
            double percent = data.tools_percentage_damage_percent();
            DamageSource source = MUDamageTypes.percentage_damage(this);
            float dmg = ((float) percent / 200f) * (0.7f + 0.1f * getEnchantmentLevel(Enchantments.SWEEPING_EDGE, this.level(), getItemBySlot(EquipmentSlot.MAINHAND)));
            if (livingEntity.invulnerableTime <= 10) {
                dmg *= livingEntity.getMaxHealth();
                livingEntity.hurt(source, dmg);
                percentHit(livingEntity);
                livingEntity.invulnerableTime = 0;
            }
        }
    }

    @WrapOperation(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private boolean applyBouncerEffect(Entity target, DamageSource source, float amount, Operation<Boolean> original) {
        if (this.hasEffect(BOUNCER)) {
            int ampl = this.getEffect(BOUNCER).getAmplifier();
            JadeData data = MUConfigHelper.getJadeValues();
            this.addEffect(new MobEffectInstance(MobEffects.JUMP, (int)
                    (data.tools_bouncer_jump_boost_duration() * 20), ampl));
        }
        return original.call(target, source, amount);
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void setEntityOnFire(Entity entity, CallbackInfo ci) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.TOPAZ)) {
            TopazData data = MUConfigHelper.getTopazValues();
            double time = data.topaz_tools_fire_seconds();
            entity.igniteForSeconds((float) time);
        }
    }

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void setEntityOnFireSweeping(Entity entity, CallbackInfo ci,
                                         @Local(ordinal = 0) LivingEntity livingEntity) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.TOPAZ)) {
            TopazData data = MUConfigHelper.getTopazValues();
            double time = data.topaz_tools_fire_seconds();
            livingEntity.igniteForSeconds((float) time);
        }
    }
}