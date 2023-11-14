package fr.metro.characters.friends;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.characters.Player;

public abstract class FriendlyCharacter extends GameCharacter {
    private final String introductionLine;
    public FriendlyCharacter(String name, int hp, Inventory inventory, String introductionLine){
        super(name, hp ,inventory);
        this.introductionLine = introductionLine;
    }

    public void interact(Player player) {
        System.out.println(getClass().getSimpleName().toLowerCase()+" "+this);
        System.out.println(introductionLine.replace("[player]", player.toString())
                .replace("[name]", toString())
                .replace("[role]", getClass().getSimpleName().toLowerCase()));
    }
}
