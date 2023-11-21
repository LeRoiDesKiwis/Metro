package fr.metro.commands;

import fr.metro.characters.Player;

public class CommandQuit extends Command {

    private Player player;

    public CommandQuit(Player player) {
        super("quit the game");
        this.player = player;
    }

    @Override
    public boolean execute(String[] args) {
        System.out.printf("Good bye %s :'(", player);
        System.exit(0);
        return true;
    }
}
