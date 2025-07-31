package net.trique.mythicupgrades.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

public final class MinecraftServerInstance {
    private static MinecraftServer INSTANCE;

    public static @Nullable MinecraftServer getInstance() {
        return INSTANCE;
    }

    public static MinecraftServer getInstanceOrThrow() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Server not yet available!");
        }
        return INSTANCE;
    }

    // Register events to update the server instance
    public static void initialize() {
        ServerLifecycleEvents.SERVER_STARTING.register(instance -> INSTANCE = instance);
        ServerLifecycleEvents.SERVER_STOPPED.register(instance -> INSTANCE = null);
    }
}