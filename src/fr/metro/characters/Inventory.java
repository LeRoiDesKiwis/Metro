package fr.metro.characters;

import fr.metro.items.Item;
import fr.metro.items.armors.BasicChestplate;
import fr.metro.items.armors.BasicLegPiece;
import fr.metro.items.armors.BasicShoes;
import fr.metro.items.armors.GasMask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final Item[] equipment = new Item[4]; // 0 = head, 1 = torso, 2 = legs, 3 = feet

    public Inventory(Item... items){
        this.items.addAll(List.of(items));
    }
    public void initEquipment(){
        this.equipment[0]= new GasMask();
        this.equipment[1]= new BasicChestplate();
        this.equipment[2]= new BasicLegPiece();
        this.equipment[3]= new BasicShoes();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void show(){
        int length = this.items.size();
        System.out.println("[--- Inventory ---]");
        for (int i= 0; i<length; i++){
            items.get(i).printItem();
        }
        System.out.println("[--- Equipment ---]");
        System.out.println("     <Head>");
        this.equipment[0].printItemName();
        System.out.println("-------------------");
        System.out.println("     <Torso>");
        this.equipment[1].printItemName();
        System.out.println("-------------------");
        System.out.println("     <Legs>");
        this.equipment[2].printItemName();
        System.out.println("-------------------");
        System.out.println("     <Feet>");
        this.equipment[3].printItemName();
        System.out.println("-------------------");
    }

    public Stream<Item> streamItems() {
        return items.stream();
    }

    public <T> boolean hasItem(Class<T> itemClass) {
        return items.stream().anyMatch(item -> item.getClass().equals(itemClass));
    }
}
