package fr.metro.characters;

import fr.metro.Util;
import fr.metro.items.Item;
import fr.metro.items.armors.BasicChestplate;
import fr.metro.items.armors.BasicLegPiece;
import fr.metro.items.armors.BasicShoes;
import fr.metro.items.armors.GasMask;
import fr.metro.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final Item[] equipment = new Item[4]; // 0 = head, 1 = torso, 2 = legs, 3 = feet

    public Inventory(Item... items){
        this.items.addAll(List.of(items));

        this.equipment[0] = new GasMask();
        this.equipment[1] = new BasicChestplate();
        this.equipment[2] = new BasicLegPiece();
        this.equipment[3] = new BasicShoes();
    }
    public Optional<Item> getItemByName(String itemName){
        return items.stream().filter(item -> item.hasName(itemName)).findAny();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void show(){
        showItems();
        showEquipment();
    }

    public void showItems(){
        Util.display("ITEMS", items);
    }

    public void showEquipment(){
        System.out.println("[--- Equipment ---]");
        for(int i = 0; i < equipment.length; i++){
            String armorName = Item.ItemType.values()[i].toString().replace("ARMOR_", "");
            System.out.println("\t<"+ armorName +">");

            if(this.equipment[i] != null) this.equipment[i].printItemName();
            else System.out.println("\tempty");
        }
    }

    public <T> boolean hasItem(Class<T> itemClass) {
        return items.stream().anyMatch(item -> item.getClass().equals(itemClass));
    }

    public Weapon getWeaponOrDefault(String weaponName) {
        return items.stream().filter(item -> item.hasName(weaponName)).filter(item -> item instanceof Weapon).map(item -> (Weapon)item).findFirst().orElse(new Weapon("fist", "UPPERCUT !", 2));
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.hasName(itemName));
    }

    public <T> void removeItem(Class<T> clazz) {
        items.stream().filter(item -> item.getClass().equals(clazz)).findAny().ifPresent(items::remove);
    }
}
