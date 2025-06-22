package ru.quizie.cfblackscreen;

import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quizie.cfblackscreen.blackscreen.BlackScreenManager;
import ru.quizie.cfblackscreen.commands.BlackScreenCommand;
import ru.quizie.cfblackscreen.services.BlackScreenService;

public final class CFBlackScreen extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.saveDefaultConfig();
        Config.load(this.getConfig());

        new BlackScreenManager();

        final BlackScreenService blackScreenService = new BlackScreenService();
        blackScreenService.runTaskTimer(this, Config.ticks, Config.ticks);

        super.getServer().getPluginManager().registerEvents(blackScreenService, this);
        this.registerBlackScreenCommand();
    }

    private void registerBlackScreenCommand() {
        final PluginCommand command = super.getCommand("blackscreen");
        if (command == null) throw new IllegalStateException("Command is null");
        command.setExecutor(new BlackScreenCommand());
    }
}
