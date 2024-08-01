package host.plas.exampleproject.config;

import host.plas.exampleproject.ExampleProject;
import tv.quaint.storage.resources.flat.simple.SimpleConfiguration;

public class MainConfig extends SimpleConfiguration {
    public MainConfig() {
        super("config.yml", ExampleProject.getInstance(), false);
    }

    @Override
    public void init() {

    }
}
