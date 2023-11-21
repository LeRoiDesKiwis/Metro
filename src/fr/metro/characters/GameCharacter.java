package fr.metro.characters;

import fr.metro.game.Location;

public abstract class GameCharacter {
    private int hp;
    private final String name;
    private final Inventory inventory;

    private Location currentLocation ;

    protected GameCharacter(String name, int hp, Inventory inventory) {
        this.hp = hp;
        this.name = name;
        this.inventory = inventory;
    }

    public void interact(Player player, String[] args){}

    /**
     * Remove {@code damage} hps from the player. <p/>
     * If damage>hp, hp will be 0.
     * @param damage the hp to remove
     */
    public void damage(int damage){
        this.hp = Math.max(0, this.hp-damage);
    }
    public void heal(int heal){this.hp += heal ;}

    public void move(Location gotoloc){ this.currentLocation = gotoloc ;}

    @Override
    public String toString() {
        return name + hp ;
    }

    public <T> boolean hasItem(Class<T> itemClass) {
        return inventory.hasItem(itemClass);
    }

    public void showInventory(){
        inventory.show();
    }

    public boolean hasName(String name) {
        return name.equals(this.name);
    }

    public void talk(Player player){

    }
}
