package GallowsGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int lifeNumber;
    private String name;

    public Player(String name, int lifeNumber) {
        this.name = name;
        this.lifeNumber = lifeNumber;
    }
}
