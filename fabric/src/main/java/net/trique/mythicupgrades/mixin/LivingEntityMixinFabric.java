package net.trique.mythicupgrades.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.MUCommon;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
//@Debug(export = true)
public class LivingEntityMixinFabric {
    @ModifyVariable(method = "hurt", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/LivingEntity;noActionTime:I"), argsOnly = true)
    private float modifyDamage(float value, DamageSource source, float amount) {
        return MUCommon.getIncomingDamage(amount,(LivingEntity)(Object)this,source);
    }
}
