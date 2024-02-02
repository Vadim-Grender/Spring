package org.example.UseCase;
import org.example.Model.Person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static final String FILE_JSON = "persons_list.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void savePersonsListToFile(String fileName, List<Person> persons) {
        try {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), persons);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сериализовано");
    }


    public static List<Person> loadPersonsListFromFile(String fileName) {
        List<Person> persons = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                persons = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Десериализовано");
        return persons;
    }

    public static void printPersons(List<Person> personsList) {
        for (Person person : personsList) {
            System.out.println("FirstName: " + person.getFirstName());
            System.out.println("LastName: " + person.getLastName());
            System.out.println("Age: " + person.getAge());

        }
    }
}
