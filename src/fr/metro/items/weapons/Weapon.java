package fr.metro.items.weapons;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

//Definition of our abstract class Weapon, subclass of item, defined by its damages
public  abstract class Weapon extends Item {
    private final int damage;

    //Overrides toString method
    //returns a string describing a weapon
    @Override
    public String toString(){
        return name() + " (" + description + ")";
    }

    //calls the damage method from the GameCharacter Class
    public void attack(GameCharacter character){
        character.damage(damage);
    }

    //Weapon constructor
    public Weapon(String description, int damage){
        super(description, ItemType.WEAPON);
        this.damage = damage ;
    }
}
