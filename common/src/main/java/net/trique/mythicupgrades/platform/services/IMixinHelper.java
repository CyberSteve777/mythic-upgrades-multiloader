package net.trique.mythicupgrades.platform.services;

import net.minecraft.world.entity.LivingEntity;

public interface IMixinHelper {
    void sendPacketToNearbyPlayers(LivingEntity livingEntity);
}
