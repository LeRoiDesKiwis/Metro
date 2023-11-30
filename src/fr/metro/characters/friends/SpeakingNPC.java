package fr.metro.characters.friends;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;
import fr.metro.game.Location;

import java.util.Scanner;

//Definition of our SpeakingNPC class, subclass of FriendlyCharacter, with a dialogue and possibility for a scanner
public class SpeakingNPC extends FriendlyCharacter{

    private final Dialogue startDialogue;
    private Scanner scanner;

    //SpeakingNPC constructor
    public SpeakingNPC(Scanner scanner, String name, int hp, Inventory inventory, String introductionLine, Dialogue dialogue) {
        super(name, hp, inventory, introductionLine);
        this.startDialogue = dialogue;
        this.scanner = scanner;
    }

    //Overrides method talk from mother class FriendlyCharacter
    //uses a scanner to identify the right answers needed
    @Override
    public void talk(Player player) {
        Dialogue current = startDialogue;
        while(current.hasNext()){
            System.out.println(super.name+": "+current);
            System.out.print(player+": ");
            String answer = scanner.nextLine();
            current = current.ask(answer);

        }
        System.out.println(super.name+": "+current);
    }
}
