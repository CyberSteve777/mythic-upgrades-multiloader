package net.trique.mythicupgrades.events;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.util.ClientFunctions;
import net.trique.mythicupgrades.util.SpelunkerEffectRenderer;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ClientGameEventsHandler {

        @SubscribeEvent
    public static void renderList(final RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) return;
        PoseStack stack = event.getPoseStack();
        SpelunkerEffectRenderer.renderOres(stack);
    }

    @SubscribeEvent
    public static void clientFillRenderPositions(final ClientTickEvent.Pre event) {
        LocalPlayer player = ClientFunctions.getLocalPlayer();
        SpelunkerEffectRenderer.clientFillRenderPositions(player);
    }
}
