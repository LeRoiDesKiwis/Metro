package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.items.Item;
import fr.metro.items.armors.GasMask;

import java.util.Optional;

public class CommandUse extends Command {

    private final Player player;

    public CommandUse(Player player) {
        super("uses the object arg1. In case a second argument is given, the first one is used with the second. For example, use gun bullet may load the gun, which can be used after that.",
                "use gun bullet may load the gun, which can be used after that.",
                new CommandArgument("item"), new CommandArgument("item to be used with the first", CommandArgument.ArgumentType.OPTIONAL));
        this.player = player;
    }

    @Override
    public boolean execute(String[] args) {
        if(args.length == 0) {
            player.showInventory();
            return true;
        }
        if(args[0].equalsIgnoreCase("filter")){
            player.getInventory().getGasMask().use(player);
            return true ;
        }
        Optional<Item> opt = player.getInventory().getItemByName(args[0]);
        opt.filter(item -> item.isType(Item.ItemType.FOOD)).ifPresent(item -> item.use(player));

        return opt.isPresent();
    }
}
