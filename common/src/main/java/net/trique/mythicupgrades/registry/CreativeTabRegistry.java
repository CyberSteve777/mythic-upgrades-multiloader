package net.trique.mythicupgrades.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;


import static net.trique.mythicupgrades.registry.BlockRegistry.*;
import static net.trique.mythicupgrades.registry.ItemRegistry.*;


public class CreativeTabRegistry {
    public static void init() {}

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);


    public static final RegistryObject<CreativeModeTab, CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register(Constants.MOD_ID + "_blocks_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(JADE_BLOCK.get()))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        output.accept(RUBY_BLOCK.get());
                        output.accept(RUBY_ORE.get());
                        output.accept(RUBY_CRYSTAL_BLOCK.get());
                        output.accept(RUBY_CRYSTAL_CLUSTER.get());

                        output.accept(TOPAZ_BLOCK.get());
                        output.accept(TOPAZ_ORE.get());
                        output.accept(DEEPSLATE_TOPAZ_ORE.get());
                        output.accept(TOPAZ_CRYSTAL_BLOCK.get());
                        output.accept(TOPAZ_CRYSTAL_CLUSTER.get());

                        output.accept(PERIDOT_BLOCK.get());
                        output.accept(PERIDOT_ORE.get());
                        output.accept(DEEPSLATE_PERIDOT_ORE.get());
                        output.accept(PERIDOT_CRYSTAL_BLOCK.get());
                        output.accept(PERIDOT_CRYSTAL_CLUSTER.get());

                        output.accept(JADE_BLOCK.get());
                        output.accept(JADE_ORE.get());
                        output.accept(JADE_CRYSTAL_BLOCK.get());
                        output.accept(JADE_CRYSTAL_CLUSTER.get());

                        output.accept(AQUAMARINE_BLOCK.get());
                        output.accept(AQUAMARINE_ORE.get());
                        output.accept(DEEPSLATE_AQUAMARINE_ORE.get());
                        output.accept(AQUAMARINE_CRYSTAL_BLOCK.get());
                        output.accept(AQUAMARINE_CRYSTAL_CLUSTER.get());

                        output.accept(SAPPHIRE_BLOCK.get());
                        output.accept(SAPPHIRE_ORE.get());
                        output.accept(SAPPHIRE_CRYSTAL_BLOCK.get());
                        output.accept(SAPPHIRE_CRYSTAL_CLUSTER.get());

                        output.accept(AMETRINE_BLOCK.get());
                        output.accept(AMETRINE_ORE.get());
                        output.accept(AMETRINE_CRYSTAL_BLOCK.get());
                        output.accept(AMETRINE_CRYSTAL_CLUSTER.get());

                        output.accept(RAW_NECOIUM_BLOCK.get());
                        output.accept(NECOIUM_BLOCK.get());
                        output.accept(NECOIUM_ORE.get());
                    }).title(Component.translatable("itemGroup." + Constants.MOD_ID + ".blocks"))
            .build());


    public static final RegistryObject<CreativeModeTab, CreativeModeTab> EQUIPMENT_TAB = CREATIVE_MODE_TABS.register(Constants.MOD_ID + "_equipment_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
            .icon(() -> new ItemStack(JADE_AXE.get()))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        output.accept(RUBY_SHOVEL.get());
                        output.accept(RUBY_PICKAXE.get());
                        output.accept(RUBY_AXE.get());
                        output.accept(RUBY_HOE.get());
                        output.accept(RUBY_SWORD.get());
                        output.accept(RUBY_HELMET.get());
                        output.accept(RUBY_CHESTPLATE.get());
                        output.accept(RUBY_LEGGINGS.get());
                        output.accept(RUBY_BOOTS.get());

                        output.accept(TOPAZ_SHOVEL.get());
                        output.accept(TOPAZ_PICKAXE.get());
                        output.accept(TOPAZ_AXE.get());
                        output.accept(TOPAZ_HOE.get());
                        output.accept(TOPAZ_SWORD.get());
                        output.accept(TOPAZ_HELMET.get());
                        output.accept(TOPAZ_CHESTPLATE.get());
                        output.accept(TOPAZ_LEGGINGS.get());
                        output.accept(TOPAZ_BOOTS.get());

                        output.accept(PERIDOT_SHOVEL.get());
                        output.accept(PERIDOT_PICKAXE.get());
                        output.accept(PERIDOT_AXE.get());
                        output.accept(PERIDOT_HOE.get());
                        output.accept(PERIDOT_SWORD.get());
                        output.accept(PERIDOT_HELMET.get());
                        output.accept(PERIDOT_CHESTPLATE.get());
                        output.accept(PERIDOT_LEGGINGS.get());
                        output.accept(PERIDOT_BOOTS.get());

                        output.accept(JADE_SHOVEL.get());
                        output.accept(JADE_PICKAXE.get());
                        output.accept(JADE_AXE.get());
                        output.accept(JADE_HOE.get());
                        output.accept(JADE_SWORD.get());
                        output.accept(JADE_HELMET.get());
                        output.accept(JADE_CHESTPLATE.get());
                        output.accept(JADE_LEGGINGS.get());
                        output.accept(JADE_BOOTS.get());

                        output.accept(AQUAMARINE_SHOVEL.get());
                        output.accept(AQUAMARINE_PICKAXE.get());
                        output.accept(AQUAMARINE_AXE.get());
                        output.accept(AQUAMARINE_HOE.get());
                        output.accept(AQUAMARINE_SWORD.get());
                        output.accept(AQUAMARINE_HELMET.get());
                        output.accept(AQUAMARINE_CHESTPLATE.get());
                        output.accept(AQUAMARINE_LEGGINGS.get());
                        output.accept(AQUAMARINE_BOOTS.get());

                        output.accept(SAPPHIRE_SHOVEL.get());
                        output.accept(SAPPHIRE_PICKAXE.get());
                        output.accept(SAPPHIRE_AXE.get());
                        output.accept(SAPPHIRE_HOE.get());
                        output.accept(SAPPHIRE_SWORD.get());
                        output.accept(SAPPHIRE_HELMET.get());
                        output.accept(SAPPHIRE_CHESTPLATE.get());
                        output.accept(SAPPHIRE_LEGGINGS.get());
                        output.accept(SAPPHIRE_BOOTS.get());

                        output.accept(AMETRINE_SHOVEL.get());
                        output.accept(AMETRINE_PICKAXE.get());
                        output.accept(AMETRINE_AXE.get());
                        output.accept(AMETRINE_HOE.get());
                        output.accept(AMETRINE_SWORD.get());
                        output.accept(AMETRINE_HELMET.get());
                        output.accept(AMETRINE_CHESTPLATE.get());
                        output.accept(AMETRINE_LEGGINGS.get());
                        output.accept(AMETRINE_BOOTS.get());
                    }).title(Component.translatable("itemGroup." + Constants.MOD_ID + ".equipment"))
            .build());

    public static final RegistryObject<CreativeModeTab, CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register(Constants.MOD_ID + "_misc_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
            .icon(() -> new ItemStack(JADE.get()))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        output.accept(RUBY.get());
                        output.accept(RUBY_INGOT.get());
                        output.accept(RUBY_CRYSTAL_SHARD.get());
                        output.accept(RUBY_POTION.get());
                        output.accept(RUBY_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(TOPAZ.get());
                        output.accept(TOPAZ_INGOT.get());
                        output.accept(TOPAZ_CRYSTAL_SHARD.get());
                        output.accept(TOPAZ_POTION.get());
                        output.accept(TOPAZ_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(PERIDOT.get());
                        output.accept(PERIDOT_INGOT.get());
                        output.accept(PERIDOT_CRYSTAL_SHARD.get());
                        output.accept(PERIDOT_POTION.get());
                        output.accept(PERIDOT_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(JADE.get());
                        output.accept(JADE_INGOT.get());
                        output.accept(JADE_CRYSTAL_SHARD.get());
                        output.accept(JADE_POTION.get());
                        output.accept(JADE_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(AQUAMARINE.get());
                        output.accept(AQUAMARINE_INGOT.get());
                        output.accept(AQUAMARINE_CRYSTAL_SHARD.get());
                        output.accept(AQUAMARINE_POTION.get());
                        output.accept(AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(SAPPHIRE.get());
                        output.accept(SAPPHIRE_INGOT.get());
                        output.accept(SAPPHIRE_CRYSTAL_SHARD.get());
                        output.accept(SAPPHIRE_POTION.get());
                        output.accept(SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(AMETRINE.get());
                        output.accept(AMETRINE_INGOT.get());
                        output.accept(AMETRINE_CRYSTAL_SHARD.get());
                        output.accept(AMETRINE_POTION.get());
                        output.accept(AMETRINE_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(RAW_NECOIUM.get());
                        output.accept(NECOIUM_INGOT.get());
                    }).title(Component.translatable("itemGroup." + Constants.MOD_ID + ".misc"))
            .build());
}
