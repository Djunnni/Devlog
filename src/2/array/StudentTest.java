package chapter7.array;

public class StudentTest {

    public static void main(String[] args) {
        Student lee = new Student(1001, "lee");
        lee.addSubject("국어", 100);
        lee.addSubject("수학", 90);

        lee.showStudentInfo();

        Student kim = new Student(1002, "kim");
        kim.addSubject("국어", 50);
        kim.addSubject("수학", 60);

        kim.showStudentInfo();

    }
}
