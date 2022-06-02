package chapter10.interfaceex;

public interface Calc {
    // 상수
    // public static final이 기본으로 들어가 있다.
    double PI = 3.14;
    int ERROR = -999999999;

    // 추상 메서드
    int add(int num1, int num2);
    int minus(int num1, int num2);
    int times(int num1, int num2);
    int divide(int num1, int num2);

    // 디폴트 메서드 java8 
    default void description() {
        System.out.println("정수 계산기를 구현합니다.");
    }
    // 정적 메서드 java8
    static int total(int[] arr) {
        int total = 0;
        for(int x : arr) {
            total += x;
        }
        return total;
    }

    // private 메서드도 가능. java8
}
