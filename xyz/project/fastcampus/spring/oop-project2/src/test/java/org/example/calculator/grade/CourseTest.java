package org.example.calculator.grade;

import org.example.calculate.grade.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @DisplayName("과목을 생성")
    @Test
    void createTest(){
        assertThatCode(()-> new Course("OOP",3,"A+"))
                .doesNotThrowAnyException();

    }

}
