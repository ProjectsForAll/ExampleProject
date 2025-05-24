package host.plas.exampleproject.events;

import host.plas.bou.events.ListenerConglomerate;
import host.plas.exampleproject.ExampleProject;
import host.plas.exampleproject.data.PlayerData;
import host.plas.exampleproject.data.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import tv.quaint.events.BaseEventHandler;

public class MainListener implements ListenerConglomerate {
    public MainListener() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());
        BaseEventHandler.bake(this, ExampleProject.getInstance());
        ExampleProject.getInstance().logInfo("Registered MainListener!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        PlayerData data = PlayerManager.getOrCreatePlayer(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        PlayerData data = PlayerManager.getOrCreatePlayer(player);
        data.saveAndUnload();
    }
}
