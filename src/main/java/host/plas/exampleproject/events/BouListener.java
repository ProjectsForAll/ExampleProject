package host.plas.exampleproject.events;

import host.plas.exampleproject.ExampleProject;
import tv.quaint.events.BaseEventHandler;
import tv.quaint.events.BaseEventListener;

public class BouListener implements BaseEventListener {
    public BouListener() {
        BaseEventHandler.bake(this, ExampleProject.getInstance());
        ExampleProject.getInstance().logInfo("Registered BouListener!");
    }
}
