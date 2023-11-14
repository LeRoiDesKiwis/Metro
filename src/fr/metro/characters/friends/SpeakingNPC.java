package fr.metro.characters.friends;

import fr.metro.characters.Inventory;

public class SpeakingNPC extends FriendlyCharacter{

    private Narration narration;

    public SpeakingNPC(String name, int hp, Inventory inventory, String introductionLine, Narration narration) {
        super(name, hp, inventory, introductionLine);
    }
}
