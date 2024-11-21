package oo;

import java.util.Objects;

public class Klass {

    private final Integer number;
    private Student classLeader;

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Student getClassLeader() {
        return classLeader;
    }

    public void assignLeader(Student classLeader) {
        if (!classLeader.isIn(this)) {
            System.out.println("It is not one of us");
        } else {
            this.classLeader = classLeader;
        }
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
