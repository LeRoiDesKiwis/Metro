package fr.metro.characters.enemies;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;

public abstract class Enemy extends GameCharacter {
    protected Enemy(String name, int hp, Inventory inventory) {
        super(name, hp, inventory);
    }
}
