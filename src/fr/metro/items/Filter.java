package fr.metro.items;

public class Filter extends Item {
    private static final int CAPACITY = 10;
    private int capacityLeft ;
    public Filter(){
        super("Filter", "Allows you to breath the irradiated air", ItemType.SPECIAL);
        capacityLeft = CAPACITY;
    }

    public void useFilter(){
        this.capacityLeft--;
    }

    public void printFilter(){
        System.out.println("     <!> filter status <!>");
        System.out.print("[");
        for (int i = 0; i<CAPACITY; i++){
            if(i<capacityLeft){System.out.print(" * ");}
            else {System.out.print(" - ");}
        }
        System.out.print("]");
    }
}
