package reference;

public class Student {
    int studentID;
    String studentName;

    Subject korea;
    Subject math;

    public Student() {
        korea = new Subject();
        math = new Subject();
    }

    public Student(int ID, String Name) {
        korea = new Subject("국어");
        math = new Subject("수학");
        studentID = ID;
        studentName = Name;
    }

    public void setKorea(int score) {
        korea.setScore(score);
    }

    public void setMath(int score) {
        math.setScore(score);
    }

    public void showStudentInfo() {
        int total = korea.getScore() + math.getScore();
        System.out.println(studentName + " 학생의 총점은 :" + total);
    }
}
