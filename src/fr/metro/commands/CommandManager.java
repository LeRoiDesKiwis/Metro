package fr.metro.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CommandManager {

    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager(){
        commands.put("help", new CommandHelp(this));
        commands.put("look", new CommandLook());
        commands.put("attack", new CommandAttack());
        commands.put("take", new CommandTake());
        commands.put("use", new CommandUse());
        commands.put("quit", new CommandQuit());
    }

    public Stream<Map.Entry<String, Command>> stream(){
        return commands.entrySet().stream();
    }

    /**
     * @param input User input (commandName + args)
     * @return if the command succeeded or not
     */
    public boolean execute(String input){
        String[] split = input.split(" ");
        String commandName = split[0];
        if(commands.containsKey(commandName)) {
            Command command = commands.get(commandName);

            String[] args = new String[split.length - 1];
            System.arraycopy(split, 1, args, 0, args.length);

            return command.execute(args);
        }
        System.out.printf("Command %s not found !\n", commandName);
        return false;
    }

}
