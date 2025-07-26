package host.plas.exampleproject.events.own;

import host.plas.exampleproject.data.PlayerData;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlayerCreationEvent extends OwnEvent {
    private PlayerData data;

    public PlayerCreationEvent(PlayerData data) {
        super();
        this.data = data;
    }
}
