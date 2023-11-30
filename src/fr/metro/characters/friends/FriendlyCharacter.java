package fr.metro.characters.friends;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.characters.Player;

//Definition of our FriendlyCharacter classe, subclass of GameCharacter, with an introduction line
public class FriendlyCharacter extends GameCharacter {
    private final String introductionLine;
    //FriendlyCharacter constructor
    public FriendlyCharacter(String name, int hp, Inventory inventory, String introductionLine){
        super(name, hp ,inventory);
        this.introductionLine = introductionLine;
    }

    //introduces a FriendlyCharacter
    protected void introduce(Player player, String introductionLine){
        System.out.println(introductionLine.replace("[player]", player.toString())
                .replace("[name]", toString())
                .replace("[role]", getClass().getSimpleName().toLowerCase()));
    }

    //introduces a npc with its introduction line
    public void introduce(Player player){
        introduce(player, this.introductionLine);
    }

    //defines interaction with a player
    public void interact(Player player, String[] args) {
        if(args.length > 0) introduce(player);
    }

    //Overrides method attack
    @Override
    public void attack(GameCharacter character1, String weaponName) {
    }

    public void talk(Player player){
        introduce(player);
    }
}
