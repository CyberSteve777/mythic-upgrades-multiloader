package net.trique.mythicupgrades.platform;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.trique.mythicupgrades.networking.packet.PercentAnimationPacket;
import net.trique.mythicupgrades.platform.services.IMixinHelper;

public class NeoForgeMixinHelper implements IMixinHelper {
    @Override
    public void sendPacketToNearbyPlayers(LivingEntity livingEntity) {
        if (!livingEntity.level().isClientSide()) {
            ((ServerLevel) livingEntity.level()).getChunkSource().broadcastAndSend(livingEntity,
                    new PercentAnimationPacket(livingEntity.getId()));
        }
    }
}
