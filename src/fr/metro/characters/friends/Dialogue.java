package fr.metro.characters.friends;

import java.util.HashMap;
import java.util.Map;

//Defintion of our Dialogue class with a question, a hashmap linking a String with a Dialogue and
//an error message
public class Dialogue {
    private final String question;
    private Map<String, Dialogue> continuity = new HashMap<>();
    private String unknownAnswer;
    //Dialogue constructor
    private Dialogue(String question, Map<String, Dialogue> continuity, String error){
        this.question = question;
        this.continuity = continuity;
        this.unknownAnswer = error;
    }
    //Dialogue constructor without hashmap and error message
    public Dialogue(String string){
        this.question = string;
    }
    //override of toString method
    @Override
    public String toString() {
        return question;
    }
    //method that find a matching key in the hashmap with the given string
    public Dialogue ask(String question){
        if(continuity.containsKey(question)) return continuity.get(question);
        else return new Dialogue(unknownAnswer);
    }
    //checks continuity
    public boolean hasNext() {
        return !continuity.isEmpty();
    }
    //definition of DialogueBuilder class
    public static class DialogueBuilder {
        private String question;
        private final Map<String, Dialogue> continuity = new HashMap<>();
        private String error = "Sorry I didn't understand that.";
        //constructor of a DialogueBuilder from a string
        public DialogueBuilder(String question){
            this.question = question;
        }
        //modifies question string
        public DialogueBuilder question(String question){
            this.question = question;
            return this;
        }
        //modifies error string
        public DialogueBuilder error(String error){
            this.error = error;
            return this;
        }
        //add a question and a new dialogue in the continuity
        public DialogueBuilder addQuestion(String question, DialogueBuilder dialogue){
            continuity.put(question, dialogue.build());
            return this;
        }
        //add a question and a dialogue with only a string in the continuity
        public DialogueBuilder addFinalAnswer(String question, String answer){
            continuity.put(question, new Dialogue(answer));
            return this;
        }
        //build the corresponding Dialogue
        public Dialogue build(){
            return new Dialogue(question, continuity, error);
        }
    }

}
