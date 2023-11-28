package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.items.Item;

import java.util.Optional;

public class CommandTake extends Command {

    private final Player player;

    public CommandTake(Player player) {
        super("add (if possible) the argument to the hero’s items", new CommandArgument("Item to be added"));
        this.player = player;
    }

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
