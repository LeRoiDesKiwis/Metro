package fr.metro.characters;

public abstract class GameCharacter {
    private int hp;
    private final String name;
    private final Inventory inventory;

    protected GameCharacter(int hp, String name, Inventory inventory) {
        this.hp = hp;
        this.name = name;
        this.inventory = inventory;
    }
}
