package net.trique.mythicupgrades.item.equipment.common;

import me.cybersteve.equiplib.item.handheld.base.IEffectHandHeldItem;
import me.cybersteve.equiplib.util.EffectList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class MythicEffectsSwordItem extends SwordItem implements IEffectHandHeldItem {
    protected final Supplier<EffectList> whenInHand;
    protected final Supplier<EffectList> forSelfOnAttack;
    protected final Supplier<EffectList> forTargetOnAttack;
    protected final String tooltipKey;
    protected final ChatFormatting color;

    public MythicEffectsSwordItem(Tier material, Properties settings,
                                  String tooltipKey, ChatFormatting color,
                                  Supplier<EffectList> whenInHand,
                                  Supplier<EffectList> forSelfOnAttack,
                                  Supplier<EffectList> forTargetOnAttack) {
        super(material, settings);
        this.whenInHand = whenInHand;
        this.forSelfOnAttack = forSelfOnAttack;
        this.forTargetOnAttack = forTargetOnAttack;
        this.tooltipKey = tooltipKey;
        this.color = color;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
//        if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LSHIFT))
        list.add(Component.translatable(tooltipKey).withStyle(color));
    }

    @Override
    public EffectList getEffectsWhenInHand(LivingEntity entity) {
        return whenInHand.get();
    }

    @Override
    public EffectList getEffectsForSelfOnAttack(DamageSource source, LivingEntity owner, float amount) {
        return forSelfOnAttack.get();
    }

    @Override
    public EffectList getEffectsForTargetOnAttack(DamageSource source, LivingEntity owner, float amount) {
        return forTargetOnAttack.get();
    }
}