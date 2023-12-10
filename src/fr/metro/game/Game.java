package fr.metro.game;

import fr.metro.characters.Player;
import fr.metro.commands.Command;
import fr.metro.commands.manager.CommandManager;
import fr.metro.items.Filter;
import fr.metro.items.Item;
import fr.metro.items.armors.GasMask;

import java.util.Random;
import java.util.Scanner;

//Definition of our Game class, with a player, command manager, a random variable and a bool
//to keep track of if the game is running
public class Game {
    private final Player player;
    private final CommandManager commandManager;
    private final Random random = new Random();
    private boolean running = true;
    private final Scanner scanner;
    private Command.CommandStatus currentStatus;

    //Game constructor
    public Game(Scanner scanner, Player player) {
        this.player = player;
        this.commandManager = new CommandManager(player);
        this.scanner = scanner;
    }

    //method used to scan the user responses and redirect them to the execute method
    //in the Command Manager class
    public void askCommand(){
        System.out.print("Command >> ");
        while((currentStatus = commandManager.execute(scanner.nextLine())) == Command.CommandStatus.FAILED){
            System.out.println();
            System.out.print("Command failed, please retry : ");
        }
    }

    //method used to keep track of "turns", the attacks and the player's death
    public void tick(){
        if(currentStatus != Command.CommandStatus.UPDATE) {
            System.out.println("\n[INFO] You executed a non-update command, nothing happened.");
            return;
        }
        Location location = player.getCurrentLocation();
        location.streamCharacters().forEach(character -> {
            if(random.nextDouble() >= 0.2f) character.interact(player, new String[0]);
            else System.out.println(character+" missed his attack !");
        });
        location.cleanDeaths();
        player.getInventory().getArmor(Item.ItemType.ARMOR_HEAD).map(item -> (GasMask)item).ifPresent(mask -> {
            Filter filter = mask.getFilter();
            filter.useFilter();
            filter.printStatus();
            if(filter.isEmpty()) player.kill();
        });

        if(player.isDead()){
            running = false;
            System.out.println("GAME OVER :(");
        }
    }

    //displays informations about where the player currently is
    public void printInfos(){
        System.out.println(player +" | Location: "+player.getCurrentLocation());
    }


    //returns a true boolean if the game is running
    public boolean isRunning() {
        return running;
    }
}
