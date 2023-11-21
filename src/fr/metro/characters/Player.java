package fr.metro.characters;

import fr.metro.game.Location;

public class Player extends GameCharacter {
    private Location currentLocation ;
    public Player(String name, int hp, Inventory inventory, Location defaultLocation) {
        super(name, hp, inventory);
        this.currentLocation = defaultLocation;
    }


    public Player(String name, int hp, Location defaultLocation){
        this(name, hp, new Inventory(), defaultLocation);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
