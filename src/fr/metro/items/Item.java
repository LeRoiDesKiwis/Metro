package fr.metro.items;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Player;

public abstract class Item {

    protected String description ;
    private final ItemType itemtype;

    public Item(String description, ItemType itemtype) {
        this.description = description;
        this.itemtype = itemtype;
    }

    public String name(){
        String simpleName = getClass().getSimpleName();
        return String.valueOf(simpleName.charAt(0)).toUpperCase()+simpleName.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return name();
    }

    public void printItem(){
        System.out.println("- ("+this.itemtype+") "+ name() + " (" + this.description+")");
    }

    public boolean hasName(String itemName) {
        return name().equalsIgnoreCase(itemName);
    }
    public ItemType getItemtype() {
        return itemtype;
    }

    public void printItemName() {
        System.out.println(name());
    }

    public void use(GameCharacter player){
    }
    public enum ItemType{
        ARMOR_HEAD, ARMOR_TORSO, ARMOR_LEG, ARMOR_FEET, WEAPON, FOOD, SPECIAL
    }


}
