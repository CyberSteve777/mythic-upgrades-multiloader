package net.trique.mythicupgrades.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface ModPacket<T extends FriendlyByteBuf> extends CustomPacketPayload {
}
