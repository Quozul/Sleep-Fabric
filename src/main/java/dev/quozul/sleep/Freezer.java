package dev.quozul.sleep;

import net.minecraft.server.MinecraftServer;

public class Freezer {
    public static void freeze(MinecraftServer server) {
        if (server.getPlayerManager().getCurrentPlayerCount() == 0) {
            server.getTickManager().setFrozen(true);
            SleepFabric.LOGGER.info("Server is now frozen");
        }
    }

    public static void unfreeze(MinecraftServer server) {
        if (server.getPlayerManager().getCurrentPlayerCount() > 0) {
            server.getTickManager().setFrozen(false);
            SleepFabric.LOGGER.info("Server is now unfrozen");
        }
    }
}
