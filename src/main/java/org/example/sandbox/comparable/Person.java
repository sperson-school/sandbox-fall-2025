package org.example.sandbox.comparable;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person that) {
        if (that == null) {
            return 1;
        }
        int ageComparison = Integer.compare(this.age, that.age);
        if (ageComparison != 0) {
            return ageComparison;
        } else {
            return this.name.compareTo(that.name);
        }
    }
}
