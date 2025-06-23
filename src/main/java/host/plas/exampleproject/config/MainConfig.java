package host.plas.exampleproject.config;

import gg.drak.thebase.storage.resources.flat.simple.SimpleConfiguration;
import host.plas.exampleproject.ExampleProject;

public class MainConfig extends SimpleConfiguration {
    public MainConfig() {
        super("config.yml", ExampleProject.getInstance(), false);
    }

    @Override
    public void init() {

    }
}
