package net.trique.mythicupgrades.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @ModifyVariable(method = "renderLevel", at = @At(value = "CONSTANT", args = "stringValue=blockentities", ordinal = 0), ordinal = 3)
    private boolean modify(boolean value) {
        return value || SpelunkerEffectRenderer.isActive();
    }
}
