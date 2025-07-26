package host.plas.exampleproject;

import host.plas.bou.BetterPlugin;
import host.plas.exampleproject.config.DatabaseConfig;
import host.plas.exampleproject.config.MainConfig;
import host.plas.exampleproject.data.PlayerManager;
import host.plas.exampleproject.database.ExampleOperator;
import host.plas.exampleproject.events.MainListener;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class ExampleProject extends BetterPlugin {
    @Getter @Setter
    private static ExampleProject instance;
    @Getter @Setter
    private static MainConfig mainConfig;
    @Getter @Setter
    private static DatabaseConfig databaseConfig;

    @Getter @Setter
    private static ExampleOperator database;

    @Getter @Setter
    private static MainListener mainListener;

    public ExampleProject() {
        super();
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this); // Set the instance of the plugin. // For use in other classes.

        setMainConfig(new MainConfig()); // Instantiate the main config and set it.
        setDatabaseConfig(new DatabaseConfig()); // Instantiate the database config and set it.

        setDatabase(new ExampleOperator()); // Instantiate the database operator and set it. // Uses the database config.

        setMainListener(new MainListener()); // Instantiate the main listener and set it.
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
        PlayerManager.getLoadedPlayers().forEach(playerData -> {
            // Save and unload all loaded player data.
            // Saves it in sync (hence the false) so it doesn't lose data.
            playerData.saveAndUnload(false);
        });
    }
}
