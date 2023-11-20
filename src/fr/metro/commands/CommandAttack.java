package fr.metro.commands;

public class CommandAttack extends Command {
    public CommandAttack() {
        super("attack a npc", new CommandArgument("name of a npc"));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
