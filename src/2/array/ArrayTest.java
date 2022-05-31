package chapter7.array;

public class ArrayTest {
    public static void main(String[] args) {
        // 배열 초기화는 int경우 0, double 경우 0.0, 객체 경우 null 이다.
        int[] number = new int[] {1, 2, 3};

        number[0] = 1;
        number[1] = 2;
        number[2] = 3;

        for(int num : number) {
            System.out.println(num);
        }

        double[] studentIDs = new double[10];
        studentIDs[1] = 10;
        studentIDs[2] = 0.8;
        for(double studentID : studentIDs) {
            System.out.println(studentID);
        }
    }
}
