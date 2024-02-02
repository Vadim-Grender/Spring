package org.example.UseCase;

import org.example.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {
    public static List<Person> prepareList() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Вася", "Васин", 39));
        list.add(new Person("Петя", "Петров", 29));
        list.add(new Person("Игорь", "Игорев", 43));
        return list;
    }
}
