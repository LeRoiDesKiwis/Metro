package fr.metro.characters.friends;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;

public abstract class FriendlyCharacter extends GameCharacter {
    private String introductionLine;
    public FriendlyCharacter(String name, int hp, Inventory inventory){
        super(name, hp ,inventory);
    }


}
