package net.trique.mythicupgrades;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.trique.mythicupgrades.config.MUConfigHelper;
import net.trique.mythicupgrades.item.materials.MUToolMaterials;
import net.trique.mythicupgrades.util.MUArmorSets;
import net.trique.mythicupgrades.item.materials.MUArmorMaterials;
import net.trique.mythicupgrades.platform.Services;
import net.trique.mythicupgrades.registry.*;
import net.trique.mythicupgrades.util.MUDamageTypes;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class MUCommon {

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {
        Constants.LOGGER.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
//        DataComponentRegistry.init();
        MUConfigHelper.initCaches();
        EffectRegistry.init();
        MUArmorSets.init();
        ItemRegistry.init();
        BlockRegistry.init();
        MUArmorMaterials.init();
        CreativeTabRegistry.init();
        ParticleRegistry.init();
        MUDamageTypes.init();
        // It is common for all supported loaders to provide a similar feature that can not be used directly in the
        // common code. A popular way to get around this is using Java's built-in service loader feature to create
        // your own abstraction layer. You can learn more about this in our provided services class. In this example
        // we have an interface in the common code and use a loader specific implementation to delegate our call to
        // the platform specific approach.
        if (Services.PLATFORM.isModLoaded(Constants.MOD_ID)) {
            Constants.LOGGER.info("Mythic Upgrades was loaded successfully!");
        }
    }

    public static float getIncomingDamage(float original, LivingEntity target, DamageSource source) {
        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            ItemStack weapon = livingAttacker.getMainHandItem();
            if (weapon.getItem() instanceof TieredItem tieredItem && tieredItem.getTier() == MUToolMaterials.AQUAMARINE && target.isInWaterRainOrBubble()) {
                original += 2;
            }
        }
        return original;
    }
}