package oo;

public class Student extends Person {

    private static final String OCCUPATION = "student";

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a %s.", name, age, OCCUPATION);
    }

}
