package net.trique.mythicupgrades.mixin;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.item.equipment.common.MythicEffectsSwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MythicEffectsSwordItem.class)
public abstract class BanEnchantmentMixin extends SwordItem {

    public BanEnchantmentMixin(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, Holder<Enchantment> enchantment, EnchantingContext context) {
        if (getTier().equals(MUToolMaterials.TOPAZ) && enchantment.is(Enchantments.FIRE_ASPECT)) {
            return false;
        }
        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
