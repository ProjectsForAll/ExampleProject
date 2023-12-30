package host.plas.exampleproject;

import io.streamlined.bukkit.PluginBase;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class ExampleProject extends PluginBase {
    @Getter @Setter
    private static ExampleProject instance;

    public ExampleProject() {
        super();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
