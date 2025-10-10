package org.example.sandbox.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 35);
        Person person4 = new Person("David", 30);
        Person person5 = new Person("John", 30);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        Collections.sort(people);
    }
}
