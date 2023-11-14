package fr.metro.items;

public class GasMask extends Item {
    private Filter filter;
    public GasMask(){
        super("Gas Mask", "Old gas mask built before the war");
        filter = new Filter();
    }
}
