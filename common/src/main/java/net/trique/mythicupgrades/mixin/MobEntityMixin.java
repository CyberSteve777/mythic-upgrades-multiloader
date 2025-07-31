package net.trique.mythicupgrades.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.registry.MUDamageTypes;

import net.trique.mythicupgrades.item.base.BaseMythicItem;
import net.trique.mythicupgrades.item.base.BaseMythicToolItem;
import net.trique.mythicupgrades.item.base.VirtualSapphireTool;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.util.CommonFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.trique.mythicupgrades.config.MUConfig.CONFIG;
import static net.trique.mythicupgrades.registry.EffectRegistry.*;

@Mixin(Mob.class)
public abstract class MobEntityMixin extends LivingEntity {
    @Shadow private LivingEntity target;

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }


    @Inject(method = "doHurtTarget", at = @At(value = "RETURN"))
    private void handleEffects(Entity target, CallbackInfoReturnable<Boolean> cir) {
        boolean wasAttacked = cir.getReturnValue();
        if (wasAttacked) {
            if (target instanceof LivingEntity entity && this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BaseMythicItem item) {
                CommonFunctions.addStatusEffects(entity, item.getOnHitEffectsForEnemy(), this);
            }
        }
    }

    @Inject(method = "doHurtTarget", at = @At(value = "RETURN"))
    private void applySapphirePercentageDamage(Entity target, CallbackInfoReturnable<Boolean> cir) {
        boolean wasAttacked = cir.getReturnValue();
        if (wasAttacked) {
            if (target instanceof LivingEntity entity) {
                Item weapon = this.getItemBySlot(EquipmentSlot.MAINHAND).getItem();
                boolean sapphire_weapon = weapon instanceof VirtualSapphireTool;
                if (sapphire_weapon) {
                    double percent = ((VirtualSapphireTool) weapon).getPercent();
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

    @Inject(method = "doHurtTarget", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applyBouncerEffect(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (this.hasEffect(BOUNCER)) {
            int ampl = this.getEffect(BOUNCER).getAmplifier();
            this.addEffect(new MobEffectInstance(MobEffects.JUMP, (int)
                    (CONFIG.tools_bouncer_jump_boost_duration.get() * 20), ampl));
        }
    }

    @Inject(method = "doHurtTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void setEntityOnFire(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        if (weapon instanceof BaseMythicToolItem item && item.getMythicMaterial().equals(MUToolMaterials.TOPAZ)) {
            double time = CONFIG.topaz_tools_fire_seconds.getAsDouble();
            entity.igniteForSeconds((float) time);
        }
    }
}