package fr.metro.commands;

import fr.metro.characters.Player;
//Declaration of our CommandQuit class
public class CommandQuit extends Command {

    private final Player player;
    //Constructor of CommandQuit
    public CommandQuit(Player player) {
        super("quit the game");
        this.player = player;
    }
    //Overrides execute to quit the game
    @Override
    public boolean execute(String[] args) {
        System.out.printf("Good bye %s :'(", player);
        System.exit(0);
        return true;
    }
}
