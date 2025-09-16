package net.trique.mythicupgrades.item.equipment.ruby;

import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.ChatFormatting;
import net.trique.mythicupgrades.item.equipment.common.MythicEffectsPickaxeItem;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;

import java.util.function.Supplier;

public class RubyPickaxeItem extends MythicEffectsPickaxeItem {

    public RubyPickaxeItem(Properties settings, String tooltipKey, ChatFormatting color, Supplier<EffectList> whenInHand, Supplier<EffectList> forSelfOnAttack, Supplier<EffectList> forTargetOnAttack) {
        super(MUToolMaterials.RUBY, settings, tooltipKey, color, whenInHand, forSelfOnAttack, forTargetOnAttack);
    }
}
