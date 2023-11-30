package fr.metro.items;

//Definition of our Filter class, subclass of Item, with a max capacity and a remaining capacity
public class Filter extends Item {
    private static final int CAPACITY = 10;
    private int capacityLeft;

    //Filter constructor
    public Filter() {
        super("Allows you to breath the irradiated air", ItemType.FILTER);
        capacityLeft = CAPACITY;
    }

    //Decreases the remaining capacity
    public void useFilter() {
        this.capacityLeft--;
    }

    //Checks if a filter is empty
    public boolean isEmpty(){
        return this.capacityLeft <= 0;
    }

    //prints the filter status
    public void printStatus() {
        StringBuilder s = new StringBuilder("\n     <!> filter status <!>\n");
        s.append("[");
        for (int i = 0; i < CAPACITY; i++) {
            s.append(i < capacityLeft ? " * " : " - ");
        }
        s.append("]");
        System.out.println(s);

    }
}
