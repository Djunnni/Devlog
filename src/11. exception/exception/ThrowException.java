package chapter14.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowException {
    public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {
        ThrowException ex = new ThrowException();
        try {
            ex.loadClass("src/chapter14/exception/a.txt", "java.lang.String");
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("end");
    }
}
