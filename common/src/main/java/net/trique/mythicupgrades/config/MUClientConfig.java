package net.trique.mythicupgrades.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class MUClientConfig {

    public static final ModConfigSpec CONFIG_SPEC;
    public static final MUClientConfig CONFIG;

    public final ModConfigSpec.BooleanValue globalTransition;

    private MUClientConfig(ModConfigSpec.Builder builder) {
        builder.push("spelunker");
        globalTransition = builder.define("global_transition",true);
        builder.pop();
    }



    static {
        ModConfigSpec.Builder configBuilder = new ModConfigSpec.Builder();
        CONFIG = new MUClientConfig(configBuilder);
        CONFIG_SPEC = configBuilder.build();
    }
}
