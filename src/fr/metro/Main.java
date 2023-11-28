package fr.metro;

import fr.metro.characters.Player;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.game.exits.FinalExit;
import fr.metro.game.exits.LockedExit;
import fr.metro.items.Key;

import java.util.Scanner;

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

        Location location = new Location.LocationBuilder("Sokoi", "uwu")
                .addItem(new Key())
                .addExit(LockedExit.class, new Location.LocationBuilder("Dinamo")
                        .addExit(new Location.LocationBuilder("Amino"))
                        .addExit(new Location.LocationBuilder("Dostoievski")
                                .addExit(new Location.LocationBuilder("Park Kultuty")
                                        .addExit(LockedExit.class, new Location.LocationBuilder("Armory"))
                                )
                                        .addExit(new Location.LocationBuilder("Polis")
                                                .addExit(FinalExit.class, new Location.LocationBuilder("final")))
                        )
                ).build();

        Game game = new Game(new Player(name, 20, location));

        while(game.isRunning()) {
            System.out.println("\n---------");
            game.printInfos();
            game.askCommand();
        }
    }
}
