package fr.metro.characters;

import fr.metro.Util;
import fr.metro.items.Item;
import fr.metro.items.armors.*;
import fr.metro.items.weapons.Fist;
import fr.metro.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Definition of our Inventory class, with a list of Items, and a array
//serving as equipment slots for the player
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final Item[] equipment = new Item[4]; // 0 = head, 1 = torso, 2 = legs, 3 = feet

    //Inventory constructor
    //also initialises the basic equipment
    public Inventory(List<Item> items){
        this.items.addAll(items);
        this.equipment[0] = new GasMask();
        this.equipment[1] = new BasicChestplate();
        this.equipment[2] = new BasicLegPiece();
        this.equipment[3] = new BasicShoes();
    }

    //Default Inventory constructor
    public Inventory(){
        this(new ArrayList<>());
    }


    //finds any item using the string itemname
    public Optional<Item> getItemByName(String itemName){
        return items.stream().filter(item -> item.hasName(itemName)).findAny();
    }

    //gets an item using an itemType given
    public Optional<? extends Item> getItemByType(Item.ItemType itemType){
        return items.stream().filter(item -> item.isType(itemType)).findAny();
    }

    //returns gas mask
    public GasMask getGasMask(){
        return (GasMask) this.equipment[0];
    }

    //add an item to the inventory
    public void addItem(Item item){
        items.add(item);
    }

    //displays the inventory and equipment
    public void show(){
        showItems();
        showEquipment();
    }

    //displays inventory
    public void showItems(){
        Util.display("ITEMS", items);
    }

    //displays equipment
    public void showEquipment(){
        System.out.println("[--- Equipment ---]");
        for(int i = 0; i < equipment.length; i++){
            String armorName = Item.ItemType.values()[i].toString().replace("ARMOR_", "");
            System.out.println("<"+ armorName +">");

            if(this.equipment[i] != null) this.equipment[i].printItemName();
            else System.out.println("\tempty");
        }
    }


    public <T> boolean hasItem(Class<T> itemClass) {
        return items.stream().anyMatch(item -> item.getClass().equals(itemClass));
    }

    //find a weapon in inventory if non existent we return the default weapon (fist)
    public Weapon getWeaponOrDefault(String weaponName) {
        return items.stream().filter(item -> item.hasName(weaponName)).filter(item -> item instanceof Weapon).map(item -> (Weapon)item).findFirst().orElse(new Fist());
    }

    //returns true if it finds an item with the same name as the String ItemName
    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.hasName(itemName));
    }


    public <T> void removeItem(Class<T> clazz) {
        items.stream().filter(item -> item.getClass().equals(clazz)).findAny().ifPresent(items::remove);
    }

    //deletes Item from Inventory
    public void removeItem(Item item) {
        items.remove(item);
    }

    //merges an inventory passed as argument to the inventory
    public void concat(Inventory inventory){
        items.addAll(inventory.items);
    }
}
