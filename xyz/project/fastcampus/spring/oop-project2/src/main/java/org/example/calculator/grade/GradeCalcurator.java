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
        return 4.5;
    }


}
