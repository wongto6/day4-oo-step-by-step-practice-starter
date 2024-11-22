package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private static final String OCCUPATION = "teacher";
    public static final String FULLSTOP = ".";
    public static final String I_AM_A_S = " I am a %s.";
    public static final String I_TEACH_CLASS = " I teach Class ";
    public static final String I_AM_S_S_OF_CLASS_D_I_KNOW_S_BECOME_LEADER_N = "I am %s, %s of Class %d. I know %s become Leader.%n";

    private List<Klass> teachingClasses = new ArrayList<>();

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + String.format(I_AM_A_S, OCCUPATION);
        return teachingClasses.isEmpty() ? introduction : introduction + getTeachingClasses();
    }

    @Override
    public boolean checkInClass(Klass klass) {
        return teachingClasses.contains(klass);
    }

    public String getTeachingClasses() {
        return I_TEACH_CLASS + teachingClasses
                .stream()
                .map(klass -> klass.getNumber().toString())
                .collect(Collectors.joining(", ")) + FULLSTOP;
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
        System.out.printf(I_AM_S_S_OF_CLASS_D_I_KNOW_S_BECOME_LEADER_N, name, OCCUPATION, klass.getNumber(), klass.getClassLeader().name);
    }
}
