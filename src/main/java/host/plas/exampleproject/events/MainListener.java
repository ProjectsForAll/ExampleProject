package host.plas.exampleproject.events;

import host.plas.bou.events.ListenerConglomerate;
import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;
import tv.quaint.events.BaseEventHandler;

public class MainListener implements ListenerConglomerate {
    public MainListener() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());
        BaseEventHandler.bake(this, ExampleProject.getInstance());
        ExampleProject.getInstance().logInfo("Registered MainListener!");
    }
}
