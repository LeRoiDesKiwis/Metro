package fr.metro;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.characters.enemies.Enemy;
import fr.metro.characters.friends.Dialogue;
import fr.metro.characters.friends.SpeakingNPC;
import fr.metro.game.Game;
import fr.metro.game.Location;
import fr.metro.game.exits.FinalExit;
import fr.metro.game.exits.LockedExit;
import fr.metro.items.Filter;
import fr.metro.items.Key;
import fr.metro.items.foods.CannedFood;
import fr.metro.items.foods.Mushroom;
import fr.metro.items.weapons.Knife;
import fr.metro.items.weapons.Pistol;
import fr.metro.items.weapons.Riffle;

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
                .addCharacter(new SpeakingNPC(new Scanner(System.in), "Anna", 10, new Inventory(),"Hello" + name, new Dialogue.DialogueBuilder("I feel a perturbation in the metro").addFinalAnswer("Where are we ?", "We are in the Moscow underground metro").addFinalAnswer("What is going on ?", "The rats they're coming this way").addFinalAnswer("What should I do", "You need to go, fast.").build()))
                .addExit(LockedExit.class, new Location.LocationBuilder("Dynamo", "an old metro station, looks clear")
                        .addExit(new Location.LocationBuilder("Amino", "used to be crowded with mutated creatures").addItem(new Key())) .addCharacter(new Enemy("mutated USSR Soldier", 10, new Inventory(List.of(new Pistol()))))
                        .addExit(new Location.LocationBuilder("Dostoievski", "an old Red Line Reserve").addItem(new Filter()).addItem(new CannedFood()).addItem(new Mushroom())
                                .addExit(new Location.LocationBuilder("Park Kultury", "used to be gorgeous now every last plant is rotten")
                                        .addExit(LockedExit.class, new Location.LocationBuilder("Armory", "secret hideout, I hope no one is going to miss these weapons").addItem(new Riffle()).addItem(new Pistol()))
                                )
                                        .addExit(new Location.LocationBuilder("Polis", "finally some relief").addItem(new Filter())
                                                .addExit(FinalExit.class, new Location.LocationBuilder("Outdoor", "feel the fresh irradiated air")))
                        )
                ).build();

        Game game = new Game(new Player(name, 20, location));

        while(game.isRunning()) {
            System.out.println();
            game.printInfos();
            game.askCommand();
            game.tick();
        }
    }
}
