package oo;

public class Teacher extends Person {
    private static final String OCCUPATION = "teacher";

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a %s.", name, age, OCCUPATION);
    }
}
