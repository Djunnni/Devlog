package chapter14.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("./a.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finally");
        }

        // autoClosable 예시. [java7 부터]
        try(FileInputStream fis2 = new FileInputStream("./a.txt")) {

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("end");
    }
}
