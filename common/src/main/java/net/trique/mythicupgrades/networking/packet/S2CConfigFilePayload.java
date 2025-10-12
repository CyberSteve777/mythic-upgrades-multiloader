    /*
     * Copyright (c) NeoForged and contributors
     * SPDX-License-Identifier: LGPL-2.1-only
     */
    package net.trique.mythicupgrades.networking.packet;

    import net.minecraft.network.RegistryFriendlyByteBuf;
    import net.minecraft.network.codec.ByteBufCodecs;
    import net.minecraft.network.codec.StreamCodec;
    import net.trique.mythicupgrades.networking.MiscCodecs;
    import net.trique.mythicupgrades.platform.Services;
    import net.trique.mythicupgrades.util.CommonFunctions;

    /**
     * A payload that contains a config file.
     * <p>
     * This is used to send config files to the client.
     * </p>
     *
     * @param fileName The name of the config file.
     * @param contents The contents of the config file.
     */
    public record S2CConfigFilePayload(String fileName,
                                       byte[] contents) implements S2CModPacket<RegistryFriendlyByteBuf> {
        public static final Type<S2CConfigFilePayload> TYPE = new Type<>(CommonFunctions.getLoc("config_file"));
        public static final StreamCodec<RegistryFriendlyByteBuf, S2CConfigFilePayload> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                S2CConfigFilePayload::fileName,
                MiscCodecs.UNBOUNDED_BYTE_ARRAY,
                S2CConfigFilePayload::contents,
                S2CConfigFilePayload::new);

        @Override
        public Type<S2CConfigFilePayload> type() {
            return TYPE;
        }

        @Override
        public void handleClient() {
            Services.PLATFORM.receiveSyncedConfig(contents, fileName);
        }
    }
