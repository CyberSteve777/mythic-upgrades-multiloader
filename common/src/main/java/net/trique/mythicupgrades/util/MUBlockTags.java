package net.trique.mythicupgrades.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.trique.mythicupgrades.Constants;

public class MUBlockTags {

    public static TagKey<Block> INCORRECT_FOR_AMETRINE_TOOL = create("incorrect_for_ametrine_tool");
    public static TagKey<Block> INCORRECT_FOR_AQUAMARINE_TOOL = create("incorrect_for_aquamarine_tool");
    public static TagKey<Block> INCORRECT_FOR_JADE_TOOL = create("incorrect_for_jade_tool");
    public static TagKey<Block> INCORRECT_FOR_PERIDOT_TOOL = create("incorrect_for_peridot_tool");
    public static TagKey<Block> INCORRECT_FOR_RUBY_TOOL = create("incorrect_for_ruby_tool");
    public static TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = create("incorrect_for_sapphire_tool");
    public static TagKey<Block> INCORRECT_FOR_TOPAZ_TOOL = create("incorrect_for_topaz_tool");

    public static TagKey<Block> STORAGE_BLOCKS_AMETRINE = create("storage_blocks/ametrine");
    public static TagKey<Block> STORAGE_BLOCKS_AQUAMARINE = create("storage_blocks/aquamarine");
    public static TagKey<Block> STORAGE_BLOCKS_JADE = create("storage_blocks/jade");
    public static TagKey<Block> STORAGE_BLOCKS_PERIDOT = create("storage_blocks/peridot");
    public static TagKey<Block> STORAGE_BLOCKS_RUBY = create("storage_blocks/ruby");
    public static TagKey<Block> STORAGE_BLOCKS_SAPPHIRE = create("storage_blocks/sapphire");
    public static TagKey<Block> STORAGE_BLOCKS_TOPAZ = create("storage_blocks/topaz");
    public static TagKey<Block> STORAGE_BLOCKS_NECOIUM = create("storage_blocks/necoium");
    public static TagKey<Block> STORAGE_BLOCKS_RAW_NECOIUM = create("storage_blocks/raw_necoium");

    public static final TagKey<Block> QUARTZ_ORES = common("ores/quartz");
    public static final TagKey<Block> ORES = common("ores");

    public static TagKey<Block> CAN_VEINMINE = create("can_veinmine");
    public static TagKey<Block> SPELUNKER_OUTLINED = create("spelunker_outlined");


    private static TagKey<Block> common(String string) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", string));
    }

    private static TagKey<Block> create(String string) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, string));
    }
}
