
public class Sample {
    public static void main(String[] args) {
        int num = 123;
        String n1 = "" + num;
        String n2 = String.valueOf(num);
        String n3 = Integer.toString(num);
        System.out.println(n1); // 123
        System.out.println(n2); // 123
        System.out.println(n3); // 123

        String num2 = "123.456";
        double d = Double.parseDouble(num2);
        System.out.println(d); // 123.456

        int num1 = 123;
        double d_num1 = num1;
        System.out.println(d_num1); // 123.0

        double d2 = 123.456;
        int num3 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.
        System.out.println(num3);  // 소숫점이 생략된 123 출력®
    }
}