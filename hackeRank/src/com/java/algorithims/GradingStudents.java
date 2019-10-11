package com.java.algorithims;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-11
 */
public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<Integer>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        grades = gradingStudents(grades);
        for (int grade: grades) {
            System.out.println(grade);
        }
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<Integer>();
        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            if(grade<38 || (grade%5)==0) {
                roundedGrades.add(i,grade);
                continue;
            } else {
                roundedGrades.add(i,roundTheGrade(grades.get(i)));
            }
        }
        return roundedGrades;
    }

    public static int roundTheGrade(int grade) {
        int reminder = grade%5;
        if(reminder > 2) {
            grade = grade + 5-reminder;
        }
        return grade;
    }
}
