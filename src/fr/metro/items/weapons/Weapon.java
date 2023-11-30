package fr.metro.items.weapons;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

public  abstract class Weapon extends Item {
    private final int damage;
    @Override
    public String toString(){
        return name() + " (" + description + ")";
    }

    public void attack(GameCharacter character){
        character.damage(damage);
    }

    public Weapon(String description, int damage){
        super(description, ItemType.WEAPON);
        this.damage = damage ;
    }
}
