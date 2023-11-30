package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
//Declaration of our CommandGo class
public class CommandGo extends Command{
    private final Player player ;
    //Constructor of CommandGo
    public CommandGo(Player player) {
        super("Move to another room", new CommandArgument("name of an exit", CommandArgument.ArgumentType.OPTIONAL));
        this.player = player ;
    }
    //Overrides execute to move character by args[0] exit if he can open the exit
    @Override
    public boolean execute(String[] args) {
        if(args.length == 0){
            System.out.println("List of exists you can go :");
            player.getCurrentLocation().exitNames().forEach(exit -> System.out.println("\t- "+exit));
            return false;
        }
        String name = args[0].toLowerCase();
        if(!player.canMove(name)){
            System.out.println("Can't move here !");
            return false;
        }
        System.out.print("Moved from "+player.getCurrentLocation());
        player.move(name);
        System.out.println(" to "+player.getCurrentLocation());
        return true ;
    }
}
