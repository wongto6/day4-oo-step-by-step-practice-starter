package oo;

public class Student extends Person {

    private static final String OCCUPATION = "student";
    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a %s.", OCCUPATION);
    }

    public void join(Klass inputClass) {
        this.klass = inputClass;
    }

    public boolean isIn(Klass inputClass) {
        return klass != null && this.klass.getNumber().equals(inputClass.getNumber());
    }

}
