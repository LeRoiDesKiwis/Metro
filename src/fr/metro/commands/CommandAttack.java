package fr.metro.commands;

public class CommandAttack extends Command {
    public CommandAttack() {
        super("Attack a NPC", new CommandArgument("name of a npc"));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
