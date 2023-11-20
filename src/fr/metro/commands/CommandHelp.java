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
        StringBuilder builder = new StringBuilder();
        for(CommandArgument.ArgumentType argumentType : CommandArgument.ArgumentType.values()){
            builder.append(argumentType.start).append(argumentType.end).append(" = ").append(argumentType.toString().toLowerCase()).append(" ");
        }
        System.out.println("NOTE: in usage, "+ builder);

        commandManager.stream().forEach(entry -> {
            System.out.println("- "+entry.getKey());
            Command command = entry.getValue();
            System.out.println("\t- DESCRIPTION: "+ command.description);
            if(command.arguments.length == 0) return;
            StringBuilder usage = new StringBuilder();
            for(CommandArgument argument : command.arguments){
                usage.append(argument).append(" ");
            }
            System.out.println("\t- USAGE: "+ entry.getKey()+" "+usage);
        });

        return true;
    }
}
