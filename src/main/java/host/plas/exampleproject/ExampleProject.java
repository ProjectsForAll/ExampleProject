package host.plas.exampleproject;

import host.plas.exampleproject.config.DatabaseConfig;
import host.plas.exampleproject.config.MainConfig;
import io.streamlined.bukkit.PluginBase;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentSkipListMap;

@Getter @Setter
public final class ExampleProject extends PluginBase {
    @Getter @Setter
    private static ExampleProject instance;
    @Getter @Setter
    private static MainConfig mainConfig;
    @Getter @Setter
    private static DatabaseConfig databaseConfig;

    public ExampleProject() {
        super();
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this);

        setMainConfig(new MainConfig());
        setDatabaseConfig(new DatabaseConfig());
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
    public static ConcurrentSkipListMap<String, Player> getOnlinePlayers() {
        ConcurrentSkipListMap<String, Player> onlinePlayers = new ConcurrentSkipListMap<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayers.put(player.getName(), player);
        }

        return onlinePlayers;
    }
}
