package fr.metro.items;

import fr.metro.items.Item;

public class Filter extends Item {
    private final int CAPACITY = 10;
    private int capacityLeft ;
    public Filter(){
        super("Filter", "Allows you to breath the irradiated air");
        capacityLeft = CAPACITY;
    }

    public void useFilter(){
        this.capacityLeft--;
    }

    public void printFilter(){
        System.out.println("     <!> filter status <!>");
        System.out.print("[");
        for (int i = 0; i<this.CAPACITY; i++){
            if(i<capacityLeft){System.out.print(" * ");}
            else {System.out.print(" - ");}
        }
        System.out.print("]");
    }
}
