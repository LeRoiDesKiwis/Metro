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

    /**
     * Execute the command
     * @param args list of command argument, without the command name
     * @return the status of the command
     * @see CommandStatus
     */
    public abstract CommandStatus execute(String[] args);

    /**
     * Enum representing the status of a command.
     */
    public enum CommandStatus {

        /**
         * Indicates that the command has failed.
         */
        FAILED,

        /**
         * Indicates that the command was successful. <b>Will not update the game.</b>
         */
        SUCCESS,

        /**
         * Indicates that the command was successful, and ask to update the game.
         */
        UPDATE;

        /**
         * A utility method that returns the specified status if the condition is true, otherwise returns {@link #FAILED}.
         *
         * @param check The condition to check.
         * @param or    The status to return if the condition is true.
         * @return The specified status if the condition is true, otherwise {@link #FAILED}.
         */
        public static CommandStatus failOr(boolean check, CommandStatus or) {
            return check ? or : FAILED;
        }

        public static CommandStatus highest(CommandStatus status, CommandStatus status1) {
            return status.ordinal() > status1.ordinal() ? status : status1;
        }
    }

}
