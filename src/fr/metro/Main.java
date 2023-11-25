package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.characters.friends.FriendlyCharacter;
import fr.metro.game.Board;
import fr.metro.game.Exit;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.items.Key;
import fr.metro.game.exits.LockedExit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name ? ");
        String name = scanner.nextLine();
        System.out.println();

        Location loc2 = new Location("Salle 2");
        Exit exit = new Exit(loc2);
        Map exits = new HashMap<String,Exit>();
        exits.put("Sortie1", exit);
        Location loc1 = new Location(new ArrayList<>(), new ArrayList<>(), exits, "Salle 1");

        Game game = new Game(new Player(name, 10, new Inventory( new Key()),loc1), new Board());
        while(true) {
            game.player.getCurrentLocation().printLocation();
            game.tick();

        }
    }
}
