package fr.metro.items;

import fr.metro.characters.GameCharacter;

// Definition of our abstract class Item, an item has a description and an ItemType
public abstract class Item {

    protected String description ;
    private final ItemType itemtype;

    //Item constructor
    public Item(String description, ItemType itemtype) {
        this.description = description;
        this.itemtype = itemtype;
    }

    //We consider item names as the name of the subclass
    //Returns the name of an item
    public String name(){
        String simpleName = getClass().getSimpleName();
        return String.valueOf(simpleName.charAt(0)).toUpperCase()+simpleName.substring(1).toLowerCase();
    }

    //Overrides method toString
    //Returns a string corresponding to an item
    @Override
    public String toString() {
        return "("+this.itemtype+") "+ name() + " : " + this.description;
    }

    //Verifies if a given string corresponds to an item
    public boolean hasName(String itemName) {
        return name().equalsIgnoreCase(itemName);
    }

    //Displays an item's name
    public void printItemName() {
        System.out.println(name());
    }

    //method used declared for it to overridden in subclasses
    public void use(GameCharacter player){
    }

    //Checks if an item is from given type
    public boolean isType(ItemType itemtype){
        return this.itemtype == itemtype;
    }

    //Definition of our enum type
    public enum ItemType{
        ARMOR_HEAD, ARMOR_TORSO, ARMOR_LEG, ARMOR_FEET, WEAPON, FOOD, SPECIAL, FILTER
    }


}
