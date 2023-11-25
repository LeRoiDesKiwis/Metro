package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;
import fr.metro.game.Exit ;
import fr.metro.characters.Player;

public class CommandGo extends Command{
    private Player player ;

    public CommandGo(Player player) {
        super("Move to another room", new CommandArgument("name of an exit"));
        this.player = player ;
    }
    @Override
    public boolean execute(String[] args) {
        player.getCurrentLocation().getExit(args[0]).move(player);
        return true ;
    }
}
