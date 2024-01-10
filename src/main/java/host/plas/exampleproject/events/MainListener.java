package host.plas.exampleproject.events;

import host.plas.exampleproject.ExampleProject;
import host.plas.exampleproject.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class MainListener implements Listener {
    public MainListener() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());

        MessageUtils.logInfo("Registered MainListener!");
    }
}
