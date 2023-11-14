package fr.metro.characters;

public class Player extends GameCharacter {

    public Player(int hp, String name) {
        super(hp, name, new Inventory());
    }
}
