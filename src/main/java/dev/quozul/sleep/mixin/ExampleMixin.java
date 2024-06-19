package dev.quozul.sleep.mixin;

import dev.quozul.sleep.Freezer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.ServerTickManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class ExampleMixin {
    @Shadow
    public abstract ServerTickManager getTickManager();

    @Shadow
    public abstract PlayerManager getPlayerManager();

    @Inject(at = @At("HEAD"), method = "loadWorld")
    private void init(CallbackInfo info) {
        Freezer.freeze(getPlayerManager().getCurrentPlayerCount(), getTickManager());
    }
}
