package dev.quozul.sleep.mixin;

import dev.quozul.sleep.Freezer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftDedicatedServer.class)
public abstract class MinecraftDedicatedServerMixin {
    @Inject(at = @At("TAIL"), method = "setupServer")
    private void init(CallbackInfoReturnable<Boolean> cir) {
        MinecraftServer server = (MinecraftServer) (Object) this;
        Freezer.freeze(server);
    }
}
