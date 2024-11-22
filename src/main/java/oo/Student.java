package oo;

public class Student extends Person {

    private static final String OCCUPATION = "student";
    public static final String I_AM_A_S = " I am a %s.";
    public static final String I_AM_THE_LEADER_OF_CLASS_D = " I am the leader of class %d.";
    public static final String I_AM_IN_CLASS_D = " I am in class %d.";
    public static final String I_AM_S_S_OF_CLASS_D_I_KNOW_S_BECOME_LEADER_N = "I am %s, %s of Class %d. I know %s become Leader.%n";
    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + String.format(I_AM_A_S, OCCUPATION);
        String fromClassIntro = getFromClassIntro();
        return isClassLeader() ? introduction + String.format(I_AM_THE_LEADER_OF_CLASS_D, klass.getNumber()) : introduction + fromClassIntro;
    }

    private String getFromClassIntro() {
        return klass == null ? "" : String.format(I_AM_IN_CLASS_D, klass.getNumber());
    }

    @Override
    public boolean checkInClass(Klass klass) {
        return isIn(klass);
    }

    public void join(Klass inputClass) {
        this.klass = inputClass;
    }

    public boolean isIn(Klass inputClass) {
        return klass != null && this.klass.getNumber().equals(inputClass.getNumber());
    }

    public boolean isClassLeader() {
        return klass != null && klass.hasClassLeader() && this.klass.getClassLeader().equals(this);
    }

    @Override
    public void notifiedLeaderAssignment(Klass klass) {
        System.out.printf(I_AM_S_S_OF_CLASS_D_I_KNOW_S_BECOME_LEADER_N, name, OCCUPATION, klass.getNumber(), klass.getClassLeader().name);
    }
}
