package net.trique.mythicupgrades.registry;

import net.minecraft.util.FastColor;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.trique.mythicupgrades.item.materials.MUArmorMaterials;

import java.util.Map;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class TrimMaterialRegistry {
    private static final RegistrationProvider<TrimMaterial> TRIM_MATERIAL_REGISTRATION_PROVIDER =
            RegistrationProvider.get(Registries.TRIM_MATERIAL, Constants.MOD_ID);

    private static float itemModelIndex = 1.0F;

    public static final RegistryObject<TrimMaterial, TrimMaterial> AQUAMARINE = 
            register("aquamarine", AQUAMARINE_CRYSTAL_SHARD, FastColor.ARGB32.color(5, 123, 158), Map.of(MUArmorMaterials.AQUAMARINE, "aquamarine_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> TOPAZ =
            register("topaz", TOPAZ_CRYSTAL_SHARD, FastColor.ARGB32.color(209, 72, 13), Map.of(MUArmorMaterials.TOPAZ, "topaz_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> PERIDOT =
            register("peridot", PERIDOT_CRYSTAL_SHARD, FastColor.ARGB32.color(97, 173, 15), Map.of(MUArmorMaterials.PERIDOT, "peridot_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> RUBY =
            register("ruby", RUBY_CRYSTAL_SHARD, FastColor.ARGB32.color(169, 12, 55), Map.of(MUArmorMaterials.RUBY, "ruby_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> SAPPHIRE =
            register("sapphire", SAPPHIRE_CRYSTAL_SHARD, FastColor.ARGB32.color(12, 70, 178), Map.of(MUArmorMaterials.SAPPHIRE, "sapphire_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> AMETRINE =
            register("ametrine", AMETRINE_CRYSTAL_SHARD, FastColor.ARGB32.color(132, 34, 174), Map.of(MUArmorMaterials.AMETRINE, "ametrine_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> JADE =
            register("jade", JADE_CRYSTAL_SHARD, FastColor.ARGB32.color(29, 139, 48), Map.of(MUArmorMaterials.JADE, "jade_darker"));
    public static final RegistryObject<TrimMaterial, TrimMaterial> NECOIUM =
            register("necoium", NECOIUM_INGOT, FastColor.ARGB32.color(159, 28, 115), Map.of());


    private static RegistryObject<TrimMaterial, TrimMaterial> register(String key, RegistryObject<Item, Item> ingredient,
                                                                       int color,
                                                                       Map<Holder<ArmorMaterial>, String> overrideArmorMaterials) {
        ResourceKey<TrimMaterial> resourceKey = registryKey(key);
        Style style = Style.EMPTY.withColor(color);
        return TRIM_MATERIAL_REGISTRATION_PROVIDER.register(key, () -> TrimMaterial.create(
                resourceKey.location().getPath(),
                ingredient.get(),
                ++itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.location())).withStyle(style),
                overrideArmorMaterials
        ));
    }


    private static ResourceKey<TrimMaterial> registryKey(String key) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, key));
    }

    public static void init() {
        Constants.LOGGER.info("Adding armor trim materials...");
    }
}
