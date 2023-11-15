package fr.metro.characters.friends;

import java.util.HashMap;
import java.util.Map;

public class Narration {

    private final String question;
    private Map<String, Narration> continuity = new HashMap<>();
    private String unknownAnswer;

    public Narration(String question, Map<String, Narration> continuity, String error){
        this.question = question;
        this.continuity = continuity;
        this.unknownAnswer = error;
    }

    public Narration(String string){
        this.question = string;
    }

    @Override
    public String toString() {
        return question;
    }

    public Narration ask(String question){
        if(continuity.containsKey(question)) return continuity.get(question);
        else return new Narration(unknownAnswer);
    }

    public boolean hasNext() {
        return !continuity.isEmpty();
    }

    public static class NarrationBuilder{
        private String question;
        private final Map<String, Narration> continuity = new HashMap<>();
        private String error = "Wtf are you saying bro";

        public NarrationBuilder(String question){
            this.question = question;
        }
        public NarrationBuilder(){
        }

        public NarrationBuilder question(String question){
            this.question = question;
            return this;
        }

        public NarrationBuilder error(String error){
            this.error = error;
            return this;
        }

        public NarrationBuilder addQuestion(String question, Narration narration){
            continuity.put(question, narration);
            return this;
        }

        public NarrationBuilder addFinalAnswer(String question, String answer){
            continuity.put(question, new Narration(answer));
            return this;
        }

        public Narration build(){
            return new Narration(question, continuity, error);
        }
    }

}
