package fr.metro.game;

import fr.metro.characters.Player;


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

    @Override
    public String toString() {
        return out.toString();
    }
}
