package fr.metro.items;

import fr.metro.items.Item;

public abstract class Weapon extends Item {
    private int damage ;

    public Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage ;
    }
}
