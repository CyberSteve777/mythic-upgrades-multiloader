package net.trique.mythicupgrades.item.equipment.sapphire;

import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.config.gem_data.SapphireData;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.item.equipment.common.MythicEffectsShovelItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class SapphireShovelItem extends MythicEffectsShovelItem {


    public SapphireShovelItem(Properties settings, String tooltipKey, ChatFormatting color, Supplier<EffectList> whenInHand, Supplier<EffectList> forSelfWhenHit, Supplier<EffectList> forTargetWhenHit) {
        super(MUToolMaterials.SAPPHIRE, settings, tooltipKey, color, whenInHand, forSelfWhenHit, forTargetWhenHit);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        SapphireData data = MUConfigHelper.getSapphireValues();
        list.add(Component.translatable(tooltipKey, List.of(data.tools_percentage_damage_percent()).toArray()).withStyle(color));
    }
}