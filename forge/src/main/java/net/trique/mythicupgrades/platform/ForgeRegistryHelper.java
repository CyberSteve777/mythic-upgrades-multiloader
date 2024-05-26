package net.trique.mythicupgrades.platform;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.platform.services.IRegistryHelper;

import static net.trique.mythicupgrades.block.MUBlocks.*;
import static net.trique.mythicupgrades.item.MUItems.*;
import static net.trique.mythicupgrades.registry.RegisterMUItems.ALL_ITEMS;
import static net.trique.mythicupgrades.registry.RegisterMUItems.MICS;
import static net.trique.mythicupgrades.registry.RegisterMUItems.TOOLS;
import static net.trique.mythicupgrades.registry.RegisterMUEffects.ALL_EFFECTS;

public class ForgeRegistryHelper implements IRegistryHelper {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Constants.MOD_ID);

    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            Constants.MOD_ID);

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Constants.MOD_ID);

    private static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Constants.MOD_ID);

    @Override
    public void registerBlocks() {
        ALL_BLOCKS.forEach((key, value)->BLOCKS.register(key, ()->value));
    }

    @Override
    public void registerItems() {
        ALL_ITEMS.forEach((key, value)->ITEMS.register(key, ()->value));
        BLOCK_ITEMS.forEach((key, value)->ITEMS.register(key, ()->value));

        RegistryObject<CreativeModeTab> MYTHICTOOLSGROUP = REGISTRY.register("mythictoolsgroup", () -> CreativeModeTab.builder()
                .title(Component.translatable("item_group." + Constants.MOD_ID + ".mythictoolsgroup"))
                .icon(() -> new ItemStack(JADE_AXE))
                .displayItems((params, output) -> {
                    TOOLS.forEach(output::accept);
                })
                .build()
        );
        RegistryObject<CreativeModeTab> MYTHICMISCGROUP = REGISTRY.register("mythicmicsgroup", () -> CreativeModeTab.builder()
                .title(Component.translatable("item_group." + Constants.MOD_ID + ".mythicmicsgroup"))
                .icon(() -> new ItemStack(JADE))
                .displayItems((params, output) -> {
                    MICS.forEach(output::accept);
                })
                .build()
        );
        RegistryObject<CreativeModeTab> MYTHICBLOCKGROUP = REGISTRY.register("mythicblocksgroup", () -> CreativeModeTab.builder()
                .title(Component.translatable("item_group." + Constants.MOD_ID + ".mythicblocksgroup"))
                .icon(() -> new ItemStack(JADE_BLOCK))
                .displayItems((params, output) -> {
                    BLOCKS_ORDER.forEach(output::accept);
                })
                .build()
        );
    }

    @Override
    public void registerEffects() {
        ALL_EFFECTS.forEach((key, value)->EFFECTS.register(key, ()->value));
    }
}
