package org.example.calculator.grade;


import org.example.calculate.grade.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구 사항
 * 평균 학점 계산 방법 ( 학점수 * 교과목 평점) 의 합계 / 수강신청 총합점 수 
 * 일급 컬렉션 사용
 */
public class GradeCalcuratorTest {
    /**
     * 도메인 구성 갱체 : 이수한 과목, 학점 계산기
     * 객체 관계 : 이수한 과목을 바탕
     * 동적 객체를 정적 타입으로 모델링, 이수한 과목 자체가 클래스
     * 협력 설계 : 이수한 과목 전달 받아 평균학 계산 요청 -> 학점 계산기 -> (학점수 + 교과목 평점) 평점 합계
     * 객체 들을 포관하는 타입에 적정한 책임
     * 구현
     */

    @DisplayName("학점 계산기")
    @Test
    void calculateTest(){
        List<Course> courses = List.of(new Course("oop",3,"A+"),
                new Course("자료구조",3,"A+"));

        GradeCalcurator gradeCalcurator = new GradeCalcurator(courses);
        Double gradeResult = gradeCalcurator.gradeCalculate();

        assertThat(gradeResult).isEqualTo(4.5);
    }

}
