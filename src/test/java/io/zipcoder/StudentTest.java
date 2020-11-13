package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void studentTest(){
        String expectedFirstName = "John";
        String expectedLastName = "Smith";
        Double[] expectedExamScores = {100.0, 95.0};
        String expectedExamScoresString = "Exam Scores:\n\tExam 1 -> 100.0\n\tExam 2 -> 95.0\n";
        Student newStudent = new Student(expectedFirstName, expectedLastName, expectedExamScores);
        String actualFirstName = newStudent.getFirstName();
        String actualLastName = newStudent.getLastName();
        String actualExamScores = newStudent.getExamScores() ;
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedExamScoresString, actualExamScores);
    }
    @Test
    public void setFirstNameTest() {
        String expected = "Kyle";
        Student newStudent = new Student(expected, "", new Double[0]);
        String actual = newStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setLastNameTest() {
        String expected = "Petrick";
        Student newStudent = new Student("", expected, new Double[0]);
        String actual = newStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getExamScoresTest() {
        String expected = "Exam Scores:\n\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n";
        Student newStudent = new Student("", expected, new Double[]{100.0, 95.0});
        String actual = newStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addExamTest() {
        String firstName = "";
        String lastName = "";
        Double[] examScores = { };
        String expectedExamScores = "Exam Scores:\n\tExam 1 -> 100.0\n";
        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(100.00);
        String actualExamScores = student.getExamScores();
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }
    @Test
    public void setExamScoreTest() {
        String firstName = "";
        String lastName = "";
        Double[] examScores = {100.0};
        String expectedExamScores = "Exam Scores:\n\tExam 1 -> 150.0\n";
        Student student = new Student(firstName, lastName, examScores);
        student.setExamScores(0, 150.0);
        String actualExamScores = student.getExamScores();
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }
    @Test
    public void getAverageExamScoreTest() {
        String firstName = "";
        String lastName = "";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Double expectedAverageExamScores = 125.0;
        Student student = new Student(firstName, lastName, examScores);
        Double actualAverageExamScores = student.getAverageExamScore();
        Assert.assertEquals(expectedAverageExamScores, actualAverageExamScores);
    }
    @Test
    public void toStringTest() {
        String firstName = "";
        String lastName = "";
        Double[] examScores = {100.0, 150.0, 250.0, .0};
        String expectedToString = "Student Name:  \n" +
                "> Average Score: 125.0\n" +
                "> Exam Scores:\n\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n";
        Student student = new Student(firstName, lastName, examScores);
        String actualToString = student.toString();
        Assert.assertEquals(expectedToString, actualToString);
    }
}