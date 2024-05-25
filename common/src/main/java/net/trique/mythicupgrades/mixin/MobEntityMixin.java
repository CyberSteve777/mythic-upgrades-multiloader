package net.trique.mythicupgrades.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.MythicUpgradesDamageTypes;
import net.trique.mythicupgrades.item.BaseMythicItem;
import net.trique.mythicupgrades.item.SapphireAxeItem;
import net.trique.mythicupgrades.item.SapphireSwordItem;
import net.trique.mythicupgrades.util.CommonFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobEntityMixin extends LivingEntity {
    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot slot);

    @Inject(method = "doHurtTarget", at = @At(value = "RETURN"))
    private void handleEffects(Entity target, CallbackInfoReturnable<Boolean> cir) {
        boolean wasAttacked = cir.getReturnValue();
        if (wasAttacked) {
            if (target instanceof LivingEntity entity && this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BaseMythicItem item) {
                CommonFunctions.addStatusEffects(entity, item.getOnHitEffects(), this);
            }
        }
    }

    @Inject(method = "doHurtTarget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applySapphirePercentageDamage(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        boolean sapphire_weapon = (weapon instanceof SapphireAxeItem || weapon instanceof SapphireSwordItem);
        if (sapphire_weapon) {
            int percent;
            if (weapon instanceof SapphireSwordItem swordItem) {
                percent = swordItem.getPercent();
            } else {
                SapphireAxeItem axeItem = (SapphireAxeItem) weapon;
                percent = axeItem.getPercent();
            }
            float damage = (percent / 100f);
            if (entity instanceof LivingEntity target) {
                damage *= target.getMaxHealth();
            }
            DamageSource source = MythicUpgradesDamageTypes.create(entity.level(),
                    MythicUpgradesDamageTypes.PERCENTAGE_DAMAGE_TYPE, this);
            if (entity.invulnerableTime <= 10) {
                entity.hurt(source, damage);
                entity.invulnerableTime = 0;
            }
        }
    }
}