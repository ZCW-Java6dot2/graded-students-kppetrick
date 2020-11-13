package io.zipcoder;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String examScoresString = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            examScoresString += String.format("\tExam %d -> %.1f\n", i + 1, examScores.get(i));
        }
        return examScoresString;
    }

    public void addExamScore(Double newExamScore) {
        examScores.add(newExamScore);
    }

    public void setExamScores(int examIndex, Double newScore) {
        examScores.set(examIndex, newScore);
    }

    public Double getAverageExamScore() {
        Double totalScore = 0.0;
        for (Double exam : examScores) {
            totalScore += exam;
        }
        return totalScore / examScores.size();
    }

    @Override
    public String toString() {
        return String.format("Student Name: %s %s\n> Average Score: %3.1f\n", getFirstName(),getLastName(),getAverageExamScore()) + "> " + getExamScores();
    }
}




