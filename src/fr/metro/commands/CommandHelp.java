package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;
import fr.metro.commands.manager.CommandManager;

import java.util.Map;
import java.util.Optional;
//Declaration of our CommandHelp class
public class CommandHelp extends Command{

    private final CommandManager commandManager;
    //constructor of Command Help
    public CommandHelp(CommandManager commandManager){
        super("show commands with their description", new CommandArgument("command", CommandArgument.ArgumentType.OPTIONAL));
        this.commandManager = commandManager;
    }
    //Print example of how to use command
    private void printExample(Command command) {
        if(command.example.isBlank()) return;
        System.out.println("\t- EXAMPLE: "+command.example);
    }
    //Print command name and arguments
    private void printUsage(String commandName, Command command){
        if(command.arguments.length == 0) return;
        StringBuilder stringBuilder = new StringBuilder();
        for (CommandArgument argument : command.arguments) {
            stringBuilder.append(argument).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println("\t- USAGE: " + commandName + " " + stringBuilder);
    }
    //Print description of CommandHelp
    private void helpCommand(String commandName, Command command){
        System.out.println("- " + commandName);
        System.out.println("\t- DESCRIPTION: " + command.description);
        printUsage(commandName, command);
        printExample(command);
    }
    //Overrides execute to print commands documentation
    @Override
    public CommandStatus execute(String[] args) {

        if(args.length == 0) {

            System.out.println("---- COMMANDS ----");
            StringBuilder builder = new StringBuilder();
            for (CommandArgument.ArgumentType argumentType : CommandArgument.ArgumentType.values()) {
                builder.append(argumentType.start).append(argumentType.end).append(" = ").append(argumentType.toString().toLowerCase()).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            System.out.println("NOTE: in usage, " + builder);

            commandManager.stream().forEach(entry -> helpCommand(entry.getKey(), entry.getValue()));
            return CommandStatus.SUCCESS;
        } else {
            String commandName = args[0];
            Optional<Command> commandOpt = commandManager.stream().filter(entry -> entry.getKey().equals(commandName)).map(Map.Entry::getValue).findAny();
            commandOpt.ifPresent(command -> helpCommand(commandName, command));
            return CommandStatus.failOr(commandOpt.isPresent(), CommandStatus.SUCCESS);
        }

    }
}
