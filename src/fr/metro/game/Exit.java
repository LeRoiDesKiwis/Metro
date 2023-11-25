package fr.metro.game;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Player;

import java.util.ArrayList;
import java.util.List;

public class Exit {
    private final Location out;

    public Exit(Location out) {
        this.out = out;
    }

    public boolean canBeOpened(Player player){
        return true;
    }

    public void move(Player character){
        if (canBeOpened(character)) {
            character.move(out);
        }
        else System.out.println("You can't open that door.");
    }

}
