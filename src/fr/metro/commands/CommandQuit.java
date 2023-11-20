package fr.metro.commands;

public class CommandQuit extends Command {
    public CommandQuit() {
        super("quit the game");
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
