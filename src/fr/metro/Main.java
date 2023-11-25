package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.game.Board;
import fr.metro.game.Exit;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.items.Key;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String name;
        if(args.length > 0){
            name = args[0];
            System.out.println("Username detected : "+name);
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("What's your name ? ");
            name = scanner.nextLine();
            System.out.println();
        }

        Location loc2 = new Location("Salle 2");
        Exit exit = new Exit(loc2);
        Map<String, Exit> exits = new HashMap<>();
        exits.put("Sortie1", exit);
        Location loc1 = new Location(new ArrayList<>(), new ArrayList<>(), exits, "Salle 1");

        Game game = new Game(new Player(name, 10, new Inventory( new Key()),loc1), new Board());
        while(true) {
            game.player.getCurrentLocation().printLocation();
            game.tick();

        }
    }
}
