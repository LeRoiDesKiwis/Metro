package fr.metro.game;

import fr.metro.items.Item;
import fr.metro.characters.GameCharacter;

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

    public void print(){
        System.out.println(description);
    }

    public Optional<Exit> getExit(String exitName){
        return exits.containsKey(exitName) ? Optional.of(this.exits.get(exitName)) : Optional.empty();
    }

    @Override
    public String toString() {
        return name;
    }
}