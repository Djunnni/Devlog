package chapter10.interfaceex;

public class CalculatorTest {
    public static void main(String[] args) {
        Calc calc = new CompleteCalc();
        int num1 = 10;
        int num2 = 2;

        System.out.println(calc.add(num1, num2));
        calc.description();

        int[] arr = new int[] { 1, 2, 3};
        int sum = Calc.total(arr);
        System.out.println(sum);
    }
}
