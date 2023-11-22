package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.characters.friends.FriendlyCharacter;
import fr.metro.game.Board;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.items.Key;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name ? ");
        String name = scanner.nextLine();
        System.out.println();
        Game game = new Game(new Player(name, 10, new Inventory( new Key()),  new Location(List.of(), List.of(new FriendlyCharacter("r", 10, null, "yo [player]") {
        }), Map.of())), new Board());
        while(true) {
            game.tick();
        }
    }
}
