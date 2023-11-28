package fr.metro.items.armors;

import fr.metro.items.Item;

public abstract class Armor extends Item {
    public Armor(String name, String description, ItemType itemType){
        super(description, itemType);
    }
}
