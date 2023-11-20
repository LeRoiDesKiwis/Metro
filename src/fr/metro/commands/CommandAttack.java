package fr.metro.commands;

import fr.metro.commands.manager.CommandArgument;

public class CommandAttack extends Command {
    public CommandAttack() {
        super("Attack a NPC", new CommandArgument("name of a npc"));
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
