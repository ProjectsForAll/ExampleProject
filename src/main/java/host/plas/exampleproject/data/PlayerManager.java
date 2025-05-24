package host.plas.exampleproject.data;

import host.plas.exampleproject.ExampleProject;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListSet;

public class PlayerManager {
    @Getter @Setter
    private static ConcurrentSkipListSet<PlayerData> loadedPlayers = new ConcurrentSkipListSet<>();

    public static void loadPlayer(PlayerData player) {
        unloadPlayer(player);

        loadedPlayers.add(player);
    }

    public static void unloadPlayer(String uuid) {
        getLoadedPlayers().removeIf(p -> p.getIdentifier().equalsIgnoreCase(uuid));
    }

    public static void unloadPlayer(PlayerData player) {
        unloadPlayer(player.getIdentifier());
    }

    public static Optional<PlayerData> getPlayer(String uuid) {
        return getLoadedPlayers().stream().filter(p -> p.getIdentifier().equalsIgnoreCase(uuid)).findFirst();
    }

    public static boolean hasPlayer(String uuid) {
        return getPlayer(uuid).isPresent();
    }

    public static void savePlayer(PlayerData player) {
        ExampleProject.getDatabase().putPlayer(player);
    }

    public static void savePlayer(PlayerData player, boolean async) {
        ExampleProject.getDatabase().putPlayer(player, async);
    }

    public static PlayerData createPlayer(Player player) {
        PlayerData data = new PlayerData(player);
        savePlayer(data);

        return data;
    }

    public static PlayerData getOrCreatePlayer(Player player) {
        String uuid = player.getUniqueId().toString();

        Optional<PlayerData> data = getPlayer(uuid);
        if (data.isPresent()) return data.get();

        PlayerData d = createPlayer(player);
        d.load();

        d.augment(ExampleProject.getDatabase().pullPlayerThreaded(uuid));

        return d;
    }
}
