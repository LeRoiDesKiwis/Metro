package fr.metro.items.armors;

import fr.metro.items.Item;

//Definition of Armor, subclass of Item
//There is no real benefit for wearing armor in the game
//but we wanted to add the gasmask mechanic and keep the game modular
public abstract class Armor extends Item {
    public Armor(String name, String description, ItemType itemType){
        super(description, itemType);
    }
}
