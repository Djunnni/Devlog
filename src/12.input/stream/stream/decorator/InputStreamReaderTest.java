package chapter15.stream.decorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputStreamReaderTest {
    public static void main(String[] args) {
        // InputStreamReader가 fileInputStream의 바이트를 문자로 변경;
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream("reader.txt"))) {
            int i = 0;
            while((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch(IOException e) {
            System.out.println(e);
        }

        Socket socket = new Socket();
        try {
            InputStreamReader ir = new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
