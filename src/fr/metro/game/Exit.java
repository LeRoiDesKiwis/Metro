package fr.metro.game;

import fr.metro.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class Exit {
    private Location out;

    public Exit(Location out) {
        this.out = out;
    }

    public boolean canBeOpened(Player player){
        return true;
    }

}
