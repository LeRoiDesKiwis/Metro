package fr.metro.items.foods;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

//Definition of our Class food, defined by the health bonus
public abstract class Food extends Item {
    private final int bonus ;

    //Food constructor
    public Food(String description, int bonus){
        super(description, ItemType.FOOD) ;
        this.bonus = bonus ;
    }

    //Overrides method use
    @Override
    public void use(GameCharacter character){
        character.heal(bonus);
        System.out.println("Vous avez regagné " + bonus+ " point de vie. PV : " + character.getHp());
        character.getInventory().removeItem(this);
    }
}
