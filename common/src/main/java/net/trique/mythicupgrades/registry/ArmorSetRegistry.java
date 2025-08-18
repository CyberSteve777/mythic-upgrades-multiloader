package net.trique.mythicupgrades.registry;

import me.cybersteve.equiplib.item.armor.base.ArmorSet;
import me.cybersteve.equiplib.item.armor.base.EffectArmorSet;
import me.cybersteve.equiplib.registry.EffectArmorSetRegistry;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.effect_armor_set.*;
import net.trique.mythicupgrades.item.materials.MUArmorMaterials;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;

import static net.trique.mythicupgrades.registry.ItemRegistry.*;

public class ArmorSetRegistry {
    private static final RegistrationProvider<EffectArmorSet> ARMOR_SET_REGISTRY = RegistrationProvider.get(
            EffectArmorSetRegistry.REGISTRY, Constants.MOD_ID);

    public static final RegistryObject<EffectArmorSet, AmetrineArmorSet> AMETRINE_SET = ARMOR_SET_REGISTRY.register(
            "ametrine_set", () -> new AmetrineArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.AMETRINE)
                    .addHelmets(AMETRINE_HELMET::get)
                    .addChestPlates(AMETRINE_CHESTPLATE::get)
                    .addLeggings(AMETRINE_LEGGINGS::get)
                    .addBoots(AMETRINE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, AquamarineArmorSet> AQUAMARINE_SET = ARMOR_SET_REGISTRY.register(
            "aquamarine_set", () -> new AquamarineArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.AQUAMARINE)
                    .addHelmets(AMETRINE_HELMET::get)
                    .addChestPlates(AMETRINE_CHESTPLATE::get)
                    .addLeggings(AMETRINE_LEGGINGS::get)
                    .addBoots(AMETRINE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, JadeArmorSet> JADE_SET = ARMOR_SET_REGISTRY.register(
            "jade_set", () -> new JadeArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.JADE)
                    .addHelmets(JADE_HELMET::get)
                    .addChestPlates(JADE_CHESTPLATE::get)
                    .addLeggings(JADE_LEGGINGS::get)
                    .addBoots(JADE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, PeridotArmorSet> PERIDOT_SET = ARMOR_SET_REGISTRY.register(
            "peridot_set", () -> new PeridotArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.PERIDOT)
                    .addHelmets(PERIDOT_HELMET::get)
                    .addChestPlates(PERIDOT_CHESTPLATE::get)
                    .addLeggings(PERIDOT_LEGGINGS::get)
                    .addBoots(PERIDOT_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, RubyArmorSet> RUBY_SET = ARMOR_SET_REGISTRY.register(
            "ruby_set", () -> new RubyArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.RUBY)
                    .addHelmets(RUBY_HELMET::get)
                    .addChestPlates(RUBY_CHESTPLATE::get)
                    .addLeggings(RUBY_LEGGINGS::get)
                    .addBoots(RUBY_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, SapphireArmorSet> SAPPHIRE_SET = ARMOR_SET_REGISTRY.register(
            "sapphire_set", () -> new SapphireArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.SAPPHIRE)
                    .addHelmets(SAPPHIRE_HELMET::get)
                    .addChestPlates(SAPPHIRE_CHESTPLATE::get)
                    .addLeggings(SAPPHIRE_LEGGINGS::get)
                    .addBoots(SAPPHIRE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, TopazArmorSet> TOPAZ_SET = ARMOR_SET_REGISTRY.register(
            "topaz_set", () -> new TopazArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.TOPAZ)
                    .addHelmets(TOPAZ_HELMET::get)
                    .addChestPlates(TOPAZ_CHESTPLATE::get)
                    .addLeggings(TOPAZ_LEGGINGS::get)
                    .addBoots(TOPAZ_BOOTS::get)
                    .build()
            )
    );

    public static void init() {
        Constants.LOGGER.info("Registering armor sets...");
    }

}
