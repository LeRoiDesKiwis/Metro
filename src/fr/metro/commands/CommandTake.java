package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;

public class CommandTake extends Command {
    public CommandTake() {
        super("add (if possible) the argument to the hero’s items", new CommandArgument("Item to be added"));
    }

    @Override
    public boolean execute(String[] args) {

        return false;
    }
}
