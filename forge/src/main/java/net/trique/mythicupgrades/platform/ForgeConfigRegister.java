package net.trique.mythicupgrades.platform;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.trique.mythicupgrades.platform.services.IConfigRegister;

public class ForgeConfigRegister implements IConfigRegister {
    @Override
    public void register(ForgeConfigSpec spec) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, spec);
    }
}
