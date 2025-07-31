package net.trique.mythicupgrades.registry;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registration.RegistrationProvider;
import net.trique.mythicupgrades.registration.RegistryObject;
import net.trique.mythicupgrades.util.ItemEffectsList;

public class DataComponentRegistry {
    public static final RegistrationProvider<DataComponentType<?>> DATA_COMPONENTS =
            RegistrationProvider.get(Registries.DATA_COMPONENT_TYPE, Constants.MOD_ID);


    public static final RegistryObject<DataComponentType<?>, DataComponentType<ItemEffectsList>> MU_EFFECTS =
            DATA_COMPONENTS.register("mu_effects", () -> DataComponentType.<ItemEffectsList>builder()
                    .networkSynchronized(ItemEffectsList.STREAM_CODEC).build());


    public static void init() {
        Constants.LOGGER.info("Registering Data Components for Mythic Upgrades...");
    }

}
