package fr.metro.commands;

public class CommandAttack extends Command {
    public CommandAttack() {
        super("attack a npc", "<name of the npc>");
    }

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}
