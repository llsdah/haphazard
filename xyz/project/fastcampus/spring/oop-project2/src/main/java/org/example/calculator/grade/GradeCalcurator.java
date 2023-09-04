package org.example.calculator.grade;

import org.example.calculate.grade.Course;

import javax.xml.transform.Source;
import java.util.List;

public class GradeCalcurator {

    private final List<Course> courses;
    public GradeCalcurator(List<Course> courses){

        this.courses = courses;
    };

    public double gradeCalculate(){

        double multipliedCreditAndCourseGrade =0;
        //
        for(Course course : courses){
            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        // 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        System.out.println(multipliedCreditAndCourseGrade);
        return multipliedCreditAndCourseGrade/totalCompletedCredit;
    }


}
