package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.friends.Dialogue;
import fr.metro.items.Filter;
import fr.metro.items.Item;
import fr.metro.items.armors.GasMask;

public class Main {
    public static void main(String[] args){
        Item myItem = new GasMask();
        myItem.printItem();
        Inventory test = new Inventory();
        test.initEquipment();
        test.showInventory();
        Filter lol = new Filter();
        lol.useFilter();
        lol.useFilter();
        lol.useFilter();
        lol.useFilter();
        lol.useFilter();
        lol.printFilter();

}
