package host.plas.exampleproject.events;

import host.plas.bou.MessageUtils;
import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class MainListener implements Listener {
    public MainListener() {
        Bukkit.getPluginManager().registerEvents(this, ExampleProject.getInstance());

        MessageUtils.logInfo("Registered MainListener!");
    }
}
