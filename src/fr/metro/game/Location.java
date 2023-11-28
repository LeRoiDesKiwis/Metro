package fr.metro.game;

import fr.metro.Util;
import fr.metro.characters.GameCharacter;
import fr.metro.characters.Inventory;
import fr.metro.items.Item;

import java.lang.reflect.InvocationTargetException;
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
        System.out.println("[EXITS]");
        for (String exitName : exitNames()) {
            Exit exit = exits.get(exitName);
            System.out.println("- ("+exit.getClass().getSimpleName().toLowerCase()+") "+exitName+" -> "+ exit);
        }
    }

    public void removeItem(Item item) {
        inventory.removeItem(item);
    }

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