package fr.metro.game.exits;

import fr.metro.characters.Player;
import fr.metro.game.Exit;
import fr.metro.game.Location;

public class FinalExit extends Exit {
    public FinalExit(Location out) {
        super(out);
    }

    @Override
    public void move(Player character) {
        System.out.println("\n~~~~~~~~~ Congratulations ! You finished the game ~~~~~~~~~");
        System.exit(0);
    }
}
