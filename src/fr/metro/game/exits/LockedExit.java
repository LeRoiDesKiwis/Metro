package fr.metro.game.exits;

import fr.metro.characters.Player;
import fr.metro.items.Key;
import fr.metro.game.Exit;
import fr.metro.game.Location;

//Definition of our LockedExit class, subclass of Exit, with a boolean to verify if the door has been unlocked
public class LockedExit extends Exit {
    private boolean open = false;

    //LockedExit constructor
    public LockedExit(Location out) {
        super(out);
    }

    //returns true if the door had previously been opened or if the player has a key
    public boolean canBeOpened(Player player){
        if(open || player.hasItem(Key.class)){
            this.open = true;
            return true;
        } else return false;
    }

    //Overrides method move from the mother class exit
    //uses the super method and removes the key once you unlock a locked exit
    @Override
    public void move(Player character) {
        super.move(character);
        character.removeItem(Key.class);
    }
}
