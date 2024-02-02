package org.example.Model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.example.UseCase.FileManager;

public class Person extends FileManager {
    /**
     * @firstname Имя
     * @lastName Фамилия
     * @age Возраст
     */
    private String firstName;
    private String lastName;
    private int age;

    /*
    Конструктор объекта без параметров
     */
    public Person() {
    }

    /*
    Конструктор объекта с параметрами
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}