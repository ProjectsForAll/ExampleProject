package host.plas.exampleproject.events;

import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BukkitListener implements Listener {
    public BukkitListener() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());
        ExampleProject.getInstance().logInfo("Registered MainListener!");
    }
}
