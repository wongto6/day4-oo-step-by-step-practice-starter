package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_print_message_when_startSchool_given_person_in_school() {

        Student bob = new Student(1, "Bob", 18);
        Student tom = new Student(2, "Tom", 18);
        Teacher jerry = new Teacher(1, "Jerry", 21);

        School newSchool = new School(Arrays.stream((new Person[] {bob, tom, jerry})).toList());

        newSchool.startSchool();

        String expectedResults = "My name is Bob. I am 18 years old. I am a student.%nMy name is Tom. I am 18 years old. I am a student.%nMy name is Jerry. I am 21 years old. I am a teacher.";

        assertThat(systemOut()).contains(String.format(expectedResults));
    }
}
