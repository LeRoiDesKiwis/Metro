package fr.metro.characters;

import fr.metro.items.weapons.Weapon;

//Definition of our abstract GameCharacter class, with its hp, name and inventory
public abstract class GameCharacter {
    private int hp;
    protected final String name;
    protected final Inventory inventory;

    //GameCharacter constructor
    protected GameCharacter(String name, int hp, Inventory inventory) {
        this.hp = hp;
        this.name = name;
        this.inventory = inventory;
    }

    //defines method interact only for it to overridden
    public void interact(Player player, String[] args){}

    //updates hp minus given damages
    public void damage(int damage){
        this.hp = Math.max(0, this.hp-damage);
    }

    //updates hp plus given healing (max 20hp)
    public void heal(int heal){
        if (this.hp+heal>=20){this.hp=20;}
        else {this.hp += heal;}
    }

    //verifies if a character is dead
    public boolean isDead(){
        return this.hp <= 0;
    }

    //overrides method to string to return a character's name and hp as a string
    @Override
    public String toString() {
        return name + " ("+hp+"HP)" ;
    }

    //checks if the character has an item of type ItemClass in inventory
    public <T> boolean hasItem(Class<T> itemClass) {
        return inventory.hasItem(itemClass);
    }

    //calls inventory method show to display a character's inventory
    public void showInventory(){
        inventory.show();
    }

    public Inventory getInventory(){
        return this.inventory ;
    }

    public boolean hasName(String name) {
        return name.equalsIgnoreCase(this.name);
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
        if(character1.isDead()) inventory.concat(character1.inventory);
    }

    public void kill() {
        this.hp = 0;
    }
}
