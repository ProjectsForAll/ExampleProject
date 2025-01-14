package host.plas.exampleproject.events;

import host.plas.bou.events.ListenerConglomerate;
import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
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
    }
}
