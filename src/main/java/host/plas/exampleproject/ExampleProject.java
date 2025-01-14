package host.plas.exampleproject;

import host.plas.bou.BetterPlugin;
import host.plas.exampleproject.config.DatabaseConfig;
import host.plas.exampleproject.config.MainConfig;
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
        setInstance(this);

        setMainConfig(new MainConfig());
        setDatabaseConfig(new DatabaseConfig());

        setDatabase(new ExampleOperator());

        setMainListener(new MainListener());
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
    }
}
