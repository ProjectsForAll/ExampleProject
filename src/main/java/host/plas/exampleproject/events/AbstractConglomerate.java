package host.plas.exampleproject.events;

import gg.drak.thebase.events.BaseEventHandler;
import host.plas.bou.events.ListenerConglomerate;
import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;

public class AbstractConglomerate implements ListenerConglomerate {
    public AbstractConglomerate() {
        register();
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());
        BaseEventHandler.bake(this, ExampleProject.getInstance());
        ExampleProject.getInstance().logInfo("Registered listeners for: &c" + this.getClass().getSimpleName());
    }
}
