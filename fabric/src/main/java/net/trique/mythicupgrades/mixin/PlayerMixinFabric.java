package net.trique.mythicupgrades.mixin;

import net.minecraft.world.entity.player.Player;
import net.trique.mythicupgrades.util.CommonFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixinFabric {
    @Inject(method = "tick",at = @At("HEAD"))
    private void tickPre(CallbackInfo ci) {
        CommonFunctions.playerTickPre((Player)(Object)this);
    }
}
