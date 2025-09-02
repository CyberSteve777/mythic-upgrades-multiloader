package net.trique.mythicupgrades.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {

    protected static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    public static final RegistryObject<Block, Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore", () ->
            new DropExperienceBlock( UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block, Block> AQUAMARINE_CRYSTAL_BLOCK = registerBlock("aquamarine_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> AQUAMARINE_CRYSTAL_CLUSTER = registerBlock("aquamarine_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block, Block> PERIDOT_BLOCK = registerBlock("peridot_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> PERIDOT_ORE = registerBlock("peridot_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> DEEPSLATE_PERIDOT_ORE = registerBlock("deepslate_peridot_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block, Block> PERIDOT_CRYSTAL_BLOCK = registerBlock("peridot_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> PERIDOT_CRYSTAL_CLUSTER = registerBlock("peridot_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> RUBY_BLOCK = registerBlock("ruby_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_RED).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> RUBY_ORE = registerBlock("ruby_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> RUBY_CRYSTAL_BLOCK = registerBlock("ruby_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.NETHER).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> RUBY_CRYSTAL_CLUSTER = registerBlock("ruby_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LAPIS).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> SAPPHIRE_CRYSTAL_BLOCK = registerBlock("sapphire_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.LAPIS).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> SAPPHIRE_CRYSTAL_CLUSTER = registerBlock("sapphire_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> TOPAZ_BLOCK = registerBlock("topaz_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> TOPAZ_ORE = registerBlock("topaz_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.CRIMSON_NYLIUM).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5f, 1200.0f).sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block, Block> TOPAZ_CRYSTAL_BLOCK = registerBlock("topaz_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.TERRACOTTA_ORANGE).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> TOPAZ_CRYSTAL_CLUSTER = registerBlock("topaz_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> AMETRINE_BLOCK = registerBlock("ametrine_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> AMETRINE_ORE = registerBlock("ametrine_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.SAND).strength(6.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> AMETRINE_CRYSTAL_BLOCK = registerBlock("ametrine_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> AMETRINE_CRYSTAL_CLUSTER = registerBlock("ametrine_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> JADE_BLOCK = registerBlock("jade_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PLANT).strength(5.0f, 1200.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block, Block> JADE_ORE = registerBlock("jade_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.PLANT).strength(6.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> JADE_CRYSTAL_BLOCK = registerBlock("jade_crystal_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.PLANT).sound(SoundType.AMETHYST).strength(3.0f, 1200.0f)));

    public static final RegistryObject<Block, Block> JADE_CRYSTAL_CLUSTER = registerBlock("jade_crystal_cluster", () ->
            new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel(state -> 5).pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block, Block> RAW_NECOIUM_BLOCK = registerBlock("raw_necoium_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).instrument(NoteBlockInstrument.FLUTE)));

    public static final RegistryObject<Block, Block> NECOIUM_BLOCK = registerBlock("necoium_block", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.COLOR_PURPLE).strength(5.0f, 1200.0f).sound(SoundType.METAL).instrument(NoteBlockInstrument.FLUTE)));

    public static final RegistryObject<Block, Block> NECOIUM_ORE = registerBlock("necoium_ore", () ->
            new DropExperienceBlock(UniformInt.of(32, 64), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).mapColor(MapColor.SAND).strength(6.0f, 1200.0f).instrument(NoteBlockInstrument.FLUTE)));



    public static void init() {
        Constants.LOGGER.info("Registering blocks for Mythic Upgrades...");
    }


    public static <T extends Block> RegistryObject<Block, T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, b -> () -> new BlockItem(b.get(), ItemRegistry.getItemProperties()));
    }

    protected static <T extends Block> RegistryObject<Block, T> registerBlock(String name, Supplier<T> block, Function<RegistryObject<Block, T>, Supplier<? extends BlockItem>> item) {
        var reg = BLOCKS.register(name, block);
        ItemRegistry.ITEMS.register(name, () -> item.apply(reg).get());
        return reg;
    }

    public static Iterable<Block> getModBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map((blockRegistryObject -> (Block) blockRegistryObject.get()))::iterator;
    }
}
