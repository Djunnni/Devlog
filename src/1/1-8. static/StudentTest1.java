package chapter6.staticex;

public class StudentTest1 {
    public static void main(String[] args) {
        System.out.println(Student.getSerialNum());

        Student studentJ = new Student();
        System.out.println(studentJ.studentID);

        Student studentT = new Student();
        System.out.println(studentT.studentID);
    }
}
