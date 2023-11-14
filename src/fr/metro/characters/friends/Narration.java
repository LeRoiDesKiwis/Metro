package fr.metro.characters.friends;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Narration {

    private String question;
    private Map<String, Narration> continuity = new HashMap<>();
    private String unknownAnswer = "Wtf are you saying bro";

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

    public static class NarrationBuilder{
        private String question;
        private Map<String, Narration> continuity = new HashMap<>();
        private String error;

        public NarrationBuilder(String question){
            this.question = question;
        }

        public NarrationBuilder unknownAnswer(String error){
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
