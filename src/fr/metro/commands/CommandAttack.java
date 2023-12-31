package fr.metro.commands;

import fr.metro.characters.GameCharacter;
import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandArgument;

import java.util.Optional;
//Declaration of our CommandAttack class
public class CommandAttack extends Command {

    private final Player player;
    //Constructor of CommandAttack
    public CommandAttack(Player player) {
        super("Attack a NPC", new CommandArgument("name of a npc"), new CommandArgument("weapon to use (fist by default)", CommandArgument.ArgumentType.OPTIONAL));
        this.player = player;
    }
    //Overrides execute to attack the GameCharacter in args[0] with weapon in args[1]
    @Override
    public CommandStatus execute(String[] args) {
        if(args.length == 0){
            System.out.println("Not enough arguments !");
            return CommandStatus.FAILED;
        }
        String weaponName;
        if(args.length > 1){
            if(!player.hasItem(args[1])) {
                System.out.println("Player doesn't have the weapon "+ args[1] +" !");
                return CommandStatus.FAILED;
            } else weaponName = args[1];
        } else weaponName = "";
        Optional<GameCharacter> character1 = player.getCurrentLocation().getCharacterByName(args[0]);
        character1.ifPresentOrElse(character -> player.attack(character, weaponName), () -> System.out.println("Character "+args[0]+" doesn't exist !"));
        return CommandStatus.failOr(character1.isPresent(), CommandStatus.UPDATE);
    }
}
