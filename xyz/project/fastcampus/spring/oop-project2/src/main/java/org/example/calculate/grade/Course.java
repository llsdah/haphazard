package org.example.calculate.grade;

public class Course {
    public final String subject;

    public final int credit;
    public final String grade;

    public String getSubject() {
        return subject;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public Course(String subject, int credit, String grade) {


        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public double getGradeToNumber() {

        double grade =0;
        switch (this.grade){
            case "A+" :
                grade = 4.5;
                break;
            case "A" :
                grade = 4.0;
                break;
            case "B+" :
                grade = 3.5;
                break;
            case "B" :
                grade = 3.0;
                break;
            case "C+" :
                grade = 2.5;
                break;
            case "C" :
                grade = 2.0;
                break;
        }
        System.out.println(grade);
        return grade;
    }

    public double getMultiplyCraditAndGourseGrade() {
        return credit * getGradeToNumber();
    }
}
