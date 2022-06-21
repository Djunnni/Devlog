package chapter15.stream.others;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStreamTest {
    static public void main(String[] args) {
        FileReader fis = null;
        int i = 0;
        try {
            fis = new FileReader("src/chapter15/stream/others/input.txt");
            while((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch(IOException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
        System.out.println("end");

    }
}
