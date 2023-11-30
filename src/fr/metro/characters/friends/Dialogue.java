package fr.metro.characters.friends;

import java.util.HashMap;
import java.util.Map;

public class Dialogue {
    private final String question;
    private Map<String, Dialogue> continuity = new HashMap<>();
    private String unknownAnswer;

    private Dialogue(String question, Map<String, Dialogue> continuity, String error){
        this.question = question;
        this.continuity = continuity;
        this.unknownAnswer = error;
    }

    public Dialogue(String string){
        this.question = string;
    }

    @Override
    public String toString() {
        return question;
    }

    public Dialogue ask(String question){
        if(continuity.containsKey(question)) return continuity.get(question);
        else return new Dialogue(unknownAnswer);
    }

    public boolean hasNext() {
        return !continuity.isEmpty();
    }

    public static class DialogueBuilder {
        private String question;
        private final Map<String, Dialogue> continuity = new HashMap<>();
        private String error = "Wtf are you saying bro";

        public DialogueBuilder(String question){
            this.question = question;
        }

        public DialogueBuilder question(String question){
            this.question = question;
            return this;
        }

        public DialogueBuilder error(String error){
            this.error = error;
            return this;
        }

        public DialogueBuilder addQuestion(String question, DialogueBuilder dialogue){
            continuity.put(question, dialogue.build());
            return this;
        }

        public DialogueBuilder addFinalAnswer(String question, String answer){
            continuity.put(question, new Dialogue(answer));
            return this;
        }

        public Dialogue build(){
            return new Dialogue(question, continuity, error);
        }
    }

}
