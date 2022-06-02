package chapter11.classex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class strClass = Class.forName("java.lang.String");

        Constructor[] cons = strClass.getConstructors();
        for(Constructor c : cons) {
            System.out.println(c);
        }

        Field[] fields = strClass.getFields();
        for(Field x : fields) {
            System.out.println(x);
        }
        Method[] methods = strClass.getMethods();
        for(Method m : methods) {
            System.out.println(m);
        }

        Class pClass = Class.forName("chapter11.classex.Person");
        Person p = (Person) pClass.newInstance();
    }
}
