package chapter7.array;

import java.util.ArrayList;

public class Student {
    private int studentID;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.list = new ArrayList<Subject>();
    }

    public void addSubject(String name, int score) {
        Subject subject = new Subject();
        subject.setName(name);
        subject.setScore(score);
        this.list.add(subject);
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subject> getList() {
        return list;
    }

    public void setList(ArrayList<Subject> list) {
        this.list = list;
    }

    private String name;
    private ArrayList<Subject> list;

    public void showStudentInfo() {
        int total = 0;
        for(Subject sub : list) {
            total += sub.getScore();
            System.out.println("학생 "+ name + "님의" + sub.getName() + "과목의 성적은 " + sub.getScore() + "입니다.");

        }
        System.out.println("학생 "+ name + "님의 총점 : " + total);
    }
}
