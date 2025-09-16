package net.trique.mythicupgrades.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.trique.mythicupgrades.networking.packet.C2SStartExcavatePacket;
import net.trique.mythicupgrades.registry.ItemRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class MixinClientPlayerInteractionManager {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "destroyBlock", at = @At(value = "HEAD"))
    private void DIGGUS$BREAKBLOCK(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (minecraft.player.getMainHandItem().is(ItemRegistry.RUBY_PICKAXE.get()))
            DIGGUS$activate(pos, Direction.NORTH, -1);
    }

    @Unique
    private void DIGGUS$activate(BlockPos pos, Direction facing, int shapeSelection) {
       C2SStartExcavatePacket.sendExcavatePacket(pos, BuiltInRegistries.BLOCK.getKey(this.minecraft.level.getBlockState(pos).getBlock()), facing, shapeSelection);
    }
}