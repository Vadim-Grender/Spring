package org.example;
import org.example.Model.Person;
import org.example.UseCase.FileManager;
import org.example.UseCase.ListOfPerson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


class Program {
    public static void main(String[] args) {
        List<Person> persons;
        File f = new File(FileManager.FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            persons = FileManager.loadPersonsListFromFile(FileManager.FILE_JSON);
        } else {
            persons = ListOfPerson.prepareList();
            FileManager.savePersonsListToFile(FileManager.FILE_JSON, persons);
        }
        FileManager.printPersons(persons);
    }


}
