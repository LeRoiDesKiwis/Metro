package fr.metro.characters;

import fr.metro.game.Exit;
import fr.metro.game.Location;
import fr.metro.items.Item;
import fr.metro.items.weapons.Weapon;

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

    public void take(String itemName){
        if(currentLocation.hasItem(itemName)){
            getInventory().addItem(itemName);
            System.out.println("Successfully taken" + itemName);
            return ;
        }
        System.out.println("Couldn't take" + itemName);
    }

    public boolean canMove(String exitName) {
        Optional<Exit> exit = currentLocation.getExit(exitName);
        return exit.isPresent() && exit.get().canBeOpened(this);
    }

    public void attack(GameCharacter character1, String weaponName) {
        Weapon weapon = inventory.getWeaponOrDefault(weaponName);
        System.out.println(name+" attacked "+character1+" with "+weapon);
        weapon.attack(character1);
    }

    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
    }
}
