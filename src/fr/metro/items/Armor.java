package fr.metro.items;

public abstract class Armor extends Item{
    private final int placement;
    public Armor(String name, String description, int placement){
        super(name, description);
        this.placement=placement;
    }
}
