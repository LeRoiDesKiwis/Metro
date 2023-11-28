package fr.metro.game.exits;

import fr.metro.characters.Player;
import fr.metro.items.Key;
import fr.metro.game.Exit;
import fr.metro.game.Location;

public class LockedExit extends Exit {

    public LockedExit(Location out) {
        super(out);
    }

    public boolean canBeOpened(Player player){
        return player.hasItem(Key.class);
    }

    @Override
    public void move(Player character) {
        super.move(character);
        character.removeItem(Key.class);
    }
}
