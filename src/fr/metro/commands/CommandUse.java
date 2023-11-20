package fr.metro.commands;

public class CommandUse extends Command {
    public CommandUse() {
        super("uses the object arg1. In case a second argument is given, the first one is used with the second. For example, use gun bullet may load the gun, which can be used after that.",
                "use gun bullet may load the gun, which can be used after that.",
                new CommandArgument("item"), new CommandArgument("item to be used with the first", CommandArgument.ArgumentType.OPTIONAL));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
