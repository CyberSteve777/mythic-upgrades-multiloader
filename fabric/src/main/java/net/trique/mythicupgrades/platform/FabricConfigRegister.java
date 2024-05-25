package net.trique.mythicupgrades.platform;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.trique.mythicupgrades.platform.services.IConfigRegister;
import static net.trique.mythicupgrades.Constants.MOD_ID;

public class FabricConfigRegister implements IConfigRegister {
    @Override
    public void register(ForgeConfigSpec spec) {
        ForgeConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.SERVER, spec);
    }
}
