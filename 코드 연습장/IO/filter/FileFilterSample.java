package io.filter;

import java.io.File;
import java.io.IOException;

public class FileFilterSample {
    public static void main(String[] args) {
        String pathName = File.separator + "Users/djunnni/Desktop" + File.separator;
        checkList(pathName);
    }

    private static void checkList(String pathName) {
        File file;
        try {
            file = new File(pathName);
            File[] mainFileList = file.listFiles(new JPGFileFilter());
            for (File temp : mainFileList) {
                System.out.println(temp.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
