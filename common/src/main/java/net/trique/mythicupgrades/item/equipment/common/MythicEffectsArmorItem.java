package net.trique.mythicupgrades.item.equipment.common;

import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.item.armor.base.IEffectArmorItemExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.trique.mythicupgrades.util.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class MythicEffectsArmorItem extends ArmorItem implements IEffectArmorItemExtension {

    protected final EffectArmorSet effectArmorSet;
    protected final String tooltipSB;
    protected final ChatFormatting color;
    protected Supplier<List<Integer>> effectAmplifiers;

    public MythicEffectsArmorItem(Holder<ArmorMaterial> material, Type type, Properties settings,
                                  String tooltipSB, Supplier<List<Integer>> effectAmplifiers,
                                  ChatFormatting color, EffectArmorSet effectArmorSet) {
        super(material, type, settings);
        this.tooltipSB = tooltipSB;
        this.color = color;
        this.effectArmorSet = effectArmorSet;
        this.effectAmplifiers = effectAmplifiers;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        List<String> romanians = effectAmplifiers.get().stream().map(CommonFunctions::arabicToRom).toList();
        MutableComponent partTooltip = Component.translatable(tooltipSB, romanians.toArray());
        ClientFunctions.handleTooltipForArmor(itemStack, list, partTooltip, color, this.getMaterial().value());
    }

    @Override
    public EffectArmorSet getEffectArmorSet() {
        return effectArmorSet;
    }
}