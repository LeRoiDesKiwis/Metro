package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.game.Location;

public class CommandLook extends Command {

    private Player player;

    public CommandLook(Player player) {
        super("Displays a description of the current location or any arguments that can be observed.", new CommandArgument("what we want to observe (items/pnjs)", CommandArgument.ArgumentType.OPTIONAL));
        this.player = player;
    }

    @Override
    public boolean execute(String[] args) {
        Location location = player.getCurrentLocation();
        if(args.length == 0){
            location.showCharacters();
            System.out.println();
            location.showItems();
            System.out.println();
            location.showExits();
            return true;
        }

        switch(args[0]){
            case "pnjs" -> location.showCharacters();
            case "items" -> location.showItems();
            case "exits" -> location.showExits();
            default -> {
                System.out.println(args[0] +" isn't a valid argument");
                return false;
            }
        }
        return true;
    }
}
