package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;

//Description of our Command class, with a command description, a command argument and an example
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

    public abstract boolean execute(String[] args);

}
