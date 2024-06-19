package dev.quozul.sleep.mixin;

import dev.quozul.sleep.Freezer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerEventsMixin {
    @Shadow
    @Final
    public MinecraftServer server;

    @Inject(at = @At("HEAD"), method = "onSpawn")
    private void spawn(CallbackInfo info) {
        Freezer.unfreeze(server);
    }

    @Inject(at = @At("HEAD"), method = "onDisconnect")
    private void disconnect(CallbackInfo info) {
        Freezer.freeze(server.getCurrentPlayerCount() - 1, server.getTickManager());
    }
}
