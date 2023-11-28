package fr.metro.game.exits;

import fr.metro.characters.Player;
import fr.metro.items.Key;
import fr.metro.game.Exit;
import fr.metro.game.Location;

public class LockedExit extends Exit {

    private boolean open = false;

    public LockedExit(Location out) {
        super(out);
    }

    public boolean canBeOpened(Player player){
        if(open || player.hasItem(Key.class)){
            this.open = true;
            return true;
        } else return false;
    }

    @Override
    public void move(Player character) {
        super.move(character);
        character.removeItem(Key.class);
    }
}
