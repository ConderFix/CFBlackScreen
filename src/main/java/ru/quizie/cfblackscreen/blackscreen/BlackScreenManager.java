package ru.quizie.cfblackscreen.blackscreen;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerChangeGameState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import ru.quizie.cfblackscreen.CFBlackScreen;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BlackScreenManager {

    @Getter
    private static BlackScreenManager instance;

    public BlackScreenManager() {
        instance = this;
    }

    private final Set<UUID> trolledPlayers = new HashSet<>();

    public void setBlackScreen(Player player) {
        this.trolledPlayers.add(player.getUniqueId());
        this.sendBlackScreenPacket(player);
    }

    public void setDefaultScreen(Player player) {
        if (!isTrolled(player)) return;

        trolledPlayers.remove(player.getUniqueId());
        player.closeInventory();
    }

    public boolean isTrolled(Player player) {
        return trolledPlayers.contains(player.getUniqueId());
    }

    private void sendBlackScreenPacket(Player player) {
        final WrapperPlayServerChangeGameState blackScreen =
                new WrapperPlayServerChangeGameState(WrapperPlayServerChangeGameState.Reason.WIN_GAME, 1);

        PacketEvents.getAPI().getPlayerManager().sendPacket(player, blackScreen);
    }
}
