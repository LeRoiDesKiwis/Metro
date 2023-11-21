package fr.metro.characters.enemies;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.characters.Player;

public abstract class Enemy extends GameCharacter {
    public Enemy(String name, int hp, Inventory inventory) {
        super(name, hp, inventory);
    }

    public void interact(Player player, String[] args){
        attack(player);
    }

    protected abstract void attack(Player player);

    public void talk(Player player){
        System.out.println("I don't want to talk to you èwé !");
    }
}
