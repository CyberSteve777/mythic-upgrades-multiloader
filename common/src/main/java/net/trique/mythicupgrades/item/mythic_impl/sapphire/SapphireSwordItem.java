package net.trique.mythicupgrades.item.mythic_impl.sapphire;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.trique.mythicupgrades.item.base.VirtualSapphireTool;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.item.mythic_impl.common.MythicEffectsSwordItem;
import net.trique.mythicupgrades.util.ItemEffectsList;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class SapphireSwordItem extends MythicEffectsSwordItem implements VirtualSapphireTool {
    private double percent;

    public SapphireSwordItem(float percent, Properties settings, ItemEffectsList effects, String tooltipKey, ChatFormatting color) {
        super(MUToolMaterials.SAPPHIRE, settings, effects, tooltipKey, color);
        this.percent = percent;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(Component.translatable(tooltipKey, List.of(percent).toArray()).withStyle(color));
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}