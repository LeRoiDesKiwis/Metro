package fr.metro.commands;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.game.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

//Declaration of our CommandLook class
public class CommandLook extends Command {

    private final Player player;
    private Map<String, Consumer<Location>> arguments = new HashMap<>();

    //CommandLook constructor
    public CommandLook(Player player) {
        super("Displays a description of the current location or any arguments that can be observed.", new CommandArgument("what we want to observe (items/pnjs)", CommandArgument.ArgumentType.OPTIONAL));
        this.player = player;
        arguments.put("pnjs", Location::showCharacters);
        arguments.put("items", Location::showItems);
        arguments.put("exits", Location::showExits);
        arguments.put("all", location -> arguments.forEach((key, value) -> {
            if(!key.equals("all")) {
                value.accept(location);
                System.out.println();
            }
        }));
    }
    //Overrides execute to print items, characters and exits in the player's location
    @Override
    public boolean execute(String[] args) {
        Location location = player.getCurrentLocation();
        if(args.length == 0 || !arguments.containsKey(args[0])){
            System.out.println("Arguments available for this command:");
            arguments.forEach((key, value) -> System.out.println("\t- "+key));
            return true;
        }

        arguments.get(args[0]).accept(location);

        return true;
    }
}
