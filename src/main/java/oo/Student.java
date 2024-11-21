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
        return isClassLeader() ? introduction + String.format(" I am the leader of class %d.", klass.getNumber()) : introduction;
    }

    public void join(Klass inputClass) {
        this.klass = inputClass;
    }

    public boolean isIn(Klass inputClass) {
        return klass != null && this.klass.getNumber().equals(inputClass.getNumber());
    }

    public boolean isClassLeader() {
        return klass != null && this.klass.getClassLeader().equals(this);
    }

}
