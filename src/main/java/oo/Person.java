package oo;

import java.util.Objects;

public class Person {

    protected Integer id;
    protected String name;
    protected Integer age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    public void notifiedLeaderAssignment(Klass klass) {

    }

    public boolean checkInClass(Klass klass) {
        return false;
    }

    @Override
    public boolean equals(Object anotherPerson) {
        if (this == anotherPerson) return true;
        if (anotherPerson == null || getClass() != anotherPerson.getClass()) return false;
        Person person = (Person) anotherPerson;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
