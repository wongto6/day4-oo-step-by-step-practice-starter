package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class School {

    private List<Person> people;
    private List<Person> observers = new ArrayList<>();

    public School(List<Person> people) {
        this.people = people;
    }

    public void startSchool() {
        people.forEach(person -> System.out.println(person.introduce()));
    }

    public List<Person> getPeopleInClass(Klass klass) {
        return people
                .stream()
                .filter(person -> person.checkInClass(klass))
                .toList();
    }


}
