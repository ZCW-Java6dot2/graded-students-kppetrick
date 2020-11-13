package io.zipcoder;

import java.security.PublicKey;
import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] student) {
        this.students = student;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double totalScore = 0.0;
        for (int i = 0; i < students.length; i++) {
            totalScore += students[i].getAverageExamScore();
        }
        return totalScore / students.length;
    }

    public void addStudents(Student newStudent) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                break;
            } else {
                System.out.println("Classroom is full");
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName() == firstName && students[i].getLastName() == lastName) {
                students[i] = null;
            }
            Arrays.sort(students, new SortNulls());
        }
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(students, new SortByScores());
        return students;
    }
    public HashMap<Character, ArrayList<Student>> getGradeBook(){
        HashMap<Character, ArrayList<Student>> studentGradeMap = new HashMap<>();
        ArrayList<Student> studentsA = new ArrayList<>();
        ArrayList<Student> studentsB = new ArrayList<>();
        ArrayList<Student> studentsC = new ArrayList<>();
        ArrayList<Student> studentsD = new ArrayList<>();
        ArrayList<Student> studentsF = new ArrayList<>();
        Double highestGrade = this.getStudentsByScore()[0].getAverageExamScore();
        for (Student s: students) {
            if(s.getAverageExamScore() >= highestGrade * 0.9){
                studentsA.add(s);
            }
            else if (s.getAverageExamScore() < highestGrade * 0.9 && s.getAverageExamScore() > highestGrade * 0.7){
                studentsB.add(s);
            }
            else if (s.getAverageExamScore() <= highestGrade * 0.7 && s.getAverageExamScore() > highestGrade * 0.5){
                studentsC.add(s);
            }
            else if (s.getAverageExamScore() <= highestGrade * 0.5 && s.getAverageExamScore() > highestGrade * 0.1){
                studentsD.add(s);
            }
            else{
                studentsF.add(s);
            }
        }
        studentGradeMap.put('A', studentsA);
        studentGradeMap.put('B', studentsB);
        studentGradeMap.put('C', studentsC);
        studentGradeMap.put('D', studentsD);
        studentGradeMap.put('F', studentsF);
        return studentGradeMap;
    }

    class SortNulls implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if (s1 == null && s2 == null) {
                return 0;
            }
            if (s1 == null) {
                return 1;
            }
            if (s2 == null) {
                return -1;
            }
            return 0;
        }
    }
    class SortByScores implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if (s1 == null && s2 == null) {
                return 0;
            } else if (s1.getAverageExamScore() == s2.getAverageExamScore()) {
                return s1.getLastName().compareTo(s2.getLastName());
            } else if (s1.getAverageExamScore() < s2.getAverageExamScore()) {
                return 1;
            } else if (s1.getAverageExamScore() > s2.getAverageExamScore()) ;
            {
                return -1;
            }
        }
    }

}