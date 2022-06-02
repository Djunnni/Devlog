package chapter11.classex;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();

        Class pClass = person.getClass();
        System.out.println(pClass.getName());
        Class pClass2 = Person.class; // 컴파일이 되야만 알 수 있다.
        System.out.println(pClass2.getName());
        // 동적 로딩
        // 문자열에 맞는 클래스가 있느면 메모리에 로딩해라.
        Class pClass3 = Class.forName("chapter11.classex.Person");
        System.out.println(pClass3.getName());
    }
}
