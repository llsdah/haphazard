package org.example.calculator.grade;

import org.example.calculate.grade.Course;

import javax.xml.transform.Source;
import java.util.List;

public class GradeCalcurator {

    public final Courses courses;
    public GradeCalcurator(Courses courses){

        this.courses = courses;
    };

    /**
     * 핵심 포인트
     * 이수한 과목으 렂ㄴ달해 학점 계싼 => 학점 계산기 -> (학점수*교과목)합계 -> 과목(코스) 일급컬렉션
     *                                          -> 수강신청 총학점 -> 과목(코스) 일급 컬렉션
     * @return
     */
    public double gradeCalculate(){
/** 
 * 일급 컬렉션 사용전
        double multipliedCreditAndCourseGrade =0;
        //
        for(Course course : courses){
            //multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
            multipliedCreditAndCourseGrade += course.getMultiplyCraditAndGourseGrade();
        }

        // 총 학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        System.out.println(multipliedCreditAndCourseGrade);
        return multipliedCreditAndCourseGrade/totalCompletedCredit;
 */
// 일급 컬렉션 사용 후

        double multipliedCreditAndCourseGrade = courses.multiplyCraditAndGourseGrade();

        int totalCompletedCredit = courses.calculateTotalCompleteCredit();

        return multipliedCreditAndCourseGrade/totalCompletedCredit;
    }


}
