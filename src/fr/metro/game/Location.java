package fr.metro.game;

import fr.metro.items.Item;
import fr.metro.characters.GameCharacter;

import java.util.*;

public class Location {
    private String description;
    private final List<Item> stuff;
    private final List<GameCharacter> characters;
    private final Map<String,Exit> exits;

    public Location(List<Item> items, List<GameCharacter> characters, Map<String,Exit> exits){
        this.stuff = items;
        this.characters = characters;
        this.exits = exits;
    }

    public Location(){
        this(new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    }

    public Optional<GameCharacter> getCharacterByName(String name){
        return characters.stream().filter(character -> character.hasName(name)).findAny();
    }
}