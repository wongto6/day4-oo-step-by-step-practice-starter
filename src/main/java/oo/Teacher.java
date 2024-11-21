package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private static final String OCCUPATION = "teacher";

    private List<Klass> teachingClasses = new ArrayList<>();

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + String.format(" I am a %s.", OCCUPATION);
        return teachingClasses.isEmpty() ? introduction : introduction + getTeachingClasses();
    }

    @Override
    public boolean checkInClass(Klass klass){
        return teachingClasses.contains(klass);
    }

    public String getTeachingClasses() {
        return " I teach Class " + teachingClasses
                .stream()
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", ")) + ".";
    }

    public void assignTo(Klass klass) {
        teachingClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return teachingClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return teachingClasses.stream().anyMatch(student::isIn);
    }

    @Override
    public void notifiedLeaderAssignment(Klass klass) {
        System.out.printf("I am %s, %s of Class %d. I know %s become Leader.%n", name, OCCUPATION, klass.getNumber(), klass.getClassLeader().name);
    }
}
