package fr.metro.game;

import fr.metro.Util;
import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.items.Item;

import java.util.*;

public class Location {

    private final String name;
    private final String description;
    private final Inventory inventory;
    private final List<GameCharacter> characters;
    private final Map<String,Exit> exits;

    public Location(String name, String description, Inventory inventory, List<GameCharacter> characters, Map<String,Exit> exits){
        this.inventory = inventory;
        this.characters = characters;
        this.exits = exits;
        this.description = description ;
        this.name = name;
    }

    public Location(String name, String description){

        this(name, description, new Inventory(), new ArrayList<>(), new HashMap<>());
    }

    public Optional<GameCharacter> getCharacterByName(String name){
        return characters.stream().filter(character -> character.hasName(name)).findAny();
    }

    public boolean hasItem(String itemName){
      return inventory.hasItem(itemName);
    }


    public void print(){
        System.out.println(description);
    }

    public Optional<Exit> getExit(String exitName){
        return exits.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(exitName)).map(Map.Entry::getValue).findAny();
    }

    @Override
    public String toString() {
        return name;
    }

    public Set<String> exitNames() {
        return exits.keySet();
    }

    public Optional<Item> getItemByName(String itemName) {
        return inventory.getItemByName(itemName);
    }

    public void showCharacters() {
        Util.display("CHARACTER", characters);
    }

    public void showItems(){
        inventory.showItems();
    }

    public void showExits() {
        Util.display("EXITS", exitNames());
    }
}