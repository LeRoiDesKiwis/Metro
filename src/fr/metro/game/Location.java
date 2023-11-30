package fr.metro.game;

import fr.metro.Util;
import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.items.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Stream;

//Defintion of our Location class, with a name, description, an "inventory" aka the items available
//in the room, a list of characters in the room and map that links our exits with their names
public class Location {
    private final String name;
    private final String description;
    private final Inventory inventory;
    private final List<GameCharacter> characters;
    private final Map<String,Exit> exits;

    //Location constructor
    public Location(String name, String description, Inventory inventory, List<GameCharacter> characters, Map<String,Exit> exits){
        this.inventory = inventory;
        this.characters = characters;
        this.exits = exits;
        this.description = description ;
        this.name = name;
    }

    //Location basic constructor
    public Location(String name, String description){
        this(name, description, new Inventory(), new ArrayList<>(), new HashMap<>());
    }

    //finds a character in a location from a given name
    public Optional<GameCharacter> getCharacterByName(String name){
        return characters.stream().filter(character -> character.hasName(name)).findAny();
    }

    //returns true if it finds an item in a location from a given name
    public boolean hasItem(String itemName){
      return inventory.hasItem(itemName);
    }

    //returns an exit if it finds one from a given name
    public Optional<Exit> getExit(String exitName){
        return exits.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(exitName)).map(Map.Entry::getValue).findAny();
    }

    //overrides toString method
    //returns a String describing a location
    @Override
    public String toString() {
        return String.format("%s [%s]", name, description);
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

    //displays the exits in the room
    public void showExits() {
        System.out.println("[EXITS]");
        for (String exitName : exitNames()) {
            Exit exit = exits.get(exitName);
            System.out.println("- ("+exit.getClass().getSimpleName().toLowerCase()+") "+exitName+" -> "+ exit);
        }
    }

    //removes a given item from the location
    public void removeItem(Item item) {
        inventory.removeItem(item);
    }


    public Stream<GameCharacter> streamCharacters() {
        return characters.stream();
    }

    public void cleanDeaths(){
        for(Iterator<GameCharacter> iterator = characters.iterator(); iterator.hasNext();){
            GameCharacter character = iterator.next();
            if(character.isDead()) {
                System.out.println(character+" is dead !");
                iterator.remove();
            }
        }
    }

    //
    public static class LocationBuilder{

        private final String name;
        private String description = "no description";
        private final List<Item> items = new ArrayList<>();
        private final List<GameCharacter> characters = new ArrayList<>();
        private final Map<String,Exit> exits = new HashMap<>();
        private int exitIndex = 1;
        private final List<Location> twoWaysExit = new ArrayList<>();

        public LocationBuilder(String name, String description){
            this(name);
            this.description = description;
        }

        public LocationBuilder(String name){
            this.name = name.replace(" ", "-");
        }

        public LocationBuilder addItem(Item item){
            items.add(item);
            return this;
        }

        public LocationBuilder addCharacter(GameCharacter character){
            characters.add(character);
            return this;
        }

        public LocationBuilder addExit(LocationBuilder builder, boolean twoWays){
            Location location = builder.build();
            if(twoWays) twoWaysExit.add(location);
            return addExit(new Exit(location));
        }

        public LocationBuilder addExit(LocationBuilder builder){
            return addExit(builder, true);
        }

        public LocationBuilder addExit(Class<? extends Exit> exit, LocationBuilder builder, boolean twoWays){
            try {
                Location location = builder.build();

                if(twoWays) twoWaysExit.add(location);
                return addExit(exit.getDeclaredConstructor(Location.class).newInstance(builder.build()));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        public LocationBuilder addExit(Class<? extends Exit> exit, LocationBuilder builder){
            return addExit(exit, builder, true);
        }

        private LocationBuilder addExit(Exit exit){
            exits.put("exit"+(exitIndex++), exit);
            return this;
        }

        public Location build(){
            Location location = new Location(name, description, new Inventory(items), characters, exits);
            int i = 1;
            for(Location location1 : twoWaysExit){
                location1.exits.put("reverse"+(i++), new Exit(location));
            }
            return location;
        }
    }
}