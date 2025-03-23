package ru.quizie.cfblackscreen;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quizie.cfblackscreen.blackscreen.BlackScreenManager;
import ru.quizie.cfblackscreen.commands.BlackScreenCommand;
import ru.quizie.cfblackscreen.services.BlackScreenService;

public final class CFBlackScreen extends JavaPlugin implements Listener {

    public static BlackScreenManager blackScreenManager;

    @Override
    public void onEnable() {
        blackScreenManager = new BlackScreenManager(this);

        super.saveDefaultConfig();
        Config.load(this.getConfig());

        final BlackScreenService blackScreenService = new BlackScreenService();
        blackScreenService.runTaskTimer(this, Config.ticks, Config.ticks);

        super.getServer().getPluginManager().registerEvents(blackScreenService, this);
        super.getCommand("blackscreen").setExecutor(new BlackScreenCommand());
    }


}
