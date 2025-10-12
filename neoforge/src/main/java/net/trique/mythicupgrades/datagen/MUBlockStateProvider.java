package net.trique.mythicupgrades.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistryObject;


import static net.trique.mythicupgrades.registry.BlockRegistry.*;

public class MUBlockStateProvider extends BlockStateProvider {
    public MUBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(AQUAMARINE_BLOCK.get(), cubeAll(AQUAMARINE_BLOCK.get()));
        simpleBlockWithItem(AQUAMARINE_ORE.get(), cubeAll(AQUAMARINE_ORE.get()));
        simpleBlockWithItem(DEEPSLATE_AQUAMARINE_ORE.get(), cubeAll(DEEPSLATE_AQUAMARINE_ORE.get()));
        simpleBlockWithItem(AQUAMARINE_CRYSTAL_BLOCK.get(), cubeAll(AQUAMARINE_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(AQUAMARINE_CRYSTAL_CLUSTER);
        simpleBlockWithItem(AQUAMARINE_CRYSTAL_BRICKS.get(), cubeAll(AQUAMARINE_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_AQUAMARINE_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_AQUAMARINE_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(AQUAMARINE_PILLAR);
        cutPillarBlockWithItem(CUT_AQUAMARINE_PILLAR, AQUAMARINE_PILLAR);

        simpleBlockWithItem(TOPAZ_BLOCK.get(), cubeAll(TOPAZ_BLOCK.get()));
        simpleBlockWithItem(TOPAZ_ORE.get(), cubeAll(TOPAZ_ORE.get()));
        simpleBlockWithItem(DEEPSLATE_TOPAZ_ORE.get(), cubeAll(DEEPSLATE_TOPAZ_ORE.get()));
        simpleBlockWithItem(TOPAZ_CRYSTAL_BLOCK.get(), cubeAll(TOPAZ_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(TOPAZ_CRYSTAL_CLUSTER);
        simpleBlockWithItem(TOPAZ_CRYSTAL_BRICKS.get(), cubeAll(TOPAZ_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_TOPAZ_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_TOPAZ_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(TOPAZ_PILLAR);
        cutPillarBlockWithItem(CUT_TOPAZ_PILLAR, TOPAZ_PILLAR);

        simpleBlockWithItem(PERIDOT_BLOCK.get(), cubeAll(PERIDOT_BLOCK.get()));
        simpleBlockWithItem(PERIDOT_ORE.get(), cubeAll(PERIDOT_ORE.get()));
        simpleBlockWithItem(DEEPSLATE_PERIDOT_ORE.get(), cubeAll(DEEPSLATE_PERIDOT_ORE.get()));
        simpleBlockWithItem(PERIDOT_CRYSTAL_BLOCK.get(), cubeAll(PERIDOT_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(PERIDOT_CRYSTAL_CLUSTER);
        simpleBlockWithItem(PERIDOT_CRYSTAL_BRICKS.get(), cubeAll(PERIDOT_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_PERIDOT_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_PERIDOT_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(PERIDOT_PILLAR);
        cutPillarBlockWithItem(CUT_PERIDOT_PILLAR, PERIDOT_PILLAR);

        simpleBlockWithItem(RUBY_BLOCK.get(), cubeAll(RUBY_BLOCK.get()));
        simpleBlockWithItem(RUBY_ORE.get(), cubeAll(RUBY_ORE.get()));
        simpleBlockWithItem(RUBY_CRYSTAL_BLOCK.get(), cubeAll(RUBY_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(RUBY_CRYSTAL_CLUSTER);
        simpleBlockWithItem(RUBY_CRYSTAL_BRICKS.get(), cubeAll(RUBY_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_RUBY_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_RUBY_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(RUBY_PILLAR);
        cutPillarBlockWithItem(CUT_RUBY_PILLAR, RUBY_PILLAR);

        simpleBlockWithItem(SAPPHIRE_BLOCK.get(), cubeAll(SAPPHIRE_BLOCK.get()));
        simpleBlockWithItem(SAPPHIRE_ORE.get(), cubeAll(SAPPHIRE_ORE.get()));
        simpleBlockWithItem(SAPPHIRE_CRYSTAL_BLOCK.get(), cubeAll(SAPPHIRE_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(SAPPHIRE_CRYSTAL_CLUSTER);
        simpleBlockWithItem(SAPPHIRE_CRYSTAL_BRICKS.get(), cubeAll(SAPPHIRE_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_SAPPHIRE_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_SAPPHIRE_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(SAPPHIRE_PILLAR);
        cutPillarBlockWithItem(CUT_SAPPHIRE_PILLAR, SAPPHIRE_PILLAR);

        simpleBlockWithItem(AMETRINE_BLOCK.get(), cubeAll(AMETRINE_BLOCK.get()));
        simpleBlockWithItem(AMETRINE_ORE.get(), cubeAll(AMETRINE_ORE.get()));
        simpleBlockWithItem(AMETRINE_CRYSTAL_BLOCK.get(), cubeAll(AMETRINE_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(AMETRINE_CRYSTAL_CLUSTER);
        simpleBlockWithItem(AMETRINE_CRYSTAL_BRICKS.get(), cubeAll(AMETRINE_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_AMETRINE_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_AMETRINE_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(AMETRINE_PILLAR);
        cutPillarBlockWithItem(CUT_AMETRINE_PILLAR, AMETRINE_PILLAR);

        simpleBlockWithItem(JADE_BLOCK.get(), cubeAll(JADE_BLOCK.get()));
        simpleBlockWithItem(JADE_ORE.get(), cubeAll(JADE_ORE.get()));
        simpleBlockWithItem(JADE_CRYSTAL_BLOCK.get(), cubeAll(JADE_CRYSTAL_BLOCK.get()));
        simpleClusterBlockWithItem(JADE_CRYSTAL_CLUSTER);
        simpleBlockWithItem(JADE_CRYSTAL_BRICKS.get(), cubeAll(JADE_CRYSTAL_BRICKS.get()));
        simpleBlockWithItem(POLISHED_JADE_CRYSTAL_BLOCK.get(), cubeAll(POLISHED_JADE_CRYSTAL_BLOCK.get()));
        pillarBlockWithItem(JADE_PILLAR);
        cutPillarBlockWithItem(CUT_JADE_PILLAR, JADE_PILLAR);

        simpleBlockWithItem(RAW_NECOIUM_BLOCK.get(), cubeAll(RAW_NECOIUM_BLOCK.get()));
        simpleBlockWithItem(NECOIUM_ORE.get(), cubeAll(NECOIUM_ORE.get()));
        simpleBlockWithItem(NECOIUM_BLOCK.get(), cubeAll(NECOIUM_BLOCK.get()));


    }

    protected void pillarBlockWithItem(RegistryObject<Block, RotatedPillarBlock> blockRegistryObject) {
        logBlock(blockRegistryObject.get());
        String path = blockRegistryObject.getId().getPath();
        itemModels().getBuilder(path).parent(new ModelFile.UncheckedModelFile(blockTexture(blockRegistryObject.get())));
    }

    protected void cutPillarBlockWithItem(RegistryObject<Block, RotatedPillarBlock> cutPillarBlock,
                                          RegistryObject<Block, RotatedPillarBlock> relatedBlock) {
        ResourceLocation blockPath = cutPillarBlock.getId();
        axisBlock(cutPillarBlock.get(), blockTexture(cutPillarBlock.get()),
                blockTexture(relatedBlock.get()).withSuffix("_top"));
        itemModels().getBuilder(blockPath.getPath()).parent(new ModelFile.UncheckedModelFile(blockTexture(cutPillarBlock.get())));
    }


    protected <T extends Block> void simpleClusterBlockWithItem(RegistryObject<Block, T> blockRegistryObject) {
        Block block = blockRegistryObject.get();
        ResourceLocation blockId = blockRegistryObject.getId();
        String pathname = blockId.getPath();

        ModelFile model = models().withExistingParent(pathname, mcLoc("block/cross")).renderType("cutout")
                .texture("cross", blockTexture(block));
        // Generate blockstate with variants for each facing direction
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(model)
                            .rotationX(facing == Direction.DOWN ? 180 : facing.getAxis().isHorizontal() ? 90 : 0)
                            .rotationY(facing.getAxis().isVertical() ? 0 : ((int) facing.toYRot() + 180) % 360)
                            .build();
                }, BlockStateProperties.WATERLOGGED);

        itemModels().getBuilder(pathname)
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", blockTexture(block))
                .transforms()
                .transform(ItemDisplayContext.HEAD)
                .translation(0, 14, -5)
                .scale(1, 1, 1)
                .end();
    }

}
