import java.io.File;
import java.io.IOException;

public class FileManageClass {
    public static void main(String[] args) throws IOException {
        String pathName = File.separator + "Users/djunnni/Desktop" + File.separator;
        String fileName = "test.txt";

        checkFile(pathName, fileName);
        getFileInfo(new File(pathName, fileName));
        getParent(new File(pathName, fileName)); // 파일일 때,
        getParent(new File(pathName)); // 경로일 때,
    }

    private static void checkFile(String pathName, String fileName) {
        File file = new File(pathName, fileName);

        try {
            System.out.println("Create result = " + file.createNewFile()); // 다시 실행하면 이미 있으므로 false 리턴

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo(File file) throws IOException {
        // 경로 => canoical과 의미로 보자면 absolute쪽이 상대경로의 의미로 사용된다.
        System.out.println("absolute path " + file.getAbsolutePath());
        System.out.println("absolute file " + file.getAbsoluteFile());

        // 절대적이고 유일한 경로
        System.out.println("canoical path " + file.getCanonicalPath());
        System.out.println("canoical file " + file.getCanonicalFile());

        System.out.println("Name " + file.getName());
        System.out.println("Path " + file.getPath());
    }

    public static void getParent(File file) {
        System.out.println("parent =" + file.getParent());
        // File객체가 파일을 가리키고 있다면 파일이름을 제외한 경로를 알려준다.
        // Directory라면 부모 디렉터리
    }
}
