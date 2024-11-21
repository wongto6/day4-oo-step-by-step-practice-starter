package oo;

public class Teacher extends Person {
    private static final String OCCUPATION = "teacher";

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a %s.", OCCUPATION);
    }
}
