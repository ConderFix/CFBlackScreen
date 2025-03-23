package ru.quizie.cfblackscreen.services;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.quizie.cfblackscreen.CFBlackScreen;
import ru.quizie.cfblackscreen.blackscreen.BlackScreenManager;

public class BlackScreenService extends BukkitRunnable implements Listener {

    private BlackScreenManager blackScreenManager = CFBlackScreen.blackScreenManager;

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (blackScreenManager.isTrolled(player)) {
                blackScreenManager.setBlackScreen(player);
            }
        });
    }

    @EventHandler
    private void on(PlayerQuitEvent event) {
        if (blackScreenManager.isTrolled(event.getPlayer())) {
            blackScreenManager.setDefaultScreen(event.getPlayer());
        }
    }
}
