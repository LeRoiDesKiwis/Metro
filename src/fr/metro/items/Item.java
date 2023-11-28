package fr.metro.items;

public abstract class Item {
    protected String name ;
    protected String description ;
    private ItemType itemtype;

    public Item(String name, String description, ItemType itemtype) {
        this.name = name;
        this.description = description;
        this.itemtype = itemtype;
    }

    public void printItem (){
        System.out.println("- ("+this.itemtype+") "+ this.name + " (" + this.description+")");
    }

    public String getItemName (){
        return this.name;
    }

    public boolean hasName(String itemName) {
        return name.equalsIgnoreCase(itemName);
    }

    public void printItemName() {
        System.out.println(name);
    }

    public enum ItemType{
        ARMOR_HEAD, ARMOR_TORSO, ARMOR_LEG, ARMOR_FEET, WEAPON, FOOD, SPECIAL;
    }
}
