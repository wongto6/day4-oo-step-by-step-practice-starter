package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    private final Integer number;
    private Student classLeader;
    private Person attachedPerson;
    private School school;

    private List<Person> observers = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Student getClassLeader() {
        return classLeader;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void assignLeader(Student classLeader) {
        if (!classLeader.isIn(this)) {
            System.out.println("It is not one of us");
        } else {
            this.classLeader = classLeader;
            notifyByAttachMode();
        }
    }

    public void notifyByAttachMode() {
        if (attachedPerson == null && school != null) {
            updateListOfObservers(school);
            notifyAllObservers();
        } else {
            notifyAttachedPerson();
        }
    }

    public void updateListOfObservers(School school) {
        this.observers = school
                .getPeopleInClass(this)
                .stream()
                .filter(observer -> !observer.name.equals(classLeader.name))
                .toList();
    }

    public void notifyAllObservers() {
        observers
                .forEach(observer -> observer.notifiedLeaderAssignment(this));
    }

    public void notifyAttachedPerson() {
        if (attachedPerson != null) {
            attachedPerson.notifiedLeaderAssignment(this);
        }
    }

    public void attach(Person person) {
        this.attachedPerson = person;
    }

    public boolean isLeader(Student student) {
        return classLeader != null && classLeader.equals(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return Objects.equals(number, klass.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
