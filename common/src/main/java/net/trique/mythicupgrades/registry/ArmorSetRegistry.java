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
            EffectArmorSetRegistry.REGISTRY.getRegistryKey(), Constants.MOD_ID);

    public static final RegistryObject<EffectArmorSet, AmetrineArmorSet> AMETRINE_SET = ARMOR_SET_REGISTRY.register(
            "ametrine_set", () -> new AmetrineArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.AMETRINE)
                    .addArmorItems(AMETRINE_HELMET::get, AMETRINE_CHESTPLATE::get,
                            AMETRINE_LEGGINGS::get, AMETRINE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, AquamarineArmorSet> AQUAMARINE_SET = ARMOR_SET_REGISTRY.register(
            "aquamarine_set", () -> new AquamarineArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.AQUAMARINE)
                    .addArmorItems(AQUAMARINE_HELMET::get, AQUAMARINE_CHESTPLATE::get,
                            AQUAMARINE_LEGGINGS::get, AQUAMARINE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, JadeArmorSet> JADE_SET = ARMOR_SET_REGISTRY.register(
            "jade_set", () -> new JadeArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.JADE)
                    .addArmorItems(JADE_HELMET::get, JADE_CHESTPLATE::get,
                            JADE_LEGGINGS::get, JADE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, PeridotArmorSet> PERIDOT_SET = ARMOR_SET_REGISTRY.register(
            "peridot_set", () -> new PeridotArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.PERIDOT)
                    .addArmorItems(PERIDOT_HELMET::get, PERIDOT_CHESTPLATE::get,
                            PERIDOT_LEGGINGS::get, PERIDOT_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, RubyArmorSet> RUBY_SET = ARMOR_SET_REGISTRY.register(
            "ruby_set", () -> new RubyArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.RUBY)
                    .addArmorItems(RUBY_HELMET::get, RUBY_CHESTPLATE::get,
                            RUBY_LEGGINGS::get, RUBY_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, SapphireArmorSet> SAPPHIRE_SET = ARMOR_SET_REGISTRY.register(
            "sapphire_set", () -> new SapphireArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.SAPPHIRE)
                    .addArmorItems(SAPPHIRE_HELMET::get, SAPPHIRE_CHESTPLATE::get,
                            SAPPHIRE_LEGGINGS::get, SAPPHIRE_BOOTS::get)
                    .build()
            )
    );

    public static final RegistryObject<EffectArmorSet, TopazArmorSet> TOPAZ_SET = ARMOR_SET_REGISTRY.register(
            "topaz_set", () -> new TopazArmorSet(new ArmorSet.Builder()
                    .addArmorMaterials(MUArmorMaterials.TOPAZ)
                    .addArmorItems(TOPAZ_HELMET::get, TOPAZ_CHESTPLATE::get,
                            TOPAZ_LEGGINGS::get, TOPAZ_BOOTS::get)
                    .build()
            )
    );

    public static void init() {
        Constants.LOGGER.info("Registering armor sets...");
    }

}
