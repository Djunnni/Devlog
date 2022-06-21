package chapter11.object;

class Student {
    int studentID;
    String studentName;

    Student(int studentID,String studentName) {
        this.studentID = studentID;
        this.studentName =studentName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student std = (Student) obj;
            if(studentID == std.studentID) return true;
            else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentID;
    }
    // 논리적 동일함을 위해서 equals를 재정의하면 hashCode 메서드도 재정의 해서 동일한 값이 반환되게 해야한다.
}
public class EqualsTest {
    public static void main(String[] args) {
        String str1 = new String("test");
        String str2 = new String("test");

        // address가 같은지 체크
        System.out.println(str1 == str2);
        // 논리적인 값이 같은지 체크.
        System.out.println(str1.equals(str2));

        Student std1 = new Student(1001,"lee");
        Student std2 = new Student(1001,"lee");

        System.out.println(std1 == std2);
        System.out.println(std1.equals(std2));
        System.out.println(std1.hashCode());
        System.out.println(std1.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

    }
}
