package host.plas.exampleproject;

import host.plas.bou.BetterPlugin;
import host.plas.exampleproject.config.DatabaseConfig;
import host.plas.exampleproject.config.MainConfig;
import host.plas.exampleproject.events.BouListener;
import host.plas.exampleproject.events.BukkitListener;
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
    private static BukkitListener bukkitListener;
    @Getter @Setter
    private static BouListener bouListener;

    public ExampleProject() {
        super();
    }

    @Override
    public void onBaseEnabled() {
        // Plugin startup logic
        setInstance(this);

        setMainConfig(new MainConfig());
        setDatabaseConfig(new DatabaseConfig());

        setBukkitListener(new BukkitListener());
        setBouListener(new BouListener());
    }

    @Override
    public void onBaseDisable() {
        // Plugin shutdown logic
    }
}
