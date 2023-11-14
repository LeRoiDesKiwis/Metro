package fr.metro.characters;

import fr.metro.items.GasMask;

public class Player extends GameCharacter {
    public Player(int hp, String name) {
        super(hp, name, new Inventory());
    }
}
