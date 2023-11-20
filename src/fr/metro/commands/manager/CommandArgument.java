package fr.metro.commands.manager;

public class CommandArgument {

    private final String title;
    private final ArgumentType type;

    public CommandArgument(String title, ArgumentType type){
        this.title = title;
        this.type = type;
    }

    public CommandArgument(String title){
        this(title, ArgumentType.REQUIRED);
    }

    @Override
    public String toString() {
        return type.start+title+type.end;
    }

    public enum ArgumentType{
        OPTIONAL("[", "]"), REQUIRED("<", ">");

        public final String end;
        public final String start;

        ArgumentType(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
