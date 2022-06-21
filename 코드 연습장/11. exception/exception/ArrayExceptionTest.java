package chapter14.exception;

public class ArrayExceptionTest {
    static public void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(arr[i]);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("에러가 발생" + e);
            return;
        } finally {
            // exception이 발생하더라도 무조건  finally를 겪는다.
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
