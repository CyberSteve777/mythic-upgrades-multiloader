package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trique.mythicupgrades.Constants;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class MUItemTagProvider extends ItemTagsProvider {
    public MUItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        AQUAMARINE_HELMET.get(), AQUAMARINE_CHESTPLATE.get(), AQUAMARINE_LEGGINGS.get(), AQUAMARINE_BOOTS.get(),
                        PERIDOT_HELMET.get(), PERIDOT_CHESTPLATE.get(), PERIDOT_LEGGINGS.get(), PERIDOT_BOOTS.get(),
                        SAPPHIRE_HELMET.get(), SAPPHIRE_CHESTPLATE.get(), SAPPHIRE_LEGGINGS.get(), SAPPHIRE_BOOTS.get(),
                        TOPAZ_HELMET.get(), TOPAZ_CHESTPLATE.get(), TOPAZ_LEGGINGS.get(), TOPAZ_BOOTS.get(),
                        AMETRINE_HELMET.get(), AMETRINE_CHESTPLATE.get(), AMETRINE_LEGGINGS.get(), AMETRINE_BOOTS.get(),
                        JADE_HELMET.get(), JADE_CHESTPLATE.get(), JADE_LEGGINGS.get(), JADE_BOOTS.get(),
                        RUBY_HELMET.get(), RUBY_CHESTPLATE.get(), RUBY_LEGGINGS.get(), RUBY_BOOTS.get());
        tag(ItemTags.TRIM_MATERIALS)
                .add(AQUAMARINE_CRYSTAL_SHARD.get(), TOPAZ_CRYSTAL_SHARD.get(),
                        PERIDOT_CRYSTAL_SHARD.get(), SAPPHIRE_CRYSTAL_SHARD.get(),
                        RUBY_CRYSTAL_SHARD.get(), JADE_CRYSTAL_SHARD.get(),
                        AMETRINE_CRYSTAL_SHARD.get(), NECOIUM_INGOT.get());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(
                RUBY_PICKAXE.get(), TOPAZ_PICKAXE.get(), SAPPHIRE_PICKAXE.get(), JADE_PICKAXE.get(), AMETRINE_PICKAXE.get(),
                AQUAMARINE_PICKAXE.get(), PERIDOT_PICKAXE.get()
        );
        tag(ItemTags.SWORDS).add(
                AMETRINE_SWORD.get(), AQUAMARINE_SWORD.get(), JADE_SWORD.get(), PERIDOT_SWORD.get(), RUBY_SWORD.get(),
                SAPPHIRE_SWORD.get(), TOPAZ_SWORD.get()
        );
        tag(ItemTags.AXES).add(
                AMETRINE_AXE.get(), AQUAMARINE_AXE.get(), JADE_AXE.get(), PERIDOT_AXE.get(), RUBY_AXE.get(),
                SAPPHIRE_AXE.get(), TOPAZ_AXE.get()
        );
        tag(ItemTags.PICKAXES).add(
                AMETRINE_PICKAXE.get(), AQUAMARINE_PICKAXE.get(), JADE_PICKAXE.get(), PERIDOT_PICKAXE.get(),
                RUBY_PICKAXE.get(), SAPPHIRE_PICKAXE.get(), TOPAZ_PICKAXE.get()
        );
        tag(ItemTags.SHOVELS).add(
                AMETRINE_SHOVEL.get(), AQUAMARINE_SHOVEL.get(), JADE_SHOVEL.get(), PERIDOT_SHOVEL.get(),
                RUBY_SHOVEL.get(), SAPPHIRE_SHOVEL.get(), TOPAZ_SHOVEL.get()
        );
        tag(ItemTags.HOES).add(
                AMETRINE_HOE.get(), AQUAMARINE_HOE.get(), JADE_HOE.get(), PERIDOT_HOE.get(), RUBY_HOE.get(),
                SAPPHIRE_HOE.get(), TOPAZ_HOE.get()
        );
        tag(ItemTags.HEAD_ARMOR).add(
                AMETRINE_HELMET.get(), AQUAMARINE_HELMET.get(), JADE_HELMET.get(), PERIDOT_HELMET.get(),
                RUBY_HELMET.get(), SAPPHIRE_HELMET.get(), TOPAZ_HELMET.get()
        );
        tag(ItemTags.CHEST_ARMOR).add(
                AMETRINE_CHESTPLATE.get(), AQUAMARINE_CHESTPLATE.get(), JADE_CHESTPLATE.get(), PERIDOT_CHESTPLATE.get(),
                RUBY_CHESTPLATE.get(), SAPPHIRE_CHESTPLATE.get(), TOPAZ_CHESTPLATE.get()
        );
        tag(ItemTags.LEG_ARMOR).add(
                AMETRINE_LEGGINGS.get(), AQUAMARINE_LEGGINGS.get(), JADE_LEGGINGS.get(), PERIDOT_LEGGINGS.get(),
                RUBY_LEGGINGS.get(), SAPPHIRE_LEGGINGS.get(), TOPAZ_LEGGINGS.get()
        );
        tag(ItemTags.FOOT_ARMOR).add(
                AMETRINE_BOOTS.get(), AQUAMARINE_BOOTS.get(), JADE_BOOTS.get(), PERIDOT_BOOTS.get(), RUBY_BOOTS.get(),
                SAPPHIRE_BOOTS.get(), TOPAZ_BOOTS.get()
        );
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).remove(
                TOPAZ_SWORD.get()
        );
    }
}
