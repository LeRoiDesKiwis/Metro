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
    
    //Verifie si une chaine de caractère correspond à un item
    public boolean hasName(String itemName) {
        return name().equalsIgnoreCase(itemName);
    }

    //Affiche le nom d'un item
    public void printItemName() {
        System.out.println(name());
    }

    //Definition de la commande use pour être Override dans les sous-classes
    public void use(GameCharacter player){
    }

    //Verifie si un item est du même itemType que celui en passé paramètre
    public boolean isType(ItemType itemtype){
        return this.itemtype == itemtype;
    }

    //Definition de notre type énuméré ItemType
    public enum ItemType{
        ARMOR_HEAD, ARMOR_TORSO, ARMOR_LEG, ARMOR_FEET, WEAPON, FOOD, SPECIAL, FILTER
    }


}
