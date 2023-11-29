package fr.metro.items.armors;

import fr.metro.characters.GameCharacter;
import fr.metro.items.Filter;

public class GasMask extends Armor {
    private Filter filter;
    @Override
    public void use(GameCharacter player){
        player.getInventory().getItemByType(ItemType.FILTER).ifPresentOrElse(item -> this.filter = (Filter)item, () -> System.out.println("No filter in inventory."));
        player.getInventory().removeItem(Filter.class);
    }
    public GasMask(){
        super("Gas Mask", "Old gas mask built before the war", ItemType.ARMOR_HEAD);
        filter = new Filter();
    }

    public Filter getFilter() {
        return filter;
    }
}
