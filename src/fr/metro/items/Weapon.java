package fr.metro.items;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

public abstract class Weapon extends Item {
    private int damage ;
    @Override
    public String toString(){
        return name + " : " + description + " " + "This weapon make " + damage + " damages.";
    }

    public void attack(GameCharacter character){
        if(character != null) character.damage(damage);
    }

    public Weapon(String name, String description, int damage){
        super(name, description);
        this.damage = damage ;
    }
}
