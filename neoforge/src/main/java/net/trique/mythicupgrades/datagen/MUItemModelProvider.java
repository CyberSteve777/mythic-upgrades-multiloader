package net.trique.mythicupgrades.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistryObject;

import java.util.LinkedHashMap;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class MUItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public MUItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(AQUAMARINE_AXE.get());
        handheldItem(AQUAMARINE_PICKAXE.get());
        handheldItem(AQUAMARINE_HOE.get());
        handheldItem(AQUAMARINE_SHOVEL.get());
        handheldItem(AQUAMARINE_SWORD.get());
        basicItem(AQUAMARINE.get());
        basicItem(AQUAMARINE_INGOT.get());
        basicItem(AQUAMARINE_CRYSTAL_SHARD.get());
        basicItem(AQUAMARINE_POTION.get());

        handheldItem(TOPAZ_AXE.get());
        handheldItem(TOPAZ_PICKAXE.get());
        handheldItem(TOPAZ_HOE.get());
        handheldItem(TOPAZ_SHOVEL.get());
        handheldItem(TOPAZ_SWORD.get());
        basicItem(TOPAZ.get());
        basicItem(TOPAZ_INGOT.get());
        basicItem(TOPAZ_CRYSTAL_SHARD.get());
        basicItem(TOPAZ_POTION.get());

        handheldItem(PERIDOT_AXE.get());
        handheldItem(PERIDOT_PICKAXE.get());
        handheldItem(PERIDOT_HOE.get());
        handheldItem(PERIDOT_SHOVEL.get());
        handheldItem(PERIDOT_SWORD.get());
        basicItem(PERIDOT.get());
        basicItem(PERIDOT_INGOT.get());
        basicItem(PERIDOT_CRYSTAL_SHARD.get());
        basicItem(PERIDOT_POTION.get());

        handheldItem(SAPPHIRE_AXE.get());
        handheldItem(SAPPHIRE_PICKAXE.get());
        handheldItem(SAPPHIRE_HOE.get());
        handheldItem(SAPPHIRE_SHOVEL.get());
        handheldItem(SAPPHIRE_SWORD.get());
        basicItem(SAPPHIRE.get());
        basicItem(SAPPHIRE_INGOT.get());
        basicItem(SAPPHIRE_CRYSTAL_SHARD.get());
        basicItem(SAPPHIRE_POTION.get());

        handheldItem(RUBY_AXE.get());
        handheldItem(RUBY_PICKAXE.get());
        handheldItem(RUBY_HOE.get());
        handheldItem(RUBY_SHOVEL.get());
        handheldItem(RUBY_SWORD.get());
        basicItem(RUBY.get());
        basicItem(RUBY_INGOT.get());
        basicItem(RUBY_CRYSTAL_SHARD.get());
        basicItem(RUBY_POTION.get());

        handheldItem(AMETRINE_AXE.get());
        handheldItem(AMETRINE_PICKAXE.get());
        handheldItem(AMETRINE_HOE.get());
        handheldItem(AMETRINE_SHOVEL.get());
        handheldItem(AMETRINE_SWORD.get());
        basicItem(AMETRINE.get());
        basicItem(AMETRINE_INGOT.get());
        basicItem(AMETRINE_CRYSTAL_SHARD.get());
        basicItem(AMETRINE_POTION.get());

        handheldItem(JADE_AXE.get());
        handheldItem(JADE_PICKAXE.get());
        handheldItem(JADE_HOE.get());
        handheldItem(JADE_SHOVEL.get());
        handheldItem(JADE_SWORD.get());
        basicItem(JADE.get());
        basicItem(JADE_INGOT.get());
        basicItem(JADE_CRYSTAL_SHARD.get());
        basicItem(JADE_POTION.get());

        basicItem(RAW_NECOIUM.get());
        basicItem(NECOIUM_INGOT.get());

        basicItem(AQUAMARINE_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(PERIDOT_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TOPAZ_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(SAPPHIRE_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(RUBY_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(JADE_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(AMETRINE_UPGRADE_SMITHING_TEMPLATE.get());

        trimmedArmorItem(AQUAMARINE_HELMET);
        trimmedArmorItem(AQUAMARINE_CHESTPLATE);
        trimmedArmorItem(AQUAMARINE_LEGGINGS);
        trimmedArmorItem(AQUAMARINE_BOOTS);

        trimmedArmorItem(TOPAZ_HELMET);
        trimmedArmorItem(TOPAZ_CHESTPLATE);
        trimmedArmorItem(TOPAZ_LEGGINGS);
        trimmedArmorItem(TOPAZ_BOOTS);

        trimmedArmorItem(PERIDOT_HELMET);
        trimmedArmorItem(PERIDOT_CHESTPLATE);
        trimmedArmorItem(PERIDOT_LEGGINGS);
        trimmedArmorItem(PERIDOT_BOOTS);

        trimmedArmorItem(RUBY_HELMET);
        trimmedArmorItem(RUBY_CHESTPLATE);
        trimmedArmorItem(RUBY_LEGGINGS);
        trimmedArmorItem(RUBY_BOOTS);

        trimmedArmorItem(SAPPHIRE_HELMET);
        trimmedArmorItem(SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(SAPPHIRE_LEGGINGS);
        trimmedArmorItem(SAPPHIRE_BOOTS);

        trimmedArmorItem(AMETRINE_HELMET);
        trimmedArmorItem(AMETRINE_CHESTPLATE);
        trimmedArmorItem(AMETRINE_LEGGINGS);
        trimmedArmorItem(AMETRINE_BOOTS);

        trimmedArmorItem(JADE_HELMET);
        trimmedArmorItem(JADE_CHESTPLATE);
        trimmedArmorItem(JADE_LEGGINGS);
        trimmedArmorItem(JADE_BOOTS);
    }

    private <T extends ArmorItem> void trimmedArmorItem(RegistryObject<Item, T> itemDeferredItem) {

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
}
