package oo;

public class Student extends Person {

    private static final String OCCUPATION = "student";
    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + String.format(" I am a %s.", OCCUPATION);
        String fromClassIntro = getFromClassIntro();
        return isClassLeader() ? introduction + String.format(" I am the leader of class %d.", klass.getNumber()) : introduction + fromClassIntro;
    }

    private String getFromClassIntro() {
        return klass == null ? "" : String.format(" I am in class %d.", klass.getNumber());
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
        System.out.printf("I am %s, %s of Class %d. I know %s become Leader.%n", name, OCCUPATION, klass.getNumber(), klass.getClassLeader().name);
    }
}
