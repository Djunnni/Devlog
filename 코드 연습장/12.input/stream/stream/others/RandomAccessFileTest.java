package chapter15.stream.others;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    static public void main(String[] args) throws IOException {
        // 읽고 쓰는 걸 동시에 할 수 있다.
        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");
        rf.writeInt(100); //4
        System.out.println(rf.getFilePointer());
        rf.writeDouble(3.14); // 8
        System.out.println(rf.getFilePointer());
        rf.writeUTF("안녕하세요"); // 5 * 3 + 2(null pointer) = 17
        System.out.println(rf.getFilePointer());

        rf.seek(0);
        System.out.println(rf.readInt());
        System.out.println(rf.readDouble());
        System.out.println(rf.readUTF());
    }
}
