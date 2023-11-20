package fr.metro.commands;

public class CommandLook extends Command {

    public CommandLook() {
        super("displays a description of the the current location if no argument is given. In case a list of arguments is provided, a display of all arguments that can be observed is given.", new CommandArgument("what we want to observe", CommandArgument.ArgumentType.OPTIONAL));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
