package fr.metro.items;

public class Filter extends Item {
    private static final int CAPACITY = 10;
    private int capacityLeft;

    public Filter() {
        super("Allows you to breath the irradiated air", ItemType.FILTER);
        capacityLeft = CAPACITY;
    }

    public void useFilter() {
        this.capacityLeft--;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString() + ("\n     <!> filter status <!>\n"));
        s.append("[");
        for (int i = 0; i < CAPACITY; i++) {
            s.append(i < capacityLeft ? " * " : " - ");
        }
        s.append("]");
        return s.toString();

    }
}
