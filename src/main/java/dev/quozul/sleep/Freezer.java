package dev.quozul.sleep;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.tick.TickManager;

public class Freezer {
    public static void freeze(int playerCount, TickManager tickManager) {
        if (playerCount == 0) {
            tickManager.setFrozen(true);
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
