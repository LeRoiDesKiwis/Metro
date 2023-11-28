package fr.metro.characters;

import fr.metro.items.weapons.Weapon;

public abstract class GameCharacter {
    private int hp;
    protected final String name;
    protected final Inventory inventory;

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

    @Override
    public String toString() {
        return name + " ("+hp+"HP)" ;
    }

    public <T> boolean hasItem(Class<T> itemClass) {
        return inventory.hasItem(itemClass);
    }

    public void showInventory(){
        inventory.show();
    }

    public Inventory getInventory(){
        return this.inventory ;
    }

    public boolean hasName(String name) {
        return name.equals(this.name);
    }

    public int getHp() {
        return hp;
    }

    public void talk(Player player){

    }

    public void attack(GameCharacter character1, String weaponName) {
        Weapon weapon = inventory.getWeaponOrDefault(weaponName);
        System.out.println(name+" attacked "+character1+" with "+weapon.name());
        weapon.attack(character1);
    }
}
