package dev.quozul.sleep.mixin;

import dev.quozul.sleep.Freezer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public abstract class PlayerEventsMixin {
    @Shadow
    @Final
    private MinecraftServer server;

    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    private void spawn(CallbackInfo info) {
        Freezer.unfreeze(server);
    }

    @Inject(at = @At("TAIL"), method = "remove")
    private void disconnect(CallbackInfo info) {
        Freezer.freeze(server);
    }
}
