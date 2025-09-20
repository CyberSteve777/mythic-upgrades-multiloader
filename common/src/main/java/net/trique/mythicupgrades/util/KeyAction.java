package net.trique.mythicupgrades.util;

import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;

public enum KeyAction implements StringRepresentable {
    CHANGE_RUBY_SET_BONUS;

    @Override
    public String getSerializedName() {
        return name();
    }

    public static final Codec<KeyAction> CODEC = StringRepresentable.fromEnum(KeyAction::values);
    public static final StreamCodec<RegistryFriendlyByteBuf,KeyAction> STREAM_CODEC = CommonFunctions.enumStreamCodec(KeyAction.class);
}
