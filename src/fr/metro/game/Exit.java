package fr.metro.game;

import fr.metro.characters.Player;

//Definition of our Exit class, with an exit location
public class Exit {
    private final Location out;

    //Exit constructor
    public Exit(Location out) {
        this.out = out;
    }

    //returns true if the exit can be opened
    public boolean canBeOpened(Player player){
        return true;
    }

    //moves the player to the location defined in an exit
    public void move(Player character){
        if (canBeOpened(character)) {
            character.move(out);
        }
        else System.out.println("You can't open that door.");
    }

    //Overrides method toString
    //returns the exit location as a string
    @Override
    public String toString() {
        return out.toString();
    }
}
