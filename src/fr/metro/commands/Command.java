package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;

//Description of our abstract Command class, with a command description, a command argument and an example
public abstract class Command {
    protected final String description;
    protected final CommandArgument[] arguments;
    protected String example;
    //Command constructor with example and arguments
    public Command(String description, String example, CommandArgument... arguments) {
        this.description = description;
        this.arguments = arguments;
        this.example = example;
    }
    //Command constructor with arguments
    public Command(String description, CommandArgument... arguments){
        this(description, "", arguments);
    }
    //Command constructor with only description
    public Command(String description){
        this(description, "");
    }
    //Declaration of method execute that will be override in subclass
    public abstract boolean execute(String[] args);

}
