package fr.metro.commands;

public abstract class Command {

    protected final String description;
    protected final String usage;

    /**
     * @param description : what is the command for ?
     * @param usage : how to use it ?
     */
    public Command(String description, String usage) {
        this.description = description;
        this.usage = usage;
    }

    /**
     *
     * @param args command arguments (example : ATTACK name weapon : name and weapon are the arguments)
     * @return if the command succeeded or not
     */
    public abstract boolean execute(String[] args);

}
