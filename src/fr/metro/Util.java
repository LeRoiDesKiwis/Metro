package fr.metro;

import java.util.Collection;

public class Util {

    public static <T> void display(String name, Collection<T> collection){
        System.out.println("["+name+"]");
        collection.forEach(item -> System.out.println("- "+item));
    }

}
