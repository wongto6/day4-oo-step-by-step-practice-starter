package oo.step8;

import oo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KlassTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_message_when_assign_leader_given_teacher_is_teaching_the_class() {


        Klass klass = new Klass(2);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.assignTo(klass);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass);

        Student bob = new Student(2, "Bob", 18);
        bob.join(klass);

        School newSchool = new School(Arrays.stream((new Person[]{jerry, bob})).toList());
        klass.setSchool(newSchool);

        klass.assignLeader(tom);

        String expectedOutput = "I am Jerry, teacher of Class 2. I know Tom become Leader.%nI am Bob, student of Class 2. I know Tom become Leader.";

        assertThat(systemOut()).contains(String.format(expectedOutput));
    }

    private String systemOut() {
        return outContent.toString();
    }
}
