package io.object;

import java.io.*;

import static java.io.File.separator;

public class ManageObject {
    public static void main(String[] args) {
        ManageObject manager = new ManageObject();
        String fullPath = separator +  "Users/dongjoonlee/Desktop" + separator + "a.txt";
        SerialDTO dto = new SerialDTO("GodOfJavaBook", 1, true, 100);
        manager.saveObject(fullPath, dto);

        manager.loadObject(fullPath);
    }
    private void loadObject(String fullPath) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(fullPath);
            ois = new ObjectInputStream(fis);
            SerialDTO dto = (SerialDTO) ois.readObject();
            System.out.println(dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void saveObject(String fullPath, SerialDTO dto) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fullPath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(dto);
            System.out.println("Write Success");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(fos != null) {
                try {
                    fos.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
