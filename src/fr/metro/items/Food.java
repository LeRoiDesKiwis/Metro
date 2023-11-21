package fr.metro.items;

import fr.metro.characters.GameCharacter;

public abstract class Food {
    private int bonus ;

    public Food(int bonus){
        this.bonus = bonus ;
    }

    public void eat(GameCharacter character){
        character.heal(bonus);
    }
}
