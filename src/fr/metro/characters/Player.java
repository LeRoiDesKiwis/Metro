package fr.metro.characters;

import fr.metro.game.Exit;
import fr.metro.game.Location;
import fr.metro.items.Filter;
import fr.metro.items.Item;

import java.util.Optional;

//Definition of our Player class, with its current location (room is currently in)
public class Player extends GameCharacter {

    private Location currentLocation ;
    //Player constructor
    public Player(String name, int hp, Inventory inventory, Location defaultLocation) {
        super(name, hp, inventory);
        this.currentLocation = defaultLocation;
        inventory.addItem(new Filter());
    }

    //changes the current location of the player to the location given
    public void move(Location location){ this.currentLocation = location ;}

    //moves the player using an exit name
    public void move(String exitName){
        currentLocation.getExit(exitName).ifPresent(exit -> exit.move(this));
    }

    //getter for currentLocation
    public Location getCurrentLocation() {
        return currentLocation;
    }

    //Player constructor that initialises the inventory to the default equipment
    public Player(String name, int hp, Location defaultLocation){
        this(name, hp, new Inventory(), defaultLocation);
    }

    //checks if the player can move, if exit is correct, if the exit is locked
    public boolean canMove(String exitName) {
        Optional<Exit> exit = currentLocation.getExit(exitName);
        return exit.isPresent() && exit.get().canBeOpened(this);
    }

    //checks if an item is the inventory from a given name
    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
    }

    //removes item of class clazz from inventory
    public <T> void removeItem(Class<T> clazz) {
        inventory.removeItem(clazz);
    }

    //adds a item to the inventory
    public void addItem(Item item) {
        inventory.addItem(item);
    }
}
