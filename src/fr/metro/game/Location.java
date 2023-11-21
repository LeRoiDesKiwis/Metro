package fr.metro.game;

import fr.metro.items.Item;
import fr.metro.characters.GameCharacter;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class Location {
    private String description;
    private final List<Item> stuff = new ArrayList<>();
    private final List<GameCharacter> characters = new ArrayList<>();
    private final HashMap<String,Exit> exits = new HashMap<String,Exit>();
}