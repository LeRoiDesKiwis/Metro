package fr.metro.items.weapons;

import fr.metro.characters.GameCharacter;

public abstract class Weapon extends Item {
    private int damage ;
    @Override
    public String toString(){
        return name + " : " + description + " " + "\n This weapon make " + damage + " damages.";
    }

    public void attack(GameCharacter character){
        character.damage(damage);
    }

    public Weapon(String name, String description, int damage){
        super(name, description, ItemType.WEAPON);
        this.damage = damage ;
    }
}
