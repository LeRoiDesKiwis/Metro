package fr.metro.items;

public class GasMask extends Armor {
    private Filter filter;
    public GasMask(){
        super("Gas Mask", "Old gas mask built before the war", 0);
        filter = new Filter();
    }
}
