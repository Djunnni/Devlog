package reference;

public class StudentTest {
    static public void main(String[] args) {
        Student studentLee = new Student(100, "lee");
        studentLee.setKorea( 100);
        studentLee.setMath(90);
        // Student에 setKorea안에 this와 아래 인스턴스가 같은 heap 메모리 주소를 가리킨다.
        System.out.println(studentLee);
        studentLee.showStudentInfo();

        Student studentTomas = new Student(101, "tomas");
        studentTomas.setKorea(80);
        studentTomas.setMath(50);

        studentTomas.showStudentInfo();
    }
}
