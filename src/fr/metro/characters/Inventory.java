package fr.metro.characters;

import fr.metro.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final Item[] equipment = new Item[4]; // 0 = head, 1 = torso, 2 = legs, 3 = feet

    public Inventory(){
    }
}
