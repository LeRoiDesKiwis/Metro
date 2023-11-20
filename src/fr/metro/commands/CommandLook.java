package fr.metro.commands;

public class CommandLook extends Command {

    public CommandLook() {
        super("Displays a description of the current location or any arguments that can be observed.", new CommandArgument("what we want to observe", CommandArgument.ArgumentType.OPTIONAL));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
