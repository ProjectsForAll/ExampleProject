package host.plas.exampleproject;

import io.streamlined.bukkit.PluginBase;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentSkipListMap;

@Getter @Setter
public final class ExampleProject extends PluginBase {
    @Getter @Setter
    private static ExampleProject instance;

    public ExampleProject() {
        super();
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this);
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
    }

    /**
     * Get a map of online players.
     * Sorted by player name.
     * @return A map of online players sorted by player name.
     */
    public ConcurrentSkipListMap<String, Player> getOnlinePlayers() {
        ConcurrentSkipListMap<String, Player> onlinePlayers = new ConcurrentSkipListMap<>();

        for (Player player : getServer().getOnlinePlayers()) {
            onlinePlayers.put(player.getName(), player);
        }

        return onlinePlayers;
    }
}
