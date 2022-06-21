package chapter15.stream.serialize;

import java.io.*;

// Externalizable interface를 통해서 어떻게 기입하겠는지, 어떻게 읽는지 설정이 가능
class Person implements Serializable {
    String name;
    // transient는 직렬화시 저장하지 않겠다고 명시하는 것.
    transient String title;

    public Person() {

    }
    public Person(String name, String title) {
        this.name = name;
        this.title = title;
    }
    public String toString() {
        return name +',' + title;
    }
}
public class SerializationTest {
    public static void main(String[] args) {
        Person personLee = new Person("lee","manager");
        try (FileOutputStream fos = new FileOutputStream("serial.data");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(personLee);
        } catch(IOException e) {

        }

        try (FileInputStream fis = new FileInputStream("serial.data");
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Object obj = ois.readObject();
            if(obj instanceof Person) {
                Person p = (Person) obj;
                System.out.println(p);
            }
        } catch(IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
