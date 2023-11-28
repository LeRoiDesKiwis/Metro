package fr.metro.items.foods;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

public abstract class Food extends Item {
    private final int bonus ;

    public Food(String description, int bonus){
        super(description, ItemType.FOOD) ;
        this.bonus = bonus ;
    }

    public void use(GameCharacter character){
        character.heal(bonus);
        System.out.println("Vous avez regagné " + bonus+ " point de vie. PV : " + character.getHp());
    }
}
