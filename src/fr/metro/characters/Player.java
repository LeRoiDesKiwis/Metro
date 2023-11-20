package fr.metro.characters;

public class Player extends GameCharacter {

    public Player(String name, int hp) {
        super(name, hp, new Inventory());
    }

}
