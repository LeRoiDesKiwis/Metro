package fr.metro.characters.enemies;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.characters.Player;

public abstract class Enemy extends GameCharacter {
    public Enemy(String name, int hp, Inventory inventory) {
        super(name, hp, inventory);
    }

    public void interact(Player player){
        attack(player);
    }

    protected abstract void attack(Player player);
}
