package fr.metro.game;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandManager;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Player player;
    private final CommandManager commandManager;
    private final Random random = new Random();

    public Game(Player player) {
        this.player = player;
        this.commandManager = new CommandManager(player);
    }

    public void askCommand(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Command >> ");
        while(!commandManager.execute(scanner.nextLine())){
            System.out.println();
            System.out.print("Command failed, please retry : ");
        }
    }

    public void tickEnemies(){
        Location location = player.getCurrentLocation();
        location.streamCharacters().forEach(character -> {
            if(random.nextDouble() >= 0.2f) character.interact(player, new String[0]);
            else System.out.println(character+" missed his attack !");
        });
    }

    public void printInfos(){
        System.out.println("Location: "+player.getCurrentLocation());
    }

    /**
     * Check if the game is running or finished
     * @return true if the game is running and false is the game is finished
     */
    public boolean isRunning() {
        return true;
    }
}
