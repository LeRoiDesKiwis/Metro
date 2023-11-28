package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.characters.friends.SpeakingNPC;
import fr.metro.game.Board;
import fr.metro.game.Exit;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.game.exits.LockedExit;
import fr.metro.items.Key;
import fr.metro.items.weapons.Knife;

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

        Location loc2 = new Location("Salle 2", "La salle uwu");
        Exit exit = new Exit(loc2);
        Map<String, Exit> exits = new HashMap<>();
        exits.put("Sortie1", exit);
        Location loc1 = new Location("Salle 1", "la salle kawaii", new ArrayList<>(), List.of(new SpeakingNPC(null, "yo", 10, null, "owo", null)), exits);

        Game game = new Game(new Player(name, 10, new Inventory( new Key()),loc1), new Board());
        while(game.isRunning()) {
            System.out.println("\n---------");
            game.printInfos();
            game.askCommand();
        }
    }
}
