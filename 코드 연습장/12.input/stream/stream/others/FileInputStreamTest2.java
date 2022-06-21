package chapter15.stream.others;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest2 {
    public static void main(String[] args) {
        // autoClosable interface가 들어가 있어서 finally 필요 x
        try (FileInputStream fis = new FileInputStream("src/chapter15/stream/others/input2.txt")) {
            byte[] bs = new byte[10];
            int i = 0;
            while((i = fis.read(bs)) != -1 ) {
                for(int j=0; j < i; j++) {
                    System.out.print((char) bs[j]);
                }



                System.out.println();
            }
        } catch(IOException e) {
            System.out.println(e);
        }

    }
}
