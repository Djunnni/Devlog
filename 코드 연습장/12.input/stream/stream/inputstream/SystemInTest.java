package chapter15.stream.inputstream;

import java.io.IOException;

public class SystemInTest {
    public static void main(String[] args) {
        System.out.println("알파벳 하나를 쓰고 엔터를 누르세요.");
        int i = 0;
        try {
            while((i = System.in.read()) != '\n') {
                System.out.println(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
