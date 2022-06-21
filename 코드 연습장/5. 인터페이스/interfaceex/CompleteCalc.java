package chapter10.interfaceex;
// extends는 구현 상속
public class CompleteCalc extends Calculator {
    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if(num2 != 0) {
            return num1 / num2;
        }
        return ERROR;
    }
    public void showInfo() {
        System.out.println("Calc 인터페이스로 구현됨.");
    }
    @Override
    public void description() {
        System.out.println("완벽한 계산기 입니다.");
    }
}
