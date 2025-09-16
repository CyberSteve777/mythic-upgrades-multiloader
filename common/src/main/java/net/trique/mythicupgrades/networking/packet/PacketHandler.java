package net.trique.mythicupgrades.networking.packet;

import net.minecraft.server.level.ServerPlayer;
import net.trique.mythicupgrades.platform.Services;

public class PacketHandler {

    public static void registerPackets() {
        Services.PLATFORM.registerClientPlayPacket(S2CPercentAnimationPacket.TYPE, S2CPercentAnimationPacket.CODEC);
        Services.PLATFORM.registerClientPlayPacket(MUConfigPacket.TYPE, MUConfigPacket.CODEC);

        Services.PLATFORM.registerServerPlayPacket(C2SStartExcavatePacket.PACKET_ID, C2SStartExcavatePacket.CODEC);
    }

    public static void sendToServer(C2SModPacket<?> packet) {
        Services.PLATFORM.sendToServer(packet);
    }

    public static void sendTo(S2CModPacket<?> packet, ServerPlayer player) {
            Services.PLATFORM.sendToClient(packet, player);
    }
}
