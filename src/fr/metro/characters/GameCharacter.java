package fr.metro.characters;

public abstract class GameCharacter {
    private int hp;
    private final String name;
    private final Inventory inventory;

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

    @Override
    public String toString() {
        return name;
    }
}
