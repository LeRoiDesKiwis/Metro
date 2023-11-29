package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.characters.enemies.Enemy;
import fr.metro.characters.friends.FriendlyCharacter;
import fr.metro.characters.friends.SpeakingNPC;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.game.exits.FinalExit;
import fr.metro.game.exits.LockedExit;
import fr.metro.items.Key;
import fr.metro.items.foods.CannedFood;
import fr.metro.items.foods.Mushroom;
import fr.metro.items.weapons.Knife;
import fr.metro.items.weapons.Pistol;
import fr.metro.items.weapons.Riffle;
import fr.metro.items.Filter;

import java.util.List;
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

        Location location = new Location.LocationBuilder("Sokol", "every story need a beginning")
                .addItem(new Key())
                .addCharacter(new Enemy("Piotr, lonely survivor", 5, new Inventory(List.of(new Knife()))))
                .addExit(LockedExit.class, new Location.LocationBuilder("Dynamo", "an old metro station, looks clear")
                        .addExit(new Location.LocationBuilder("Amino", "used to be crowded with mutated creatures").addItem(new Key())) .addCharacter(new Enemy("mutated USSR Soldier", 10, new Inventory(List.of(new Pistol()))))
                        .addExit(new Location.LocationBuilder("Dostoievski", "an old Red Line Reserve").addItem(new Filter()).addItem(new CannedFood()).addItem(new Mushroom())
                                .addExit(new Location.LocationBuilder("Park Kultury", "used to be gorgeous now every last plant is rotten")
                                        .addExit(LockedExit.class, new Location.LocationBuilder("Armory", "secret hideout, I hope no one is going to miss these weapons").addItem(new Riffle()).addItem(new Pistol()))
                                )
                                        .addExit(new Location.LocationBuilder("Polis", "finally some relief").addItem(new Filter()).addCharacter(new FriendlyCharacter("Anton", 10, new Inventory(), "Hello, friend") {
                                                })
                                                .addExit(FinalExit.class, new Location.LocationBuilder("final")))
                        )
                ).build();

        Game game = new Game(new Player(name, 20, location));

        while(game.isRunning()) {
            System.out.println();
            game.printInfos();
            game.askCommand();
            game.tickEnemies();
        }
    }
}
