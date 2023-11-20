package fr.metro.commands;

public class CommandHelp extends Command{

    private final CommandManager commandManager;

    public CommandHelp(CommandManager commandManager){
        super("show commands with their description");
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String[] args) {

        System.out.println("---- COMMANDS ----");
        System.out.println("NOTE: in usage, [] = optional and <> = required");
        commandManager.stream().forEach(entry -> {
            System.out.println("- "+entry.getKey());
            Command command = entry.getValue();
            System.out.println("\t- DESCRIPTION: "+ command.description);
            System.out.println("\t- USAGE: "+ entry.getKey()+" "+command.usage);
        });

        return true;
    }
}
