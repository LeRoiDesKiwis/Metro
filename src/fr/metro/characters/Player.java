package fr.metro.characters;

public class Player /*extends GameCharacter ??*/{

    private int hp;
    private final String name;

    private final Inventory inventory;

    public Player(int hp, String name, Inventory inventory) {
        this.hp = hp;
        this.name = name;
        this.inventory = inventory;
    }
}
