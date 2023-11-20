package fr.metro.commands;

public class CommandHelp extends Command{

    private final CommandManager commandManager;

    public CommandHelp(CommandManager commandManager){
        super("show commands with their description", "help");
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String[] args) {

        System.out.println("---- COMMANDS ----");
        commandManager.stream().forEach(entry -> {
            System.out.println("- "+entry.getKey());
            Command command = entry.getValue();
            System.out.println("\t- DESCRIPTION: "+ command.description);
            System.out.println("\t- USAGE: "+ command.usage);
        });

        return true;
    }
}
