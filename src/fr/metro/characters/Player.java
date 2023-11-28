package fr.metro.characters;

import fr.metro.game.Exit;
import fr.metro.game.Location;

import java.util.Optional;

public class Player extends GameCharacter {

    private Location currentLocation ;
    public Player(String name, int hp, Inventory inventory, Location defaultLocation) {
        super(name, hp, inventory);
        this.currentLocation = defaultLocation;
    }

    public void move(Location location){ this.currentLocation = location ;}
    public void move(String exitName){
        currentLocation.getExit(exitName).ifPresent(exit -> exit.move(this));
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Player(String name, int hp, Location defaultLocation){
        this(name, hp, new Inventory(), defaultLocation);
    }


    public boolean canMove(String exitName) {
        Optional<Exit> exit = currentLocation.getExit(exitName);
        return exit.isPresent() && exit.get().canBeOpened(this);
    }
}
