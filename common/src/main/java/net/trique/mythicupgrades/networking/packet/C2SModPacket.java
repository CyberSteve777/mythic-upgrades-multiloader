package net.trique.mythicupgrades.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

public interface C2SModPacket<T extends FriendlyByteBuf> extends ModPacket<T> {

    void handleServer(ServerPlayer player);

}
