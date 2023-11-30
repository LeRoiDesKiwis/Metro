package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.items.Item;

import java.util.Optional;
//Declaration of our CommandTake class
public class CommandTake extends Command {

    private final Player player;
    //Constructor of CommandTake
    public CommandTake(Player player) {
        super("add (if possible) the argument to the hero’s items", new CommandArgument("Item to be added"));
        this.player = player;
    }
    //Overrides execute to add item args[0] to player's inventory and delete from Location's inventory
    @Override
    public boolean execute(String[] args) {
        if(args.length == 0){
            System.out.println("Not enough arguments !");
            return false;
        }

        Optional<Item> itemOpt = player.getCurrentLocation().getItemByName(args[0]);
        itemOpt.ifPresentOrElse(item -> {
            player.addItem(item);
            player.getCurrentLocation().removeItem(item);
        }, () -> System.out.println("Item doesn't exist"));

        return itemOpt.isPresent();
    }
}
