package fr.metro.game;

import fr.metro.characters.Player;
import fr.metro.commands.manager.CommandManager;

import java.util.Scanner;

public class Game {

    private final Player player;
    private final Board board;
    private final CommandManager commandManager;

    public Game(Player player, Board board) {
        this.player = player;
        this.board = board;
        this.commandManager = new CommandManager(player);
    }

    public void askCommand(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Command: ");
        while(!commandManager.execute(scanner.nextLine())){
            System.out.println();
            System.out.print("Command failed, please retry : ");
        }
    }

    public void printInfos(){
        player.getCurrentLocation().print();
    }

    /**
     * Check if the game is running or finished
     * @return true if the game is running and false is the game is finished
     */
    public boolean isRunning() {
        return true;
    }
}
