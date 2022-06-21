package chapter15.stream.decorator;

import java.io.*;

public class FileCopyTest {
    public static void main(String[] args) {
        long milliseconds = 0;
        int len = 0;
        try (
                FileOutputStream fos = new FileOutputStream(("b.exe"));
                FileInputStream fis = new FileInputStream("a.exe");
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos); // 8k buffer
        ) {

            int i = 0;
            milliseconds = System.currentTimeMillis();
            while((i = bis.read()) != -1) {
                bos.write(i);
                len++;
            }
            milliseconds = System.currentTimeMillis() - milliseconds;
        } catch(IOException e) {
            System.out.println(e);
        }
        System.out.println(len);
        System.out.println(milliseconds);
    }
}
