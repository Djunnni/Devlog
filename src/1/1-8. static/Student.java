package chapter6.staticex;
//

public class Student {
    // 인스턴스가 공유하는 값
    private static int serialNum = 10000;
    int studentID;
    String studentName;

    public Student() {
        serialNum++;
        this.studentID = serialNum;
    }

    static public int getSerialNum() {
        int i = 10; // 지역변수
        i++;

        // studentName = "daniel" // 멤버 변수, 인스턴스 변수 사용할 수 없다.

        return serialNum; // static 변수, 클래스 변수
    }
}
