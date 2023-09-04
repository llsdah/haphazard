package org.example.calculator.grade;

import org.example.calculate.grade.Course;

import java.util.List;

/**
 * 일급 컬렉션 >
 * List 변수만(동일 클래스 형태의 몇개, Set 등) 한개 가지는 클래스
 *
 */
public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCraditAndGourseGrade() {

        return courses.stream()
                .mapToDouble(Course::getMultiplyCraditAndGourseGrade)
                .sum();
    }


    public int calculateTotalCompleteCredit() {
        // 총 학점 수

        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
