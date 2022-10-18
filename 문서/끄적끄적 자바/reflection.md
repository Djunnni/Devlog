### 리플렉션

Class 클래스를 이용해 클래스의 정보(생성자, 멤버변수, 메서드)를 가져오고 이를 활용하며 인스턴스를 생성하고 메서드를 호출하는 등의 프로그래밍 방식

로컬 메모리에 객체가 없어서 객체의 데이터 타입을 직접 알 수 없는 경우 객체 정보만을 이용해 프로그래밍 할 수 있음.

> 리플렉션 프로그래밍을 만날일은 많지 않다고 함 안드로이드 내부적으로도 쓰이며 우리가 알아야 하는 부분임
(인프런 강의(Do it! 자바 프로그래밍 입문 - 기본 클래스(2)) 중)


##### 알아둘 내용

// ClassTest.java
```java
package TEST;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        
        // 1,2번은 클래스가 컴파일이 되야 사용가능 (static 로딩)
        // 3번은 forName은 있는지 없는지 모르는데 이 이름을 가진 클래스가 있다면 가져온다. (동적 로딩)
        // 컴파일 타임에는 모르다가 런타임때 에러가 발생할 수 있다.

        // Class class를 가져오는 방법 1
        // 이미 생성된 인스턴스일 경우 getClass를 사용할 수 있다.
        // getClass는 Object의 상속을 받아 쓰는 메서드다.
        Class pClass1 = person.getClass();

        System.out.println(pClass1.getName()); // TEST.Person

        // Class class를 가져오는 방법 2
        // Compile을 하면 Person이라는 클래스가 생성되어 있다.
        Class pClass2 = Person.class;
        System.out.println(pClass2.getName()); // TEST.Person


        // Class class를 가져오는 방법 3
        // ClassNotFoundException 에러처리가 필요하다.
        Class pClass3 = Class.forName("TEST.Person");
        System.out.println(pClass3.getName());
    }
}

// Person.java
package TEST;
public class Person {
    String name;
    int age;

    public Person(){}
    public Person(String name) {
        this.name = name;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package TEST;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class strClass = Class.forName("java.lang.String");

        Constructor[] cons = strClass.getConstructors();

        // 생성자의 정보를 알아본다.
        for(Constructor c : cons) {
            System.out.println(c);
        }

        Field[] fields = strClass.getFields();
        for(Field f : fields) {
            System.out.println(f);
        }

        Method[] methods = strClass.getMethods();
        for(Method m : methods) {
            System.out.println(m);
        }

        Class pClass = Class.forName("TEST.Person");

        // deprecates되어 newInstance는 9부터 사용 X
        // Constructor.newInstance로 접근!
//        Person p = (Person) pClass.newInstance();

        Constructor<?> constructor = pClass.getConstructor(String.class, int.class);
        Person p = (Person) constructor.newInstance("daniel", 27);
        System.out.println(p.getName() + ", " +p.getAge());

    }
}


```
