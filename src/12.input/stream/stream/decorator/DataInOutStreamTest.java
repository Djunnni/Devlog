package chapter15.stream.decorator;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInOutStreamTest {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.txt");
            DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.write(100);
            dos.writeInt(10);
            dos.writeChar('A');
            dos.writeUTF("Hello");

        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
