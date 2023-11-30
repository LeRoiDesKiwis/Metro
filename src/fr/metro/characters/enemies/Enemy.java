package fr.metro.characters.enemies;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.items.Item;

//Definition of our Enemy class, with a weapon
public class Enemy extends GameCharacter {
    private String weaponName;

    //Enemy constructor
    public Enemy(String name, int hp, Inventory inventory) {
        super(name, hp, inventory);
        inventory.getItemByType(Item.ItemType.WEAPON).ifPresent(item -> this.weaponName = item.name());
    }

    //
    public void interact(Player player, String[] args){
        attack(player, weaponName);
    }

    public void talk(Player player){
        System.out.println("I don't want to talk to you !");
    }
}
