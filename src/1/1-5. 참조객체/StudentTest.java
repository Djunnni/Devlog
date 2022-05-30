package reference;

public class StudentTest {
    static public void main(String[] args) {
        Student studentLee = new Student(100, "lee");
        studentLee.setKorea( 100);
        studentLee.setMath(90);

        studentLee.showStudentInfo();

        Student studentTomas = new Student(101, "tomas");
        studentTomas.setKorea(80);
        studentTomas.setMath(50);

        studentTomas.showStudentInfo();
    }
}
