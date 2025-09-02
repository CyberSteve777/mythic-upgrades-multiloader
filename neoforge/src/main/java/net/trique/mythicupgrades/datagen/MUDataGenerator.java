package net.trique.mythicupgrades.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.trique.mythicupgrades.Constants;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class MUDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = generator.addProvider(event.includeServer(),
                new MUDamageTypeProvider(packOutput, event.getLookupProvider())).getRegistryProvider();
        generator.addProvider(event.includeServer(), new MUDamageTypeTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(MUBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider));
        BlockTagsProvider blockTagsProvider = new MUBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new MUWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new MUItemTagProvider(packOutput, lookupProvider,
                blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new MURecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeClient(), new MUBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new MUItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new MUParticleDescriptionProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new MUGlobalLootModifierProvider(packOutput, lookupProvider));

    }
}
