package host.plas.exampleproject;

import host.plas.bou.PluginBase;
import host.plas.exampleproject.config.DatabaseConfig;
import host.plas.exampleproject.config.MainConfig;
import lombok.Getter;
import lombok.Setter;

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
}
