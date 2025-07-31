package net.trique.mythicupgrades.item.materials;

import com.google.common.base.Suppliers;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.util.MUBlockTags;

import java.util.function.Supplier;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public enum MUToolMaterials implements Tier {
    AQUAMARINE(MUBlockTags.INCORRECT_FOR_AQUAMARINE_TOOL, 2923, 10.0f, 5.0f, 18, () -> Ingredient.of(AQUAMARINE_INGOT.get())),
    PERIDOT(MUBlockTags.INCORRECT_FOR_PERIDOT_TOOL, 2923, 10.0f, 5.0f, 18, () -> Ingredient.of(PERIDOT_INGOT.get())),
    RUBY(MUBlockTags.INCORRECT_FOR_RUBY_TOOL, 2923, 13.0f, 5.0f, 18, () -> Ingredient.of(RUBY_INGOT.get())),
    SAPPHIRE(MUBlockTags.INCORRECT_FOR_SAPPHIRE_TOOL, 2923, 10.0f, 5.0f, 18, () -> Ingredient.of(SAPPHIRE_INGOT.get())),
    TOPAZ(MUBlockTags.INCORRECT_FOR_TOPAZ_TOOL, 8769, 11.0f, 6.0f, 18, () -> Ingredient.of(TOPAZ_INGOT.get())),
    AMETRINE(MUBlockTags.INCORRECT_FOR_AMETRINE_TOOL, 2923, 10.0f, 5.0f, 18, () -> Ingredient.of(AMETRINE_INGOT.get())),
    JADE(MUBlockTags.INCORRECT_FOR_JADE_TOOL, 2923, 10.0f, 5.0f, 18, () -> Ingredient.of(JADE_INGOT.get()));


    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    MUToolMaterials(final TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public static void init() {
        Constants.LOGGER.info("Registering tool materials for Mythic Upgrades");
    }

    @Override
    public int getUses() {
        return itemDurability;
    }

    @Override
    public float getSpeed() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return inverseTag;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}