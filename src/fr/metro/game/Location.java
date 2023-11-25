package fr.metro.game;

import fr.metro.items.Item;
import fr.metro.characters.GameCharacter;

import java.util.*;

public class Location {
    private final String description;
    private final List<Item> stuff;
    private final List<GameCharacter> characters;
    private final Map<String,Exit> exits;

    public Location(List<Item> items, List<GameCharacter> characters, Map<String,Exit> exits, String description){
        this.stuff = items;
        this.characters = characters;
        this.exits = exits;
        this.description = description ;
    }

    public Location(String description){

        this(new ArrayList<>(), new ArrayList<>(), new HashMap<>(), description);
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
}