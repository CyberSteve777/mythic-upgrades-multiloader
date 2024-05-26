package net.trique.mythicupgrades.mixin;


import com.llamalad7.mixinextras.injector.WrapWithCondition;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Consumer;

import static net.trique.mythicupgrades.util.CommonFunctions.checkForItemMastery;

@Mixin(LivingEntity.class)
public class LivingEntityFabricMixin {
    @WrapWithCondition(method = "updateFallFlying", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V"))
    private <T extends LivingEntity> boolean applyChanceWithToolMasteryForTickFallFlying(ItemStack instance, int amount, T user, Consumer<T> breakCallback) {
        return checkForItemMastery(user);
    }
}
