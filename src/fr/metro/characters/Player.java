package fr.metro.characters;

import fr.metro.items.GasMask;

public class Player extends GameCharacter {

    public Player(String name, int hp) {
        super(name, hp, new Inventory());
    }

    @Override
    public void interact(Player player) {

    }
}
