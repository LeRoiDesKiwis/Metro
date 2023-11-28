package fr.metro.game;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Item;

import java.util.*;

public class Location {

    private final String name;
    private final String description;
    private final List<Item> stuff;
    private final List<GameCharacter> characters;
    private final Map<String,Exit> exits;

    public Location(String name, String description, List<Item> items, List<GameCharacter> characters, Map<String,Exit> exits){
        this.stuff = items;
        this.characters = characters;
        this.exits = exits;
        this.description = description ;
        this.name = name;
    }

    public Location(String name, String description){

        this(name, description, new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    }

    public Optional<GameCharacter> getCharacterByName(String name){
        return characters.stream().filter(character -> character.hasName(name)).findAny();
    }

    public Boolean hasItem(String itemName){
      return stuff.stream().anyMatch(Item -> Item.hasName(itemName)) ;
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
}