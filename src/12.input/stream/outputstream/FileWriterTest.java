package chapter15.stream.outputstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    static public void main(String[]  args) {
        try (FileWriter fw = new FileWriter("writer.txt")) {
            fw.write('A');
            char[] cbuf = {'B', 'C', 'D',};
            fw.write(cbuf);
            fw.write("안녕하세요");
            fw.write(cbuf, 1, 2);
            fw.write("123");
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
