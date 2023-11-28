package fr.metro.items;

import fr.metro.characters.GameCharacter;
import fr.metro.game.Game;

public class Filter extends Item {
    private static final int CAPACITY = 10;
    private int capacityLeft ;
    public Filter(){
        super("Allows you to breath the irradiated air", ItemType.FILTER);
        capacityLeft = CAPACITY;
    }

    public void useFilter(){
        this.capacityLeft--;
    }

    @Override
    public String toString(){
        String s = super.toString() + ("\n     <!> filter status <!>\n");
        s+=("[");
        for (int i = 0; i<CAPACITY; i++){
            if(i<capacityLeft){s+=(" * ");}
            else {s+=(" - ");}
        }
        s+=("]");
        return s;
    }

}
