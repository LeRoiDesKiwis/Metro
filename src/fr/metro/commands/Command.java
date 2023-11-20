package fr.metro.commands;

public abstract class Command {

    protected final String description;
    protected final CommandArgument[] arguments;

    public Command(String description, CommandArgument... arguments) {
        this.description = description;
        this.arguments = arguments;
    }

    public Command(String description){
        this(description, new CommandArgument[]{});
    }

    /**
     *
     * @param args command arguments (example : ATTACK name weapon : name and weapon are the arguments)
     * @return if the command succeeded or not
     */
    public abstract boolean execute(String[] args);

}
