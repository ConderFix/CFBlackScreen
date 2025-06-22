package ru.quizie.cfblackscreen.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.quizie.cfblackscreen.CFBlackScreen;
import ru.quizie.cfblackscreen.blackscreen.BlackScreenManager;

public class BlackScreenCommand implements CommandExecutor {

    private final BlackScreenManager blackScreenManager = BlackScreenManager.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("cfblackscreen.use")) return true;

        if (args.length < 1) {
            sender.sendMessage("Specify a player!");
            return true;
        }

        final Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Player not found!");
            return true;
        }

        if (blackScreenManager.isTrolled(target)) {
            blackScreenManager.setDefaultScreen(target);
            sender.sendMessage(ChatColor.RED + "off");
        } else {
            blackScreenManager.setBlackScreen(target);
            sender.sendMessage(ChatColor.GREEN + "on");
        }

        return true;
    }
}
