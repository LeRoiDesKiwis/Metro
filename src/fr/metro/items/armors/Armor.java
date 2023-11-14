package fr.metro.items.armors;

import fr.metro.items.Item;

public abstract class Armor extends Item {
    private final int placement;
    public Armor(String name, String description, int placement){
        super(name, description);
        this.placement=placement;
    }
}
