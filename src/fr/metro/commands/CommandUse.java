package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;

public class CommandUse extends Command {

    private Player player;

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
        return false;
    }
}
