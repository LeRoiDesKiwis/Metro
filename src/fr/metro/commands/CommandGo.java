package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;

public class CommandGo extends Command{
    private final Player player ;

    public CommandGo(Player player) {
        super("Move to another room", new CommandArgument("name of an exit"));
        this.player = player ;
    }
    @Override
    public boolean execute(String[] args) {
        if(args.length == 0){
            System.out.println("Not enough arguments");
            return false;
        }
        player.move(args[0]);
        return true ;
    }
}