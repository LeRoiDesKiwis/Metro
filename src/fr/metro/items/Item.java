package fr.metro.items;

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

    public void printItem(){
        System.out.println("- ("+this.itemtype+") "+ name() + " (" + this.description+")");
    }

    public boolean hasName(String itemName) {
        return name().equalsIgnoreCase(itemName);
    }

    public void printItemName() {
        System.out.println(name());
    }

    public enum ItemType{
        ARMOR_HEAD, ARMOR_TORSO, ARMOR_LEG, ARMOR_FEET, WEAPON, FOOD, SPECIAL
    }
}
