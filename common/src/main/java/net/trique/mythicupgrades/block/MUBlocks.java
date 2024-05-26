package net.trique.mythicupgrades.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.trique.mythicupgrades.Constants;
import java.util.HashMap;
import java.util.ArrayList;


public class MUBlocks {

    public static HashMap<String, Block> ALL_BLOCKS = new HashMap<>();
    public static ArrayList<Block> BLOCKS_ORDER = new ArrayList<>();
    public static HashMap<String, BlockItem> BLOCK_ITEMS = new HashMap<>();


    public static final Block RUBY_BLOCK = setBlock("ruby_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_RED).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block RUBY_ORE = setBlock("ruby_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block RUBY_CRYSTAL_BLOCK = setBlock("ruby_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.NETHER).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block RUBY_CRYSTAL_CLUSTER = setBlock("ruby_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block TOPAZ_BLOCK = setBlock("topaz_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block TOPAZ_ORE = setBlock("topaz_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block TOPAZ_CRYSTAL_BLOCK = setBlock("topaz_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.TERRACOTTA_ORANGE).strength(3.0f, 1200.0f)));

    public static final Block TOPAZ_CRYSTAL_CLUSTER = setBlock("topaz_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block CITRINE_BLOCK = setBlock("citrine_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block CITRINE_ORE = setBlock("citrine_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block DEEPSLATE_CITRINE_ORE = setBlock("deepslate_citrine_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(CITRINE_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE), UniformInt.of(16, 32)));

    public static final Block CITRINE_CRYSTAL_BLOCK = setBlock("citrine_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_YELLOW).strength(3.0f, 1200.0f)));

    public static final Block CITRINE_CRYSTAL_CLUSTER = setBlock("citrine_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block PERIDOT_BLOCK = setBlock("peridot_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block PERIDOT_ORE = setBlock("peridot_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block DEEPSLATE_PERIDOT_ORE = setBlock("deepslate_peridot_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE), UniformInt.of(16, 32)));

    public static final Block PERIDOT_CRYSTAL_BLOCK = setBlock("peridot_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block PERIDOT_CRYSTAL_CLUSTER = setBlock("peridot_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block JADE_BLOCK = setBlock("jade_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PLANT).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block JADE_ORE = setBlock("jade_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.PLANT).strength(6.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block JADE_CRYSTAL_BLOCK = setBlock("jade_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PLANT).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block JADE_CRYSTAL_CLUSTER = setBlock("jade_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block AQUAMARINE_BLOCK = setBlock("aquamarine_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block AQUAMARINE_ORE = setBlock("aquamarine_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block DEEPSLATE_AQUAMARINE_ORE = setBlock("deepslate_aquamarine_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(AQUAMARINE_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE), UniformInt.of(16, 32)));

    public static final Block AQUAMARINE_CRYSTAL_BLOCK = setBlock("aquamarine_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block AQUAMARINE_CRYSTAL_CLUSTER = setBlock("aquamarine_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block ZIRCON_BLOCK = setBlock("zircon_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_BLUE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block ZIRCON_ORE = setBlock("zircon_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block DEEPSLATE_ZIRCON_ORE = setBlock("deepslate_zircon_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(ZIRCON_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE), UniformInt.of(16, 32)));

    public static final Block ZIRCON_CRYSTAL_BLOCK = setBlock("zircon_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_BLUE).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block ZIRCON_CRYSTAL_CLUSTER = setBlock("zircon_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block SAPPHIRE_BLOCK = setBlock("sapphire_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LAPIS).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block SAPPHIRE_ORE = setBlock("sapphire_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block SAPPHIRE_CRYSTAL_BLOCK = setBlock("sapphire_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.LAPIS).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block SAPPHIRE_CRYSTAL_CLUSTER = setBlock("sapphire_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final Block AMETRINE_BLOCK = setBlock("ametrine_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final Block AMETRINE_ORE = setBlock("ametrine_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.SAND).strength(6.0f, 1200.0f), UniformInt.of(16, 32)));

    public static final Block AMETRINE_CRYSTAL_BLOCK = setBlock("ametrine_crystal_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final Block AMETRINE_CRYSTAL_CLUSTER = setBlock("ametrine_crystal_cluster",
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));

    
    public static final Block RAW_NECOIUM_BLOCK = setBlock("raw_necoium_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).instrument(NoteBlockInstrument.FLUTE)));

    public static final Block NECOIUM_BLOCK = setBlock("necoium_block",
            new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).sound(SoundType.METAL).instrument(NoteBlockInstrument.FLUTE)));

    public static final Block NECOIUM_ORE = setBlock("necoium_ore",
            new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.SAND).strength(6.0f, 1200.0f).instrument(NoteBlockInstrument.FLUTE), UniformInt.of(16, 32)));

    private static Block setBlock(String name, Block block) {
        BLOCK_ITEMS.put(name, new BlockItem(block, new Item.Properties()));
        ALL_BLOCKS.put(name, block);
        BLOCKS_ORDER.add(block);
        return block;
    }

    public static void setMythicBlocks() {
        Constants.LOG.info("Registering Mythic Blocks for " + Constants.MOD_ID);
    }
}