package fr.metro.commands;

public class CommandTake extends Command {
    public CommandTake() {
        super("add (if possible) the argument to the hero’s items", new CommandArgument("Item to be added"));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
