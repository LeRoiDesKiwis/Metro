package fr.metro.commands;

public abstract class Command {

    protected final String description;
    protected final String usage;

    public Command(String description, String usage) {
        this.description = description;
        this.usage = usage;
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
