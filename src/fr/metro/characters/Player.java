package fr.metro.characters;

import fr.metro.game.Location;

public class Player extends GameCharacter {
    private Location currentLocation ;
    public Player(String name, int hp, Inventory inventory) {
        super(name, hp, inventory);
    }

    public Player(String name, int hp){
        this(name, hp, new Inventory());
    }

}
