package oo;

import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Person> people;

    public School(List<Person> people){
        this.people = people;
    }

    public void startSchool(){
        people.forEach(person-> System.out.println(person.introduce()));
    }

}
