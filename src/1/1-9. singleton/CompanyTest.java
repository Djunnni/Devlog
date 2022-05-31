package chapter6.singleton;

import java.util.Calendar;

public class CompanyTest {
    public static void main(String[] args) {
        Company c1 = Company.getInstance();
        Company c2 = Company.getInstance();

        System.out.println(c1 == c2); // true

        // 캘린더도 싱글톤으로 제공하고 있다.
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
    }
}
