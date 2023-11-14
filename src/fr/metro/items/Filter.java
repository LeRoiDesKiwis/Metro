package fr.metro.items;

import fr.metro.items.Item;

public class Filter extends Item {
    private final int CAPACITY = 50;
    private int timeLeft ;
    public Filter(){
        super("Filter", "Allows you to breath the irradiated air");
        timeLeft = CAPACITY;
    }
}
