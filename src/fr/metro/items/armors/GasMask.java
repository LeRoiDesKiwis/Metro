package fr.metro.items.armors;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Filter;

//Definition of our Gasmask Class, subclass of Armor, with a filter
public class GasMask extends Armor {
    private Filter filter;

    //Overrides use method
    @Override
    public void use(GameCharacter player){
        player.getInventory().getItemByType(ItemType.FILTER).ifPresentOrElse(item -> this.filter = (Filter)item, () -> System.out.println("No filter in inventory."));
        player.getInventory().removeItem(Filter.class);
    }

    //Gasmask constructor
    public GasMask(){
        super("Gas Mask", "Old gas mask built before the war", ItemType.ARMOR_HEAD);
        filter = new Filter();
    }

    //simple getter for the gasmask filter
    public Filter getFilter() {
        return filter;
    }
}
