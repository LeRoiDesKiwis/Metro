package fr.metro.characters.friends;

import fr.metro.characters.Inventory;
import fr.metro.characters.Player;

public class SpeakingNPC extends FriendlyCharacter{

    private final Dialogue startDialogue;
    private Dialogue current;

    public SpeakingNPC(String name, int hp, Inventory inventory, String introductionLine, Dialogue dialogue) {
        super(name, hp, inventory, introductionLine);
        this.startDialogue = dialogue;
        this.current = startDialogue;
    }

    @Override
    public void interact(Player player, String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg).append(" ");
        }
        current = current.ask(stringBuilder.toString().trim());
        System.out.println(current);
    }

    @Override
    public void introduce(Player player) {
        super.introduce(player, current.toString());
    }

    public void reset(Player player){
        current = startDialogue;
        introduce(player);
    }

    public boolean hasNext() {
        return current.hasNext();
    }
}
