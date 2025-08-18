package net.trique.mythicupgrades.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.registry.MUDamageTypes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


import static net.trique.mythicupgrades.registry.EffectRegistry.*;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
        deflecting_damage = 0f;
        has_damage_been_deflected = false;
    }

    @Shadow @Nullable public abstract MobEffectInstance getEffect(Holder<MobEffect> holder);

    @Unique private boolean has_damage_been_deflected;

    @Unique private float deflecting_damage;


    @WrapMethod(method = "hurt")
    private boolean reduceIncomingDamage(DamageSource source, float amount, Operation<Boolean> original) {

        if (!this.level().isClientSide()) {
            MobEffectInstance deflection = this.getEffect(DAMAGE_DEFLECTION);
            if (deflection != null) {
                Entity attacker = source.getEntity();
                float defl_dmg_coef = deflection.getAmplifier() / 10f;
                if (attacker != null) {
                    deflecting_damage = (0.1f + defl_dmg_coef) * amount;
                    amount *= (0.9f - defl_dmg_coef);
                }
            }
        }
        return original.call(source, amount);
    }

    @Inject(method = "hurt", at = @At(value = "TAIL"))
    private void deflectDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!this.level().isClientSide() && cir.getReturnValue()) {
            MobEffectInstance deflection = this.getEffect(DAMAGE_DEFLECTION);
            if (deflection != null) {
                Entity attacker = source.getEntity();
                if (attacker instanceof LivingEntity enemy &&
                        !(enemy instanceof Player player && (player.isCreative() || player.isSpectator()))) {
                    if (enemy.distanceToSqr(this) <= 9.0f && !has_damage_been_deflected) {
                        DamageSource deflecting_source = MUDamageTypes.deflecting_damage(this);
                        has_damage_been_deflected = true;
                        enemy.hurt(deflecting_source, deflecting_damage);
                    }
                }

            }
        }
        has_damage_been_deflected = false;
    }
}