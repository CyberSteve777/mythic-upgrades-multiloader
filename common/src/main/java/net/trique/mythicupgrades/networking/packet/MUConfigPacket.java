package net.trique.mythicupgrades.networking.packet;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.config.MUConfig;


public record MUConfigPacket(double tools_freeze_duration, double ice_shield_slowness_duration,
                             int ice_shield_amplifier, int tools_effects_amplifier,
                             double tools_poison_duration, double tools_nausea_duration,
                             int poisonous_thorns_amplifier, double poisonous_thorns_poison_duration,
                             double poisonous_thorns_nausea_duration, double topaz_tools_fire_seconds,
                             int item_mastery_amplifier, int tools_haste_amplifier,
                             int spelunker_amplifier, double tools_percentage_damage_percent,
                             int damage_deflection_amplifier, double tools_levitation_duration,
                             int tools_levitation_amplifier, double arcane_aura_levitation_duration,
                             int arcane_aura_amplifier, double tools_bouncer_jump_boost_duration,
                             int tools_bouncer_amplifier, int speed_amplifier, int jump_boost_amplifier) implements CustomPacketPayload {


    public MUConfigPacket(MUConfig config) {
        this(config.tools_freeze_duration.get(), config.ice_shield_slowness_duration.get(),
                config.ice_shield_amplifier.get(), config.tools_effects_amplifier.get(),
                config.tools_poison_duration.get(), config.tools_nausea_duration.get(),
                config.poisonous_thorns_amplifier.get(), config.poisonous_thorns_poison_duration.get(),
                config.poisonous_thorns_nausea_duration.get(), config.topaz_tools_fire_seconds.get(),
                config.item_mastery_amplifier.get(), config.tools_haste_amplifier.get(),
                config.spelunker_amplifier.get(), config.tools_percentage_damage_percent.get(),
                config.damage_deflection_amplifier.get(), config.tools_levitation_duration.get(),
                config.tools_levitation_amplifier.get(), config.arcane_aura_levitation_duration.get(),
                config.arcane_aura_amplifier.get(), config.tools_bouncer_jump_boost_duration.get(),
                config.tools_bouncer_amplifier.get(), config.speed_amplifier.get(),
                config.jump_boost_amplifier.get());
    }

    public static final Type<MUConfigPacket> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath(
                    Constants.MOD_ID,
                    "mythicupgrades-config"
            )
    );

    public static final StreamCodec<FriendlyByteBuf, MUConfigPacket> CODEC = StreamCodec.ofMember(
            MUConfigPacket::write, MUConfigPacket::new
    );

    public MUConfigPacket(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readDouble(), buf.readInt(), buf.readInt(), buf.readDouble(),
                buf.readDouble(), buf.readInt(), buf.readDouble(), buf.readDouble(), buf.readDouble(),
                buf.readInt(), buf.readInt(), buf.readInt(), buf.readDouble(), buf.readInt(), buf.readDouble(),
                buf.readInt(), buf.readDouble(), buf.readInt(), buf.readDouble(), buf.readInt(), buf.readInt(),
                buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(tools_freeze_duration);
        buf.writeDouble(ice_shield_slowness_duration);
        buf.writeInt(ice_shield_amplifier);

        buf.writeInt(tools_effects_amplifier);
        buf.writeDouble(tools_poison_duration);
        buf.writeDouble(tools_nausea_duration);
        buf.writeInt(poisonous_thorns_amplifier);
        buf.writeDouble(poisonous_thorns_poison_duration);
        buf.writeDouble(poisonous_thorns_nausea_duration);

        buf.writeDouble(topaz_tools_fire_seconds);
        buf.writeInt(item_mastery_amplifier);

        buf.writeInt(tools_haste_amplifier);
        buf.writeInt(spelunker_amplifier);

        buf.writeDouble(tools_percentage_damage_percent);
        buf.writeInt(damage_deflection_amplifier);

        buf.writeDouble(tools_levitation_duration);
        buf.writeInt(tools_levitation_amplifier);
        buf.writeDouble(arcane_aura_levitation_duration);
        buf.writeInt(arcane_aura_amplifier);

        buf.writeDouble(tools_bouncer_jump_boost_duration);
        buf.writeInt(tools_bouncer_amplifier);
        buf.writeInt(speed_amplifier);
        buf.writeInt(jump_boost_amplifier);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
