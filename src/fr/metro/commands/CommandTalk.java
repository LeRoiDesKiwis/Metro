package fr.metro.commands;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;
import fr.metro.game.Location;

import java.util.Optional;

public class CommandTalk extends Command {

    private Player player;

    public CommandTalk(Player player) {
        super("talk to a NPC", new CommandArgument("The NPC you want to talk to"));
        this.player = player;
    }

    @Override
    public boolean execute(String[] args) {
        if(args.length == 0) {
            System.out.println("Error: you must provide the npc's name !");
            return false;
        }
        Location currentLocation = player.getCurrentLocation();
        Optional<GameCharacter> character = currentLocation.getCharacterByName(args[0]);
        character.ifPresentOrElse(character1 -> character1.talk(player), () -> System.out.println("Error: NPC not found"));
        return character.isPresent();
    }
}