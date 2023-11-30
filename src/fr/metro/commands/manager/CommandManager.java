package fr.metro.commands.manager;

import fr.metro.characters.Player;
import fr.metro.commands.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Definition of our CommandManager class
public class CommandManager {

    private final Map<String, Command> commands = new HashMap<>();
    //Initialize CommandManager with all of our commands
    public CommandManager(Player player){
        commands.put("help", new CommandHelp(this));
        commands.put("look", new CommandLook(player));
        commands.put("attack", new CommandAttack(player));
        commands.put("take", new CommandTake(player));
        commands.put("use", new CommandUse(player));
        commands.put("quit", new CommandQuit(player));
        commands.put("talk", new CommandTalk(player));
        commands.put("go", new CommandGo(player));
    }
    //return stream of our Command
    public Stream<Map.Entry<String, Command>> stream(){
        return commands.entrySet().stream();
    }

   //execute the Command given in input, if found
    public boolean execute(String input){
        if(input.isBlank()) return false;
        if(input.contains(" && ")){
            String[] commands = input.split(" && ");
            for(String command : commands){
                if(!execute(command)) return false;
            }
            return true;
        }
        System.out.println();
        String[] split = input.split(" ");
        String commandName = split[0].toLowerCase();
        List<String> possibleCommands = getCommand(commandName);
        switch (possibleCommands.size()) {
            case 0 -> {
                System.out.printf("Command %s not found !\n", commandName);
                return false;
            }
            case 1 -> {
                Command command = commands.get(possibleCommands.get(0));
                String[] args = new String[split.length - 1];
                System.arraycopy(split, 1, args, 0, args.length);
                return command.execute(args);
            }
            default -> {
                System.out.println("Commands starting with \"" + commandName + "\":");
                possibleCommands.forEach(string -> System.out.println("- " + string));
            }
        }

        return false;
    }
    //return list of command matching name
    public List<String> getCommand(String name){
        return commands.keySet().stream().filter(command -> command.startsWith(name)).collect(Collectors.toList());
    }

}
