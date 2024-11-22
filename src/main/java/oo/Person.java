package oo;

import java.util.Objects;

public class Person {

    public static final String MY_NAME_IS_S_I_AM_D_YEARS_OLD = "My name is %s. I am %d years old.";
    protected Integer id;
    protected String name;
    protected Integer age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format(MY_NAME_IS_S_I_AM_D_YEARS_OLD, name, age);
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
