package fr.metro.commands;

public abstract class Command {

    protected final String description;
    protected final CommandArgument[] arguments;
    protected String example;

    public Command(String description, String example, CommandArgument... arguments) {
        this.description = description;
        this.arguments = arguments;
        this.example = example;
    }

    public Command(String description, CommandArgument... arguments){
        this(description, "", arguments);
    }

    public Command(String description){
        this(description, "");
    }

    /**
     *
     * @param args command arguments (example : ATTACK name weapon : name and weapon are the arguments)
     * @return if the command succeeded or not
     */
    public abstract boolean execute(String[] args);

}
