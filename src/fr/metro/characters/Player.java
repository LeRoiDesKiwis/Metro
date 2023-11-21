package fr.metro.characters;

import fr.metro.game.Location;

public class Player extends GameCharacter {
    private Location currentLocation ;
    public Player(String name, int hp) {
        super(name, hp, new Inventory());
    }

}
