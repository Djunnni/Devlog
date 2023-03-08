package network;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static java.io.File.separator;

public class NioSample {
    public static void main(String[] args) {
        NioSample sample = new NioSample();
        sample.basicWriteAndRead();
    }

    private void basicWriteAndRead() {
        String fileName = separator +  "Users/dongjoonlee/Desktop" + separator + "nio.txt";
        try {
            writeFile(fileName, "My First NIO Sample");
            readFile(fileName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFile(String fileName) throws Exception {
        FileChannel channel = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        channel.close();
    }

    private void writeFile(String fileName, String myFirstNioSample) throws Exception {
        FileChannel channel = new FileOutputStream(fileName).getChannel();
        byte[] byteData = myFirstNioSample.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(byteData);
        channel.write(buffer);
        channel.close();
    }
}
