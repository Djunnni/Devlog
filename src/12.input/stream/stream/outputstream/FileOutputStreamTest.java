package chapter15.stream.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        byte[] bs = new byte[26];
        byte data = 65;
        for(int i = 0; i < bs.length; i++) {
            bs[i] = data++;
        }

        FileOutputStream fos = new FileOutputStream("output2.txt");
        try (fos) {
            fos.write(bs, 2 , 10);
        } catch(IOException e) {
            System.out.println(e);
        }
        System.out.print("end");
    }
}

