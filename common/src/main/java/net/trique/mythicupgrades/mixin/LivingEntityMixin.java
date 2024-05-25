package net.trique.mythicupgrades.mixin;

import com.llamalad7.mixinextras.injector.WrapWithCondition;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.MythicUpgradesDamageTypes;
import net.trique.mythicupgrades.effect.MUEffects;
import net.trique.mythicupgrades.item.BaseMythicItem;
import net.trique.mythicupgrades.item.MythicEffectsArmorItem;
import net.trique.mythicupgrades.util.CommonFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.function.Consumer;

import static net.trique.mythicupgrades.util.CommonFunctions.checkForItemMastery;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
        deflecting_damage = 0f;
        has_damage_been_deflected = false;
    }

    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot slot);

    @Shadow
    public abstract Map<MobEffect, MobEffectInstance> getActiveEffectsMap();

    @Unique private boolean has_damage_been_deflected;

    @Unique private float deflecting_damage;

    @Unique
    private BaseMythicItem lastUsed;

    @Unique
    private MythicEffectsArmorItem lastWorn;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void checkItemInHand(CallbackInfo ci) {
        if (!this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty() &&
                (this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BaseMythicItem item)) {
            if (lastUsed != null && !item.equals(lastUsed)) {
                CommonFunctions.removeMythicInfiniteEffects((LivingEntity) (Object) this, lastUsed.getMainHandEffects());
            }
            if (CommonFunctions.checkStatusEffects((LivingEntity) (Object) this, item.getMainHandEffects())) {
                CommonFunctions.addStatusEffects((LivingEntity) (Object) this, item.getMainHandEffects());
            }
            lastUsed = item;
        } else if (lastUsed != null) {
            CommonFunctions.removeMythicInfiniteEffects((LivingEntity) (Object) this, lastUsed.getMainHandEffects());
            lastUsed = null;
        }
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void applyArmorBuffs(CallbackInfo ci) {
        ItemStack head = this.getItemBySlot(EquipmentSlot.HEAD);
        if (!head.isEmpty() && head.getItem() instanceof MythicEffectsArmorItem item) {
            if (lastWorn != null && !CommonFunctions.hasCorrectArmorOn((LivingEntity) (Object) this, item.getMaterial())) {
                CommonFunctions.removeMythicInfiniteEffects((LivingEntity) (Object) this, lastWorn.getEquipmentBuffs());
            }
            if (CommonFunctions.hasCorrectArmorOn((LivingEntity) (Object) this, item.getMaterial()) &&
                    CommonFunctions.checkStatusEffects((LivingEntity) (Object) this, item.getEquipmentBuffs())) {
                CommonFunctions.addStatusEffects((LivingEntity) (Object) this, item.getEquipmentBuffs());
            }
            lastWorn = item;
        } else if (lastWorn != null) {
            CommonFunctions.removeMythicInfiniteEffects((LivingEntity) (Object) this, lastWorn.getEquipmentBuffs());
            lastWorn = null;
        }
    }

    @Inject(method = "hurt", at = @At(value = "RETURN"))
    private void applyArmorDebuffs(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        boolean was_damaged = cir.getReturnValue();
        if (was_damaged) {
            Entity attacker = source.getEntity();
            if (attacker instanceof LivingEntity entity) {
                ItemStack head = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!head.isEmpty() && head.getItem() instanceof MythicEffectsArmorItem item &&
                        CommonFunctions.hasCorrectArmorOn((LivingEntity) (Object) this, item.getMaterial())) {
                    CommonFunctions.addStatusEffects(entity, item.getEquipmentDebuffs(), (LivingEntity) (Object) this);
                }
            }
        }
    }

    @ModifyVariable(method = "hurt", at = @At(value = "HEAD"), argsOnly = true)
    private float reduceIncomingDamage(float amount, DamageSource source, float am1) {
        if (!this.level().isClientSide()) {
            MobEffectInstance deflection = this.getActiveEffectsMap().get(MUEffects.DAMAGE_DEFLECTION);
            if (deflection != null) {
                Entity attacker = source.getEntity();
                float defl_dmg_coef = deflection.getAmplifier() / 10f;
                if (attacker != null) {
                    deflecting_damage = (0.1f + defl_dmg_coef) * amount;
                    amount *= (0.9f - defl_dmg_coef);
                }
            }
            return amount;
        }
        return 0f;
    }

    @Inject(method = "hurt", at = @At(value = "TAIL"))
    private void deflectDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            MobEffectInstance deflection = this.getActiveEffectsMap().get(MUEffects.DAMAGE_DEFLECTION);
            if (deflection != null) {
                Entity attacker = source.getEntity();
                if (attacker != null && attacker.distanceTo(this) <= 3.0f && !has_damage_been_deflected) {
                    has_damage_been_deflected = true;
                    attacker.hurt(MythicUpgradesDamageTypes.create(attacker.level(),
                            MythicUpgradesDamageTypes.DEFLECTING_DAMAGE_TYPE, (LivingEntity)(Object)this), deflecting_damage);
                }
            }
        }
        has_damage_been_deflected = false;
    }


    @WrapWithCondition(method = "updateFallFlying", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V"))
    private <T extends LivingEntity> boolean applyChanceWithToolMasteryForTickFallFlying(ItemStack instance, int amount, T user, Consumer<T> breakCallback) {
        return checkForItemMastery(user);
    }
}