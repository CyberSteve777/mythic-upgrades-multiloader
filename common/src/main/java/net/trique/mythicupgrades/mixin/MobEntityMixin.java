package net.trique.mythicupgrades.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.JadeData;
import net.trique.mythicupgrades.config.gem_data.SapphireData;
import net.trique.mythicupgrades.config.gem_data.TopazData;
import net.trique.mythicupgrades.registry.MUDamageTypes;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.platform.Services;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.trique.mythicupgrades.registry.EffectRegistry.*;

@Mixin(Mob.class)
public abstract class MobEntityMixin extends LivingEntity {

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "doHurtTarget", at = @At(value = "RETURN"))
    private void applySapphirePercentageDamage(Entity target, CallbackInfoReturnable<Boolean> cir) {
        boolean wasAttacked = cir.getReturnValue();
        if (wasAttacked) {
            if (target instanceof LivingEntity entity) {
                Item weapon = this.getItemBySlot(EquipmentSlot.MAINHAND).getItem();
                if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.SAPPHIRE)) {
                    SapphireData data = MUConfigHelper.getSapphireValues();
                    double percent = data.tools_percentage_damage_percent();
                    DamageSource source = MUDamageTypes.percentage_damage(this);
                    float dmg = (float) percent / 100f;
                    if (entity.invulnerableTime <= 10) {
                        entity.hurt(source, dmg * entity.getMaxHealth());
                        Services.MIXIN_HELPER.sendPacketToNearbyPlayers(entity);
                        entity.invulnerableTime = 0;
                    }
                }
            }
        }
    }

    @WrapOperation(method = "doHurtTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private boolean applyBouncerEffect(Entity target, DamageSource source, float amount, Operation<Boolean> original) {
        if (this.hasEffect(BOUNCER)) {
            int ampl = this.getEffect(BOUNCER).getAmplifier();
            JadeData data = MUConfigHelper.getJadeValues();
            this.addEffect(new MobEffectInstance(MobEffects.JUMP, (int)
                    (data.tools_bouncer_jump_boost_duration() * 20), ampl));
        }
        return original.call(target, source, amount);
    }

    @Inject(method = "doHurtTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void setEntityOnFire(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof TieredItem item && item.getTier().equals(MUToolMaterials.TOPAZ)) {
            TopazData data = MUConfigHelper.getTopazValues();
            double time = data.topaz_tools_fire_seconds();
            entity.igniteForSeconds((float) time);
        }
    }
}