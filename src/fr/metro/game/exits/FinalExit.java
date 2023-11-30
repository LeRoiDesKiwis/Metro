package fr.metro.game.exits;

import fr.metro.characters.Player;
import fr.metro.game.Exit;
import fr.metro.game.Location;

//Definition of our FinalExit class, subclass of Exit
public class FinalExit extends Exit {

    //FinalExit Constructor
    public FinalExit(Location out) {
        super(out);
    }

    //Overrides method from mother class exit
    //if a player moves through the final exit it displays a message and stops the game
    @Override
    public void move(Player character) {
        System.out.println("\n~~~~~~~~~ Congratulations ! You finished the game ~~~~~~~~~");
        System.exit(0);
    }
}
