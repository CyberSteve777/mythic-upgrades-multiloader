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
    protected final Supplier<EffectList> forSelfWhenHit;
    protected final Supplier<EffectList> forTargetWhenHit;
    protected final String tooltipKey;
    protected final ChatFormatting color;

    public MythicEffectsSwordItem(Tier material, Properties settings,
                                  String tooltipKey, ChatFormatting color,
                                  Supplier<EffectList> whenInHand,
                                  Supplier<EffectList> forSelfWhenHit,
                                  Supplier<EffectList> forTargetWhenHit) {
        super(material, settings);
        this.whenInHand = whenInHand;
        this.forSelfWhenHit = forSelfWhenHit;
        this.forTargetWhenHit = forTargetWhenHit;
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
    public EffectList getEffectsForSelfWhenHit(DamageSource source, float amount) {
        return forSelfWhenHit.get();
    }

    @Override
    public EffectList getEffectsForTargetWhenHit(DamageSource source, float amount) {
        return forTargetWhenHit.get();
    }
}