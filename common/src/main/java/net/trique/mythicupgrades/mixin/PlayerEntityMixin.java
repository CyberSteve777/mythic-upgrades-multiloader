package net.trique.mythicupgrades.mixin;

import com.llamalad7.mixinextras.injector.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.trique.mythicupgrades.MythicUpgradesDamageTypes;
import net.trique.mythicupgrades.item.MythicEffectsSwordItem;
import net.trique.mythicupgrades.item.SapphireAxeItem;
import net.trique.mythicupgrades.item.SapphireSwordItem;
import net.trique.mythicupgrades.util.EffectMeta;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static net.trique.mythicupgrades.util.CommonFunctions.checkForItemMastery;


@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {


    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Shadow
    public abstract @NotNull ItemStack getItemBySlot(EquipmentSlot slot);

    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applyEffectsOnSweeping(Entity entity, CallbackInfo ci, @Local LivingEntity livingEntity) {
        if (this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof MythicEffectsSwordItem swordItem) {
            for (MobEffect effect : swordItem.getOnHitEffects().keySet()) {
                EffectMeta meta = swordItem.getOnHitEffects().get(effect);
                int duration = meta.getDuration();
                int amplifier = meta.getAmplifier();
                boolean ambient = meta.isAmbient();
                boolean showIcon = meta.shouldShowIcon();
                boolean showParticles = meta.shouldShowParticles();
                float sweeping_amplifier = EnchantmentHelper.getSweepingDamageRatio(this);
                livingEntity.addEffect(new MobEffectInstance(effect, duration, Math.max(0, (int) ((double) amplifier - 0.75 + sweeping_amplifier)), ambient, showParticles, showIcon));
            }
        }
    }


    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applySapphirePercentageDamage(Entity entity, CallbackInfo ci, @Local(ordinal = 2) float h) {

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
            float damage = (percent / 100f) * (float) Math.pow(h, 3);
            if (entity instanceof EnderDragonPart part) {
                EnderDragon dragon = part.parentMob;
                damage *= dragon.getMaxHealth();
            } else if (entity instanceof LivingEntity target) {
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


    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    private void applySapphirePercentageDamageOnSweeping(Entity entity, CallbackInfo ci, @Local LivingEntity target) {
        Item weapon = getItemBySlot(EquipmentSlot.MAINHAND).getItem();
        boolean sapphire_weapon = weapon instanceof SapphireSwordItem;
        if (sapphire_weapon) {
            int percent = ((SapphireSwordItem) weapon).getPercent();
            int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING_EDGE, this);
            float damage = (percent / 200f) * (0.7f + level / 10f) * target.getMaxHealth();
            if (target.invulnerableTime <= 10) {
                DamageSource source = MythicUpgradesDamageTypes.create(target.level(), MythicUpgradesDamageTypes.PERCENTAGE_DAMAGE_TYPE, this);
                target.hurt(source, damage);
                target.invulnerableTime = 0;
            }
        }
    }

    @WrapWithCondition(method = "hurtCurrentlyUsedShield", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V"))
    private <T extends LivingEntity> boolean applyChanceWithToolMasteryForDamageShield(ItemStack stack, int amount, T user, Consumer<T> callback) {
        return checkForItemMastery(this);
    }
}