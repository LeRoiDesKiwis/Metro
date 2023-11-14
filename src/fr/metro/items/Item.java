package fr.metro.items;

public abstract class Item {
    protected String name ;
    protected String description ;
    public Item(String name, String description){
        this.name = name ;
        this.description = description ;
    }

    public void printItem (){
        System.out.println("- " + this.name + " : " + this.description);
    }

    public void printItemName (){
        System.out.println("    " + this.name);
    }
}
