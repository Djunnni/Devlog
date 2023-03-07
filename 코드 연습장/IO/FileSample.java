import java.io.File;

public class FileSample {
    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String path = File.separator + "Users/djunnni/Desktop" + File.separator;

        sample.checkPath(path);
        sample.makeDir(path + "daniels");
        sample.checkFileMethod(path);
        sample.lastModified(path);
    }

    private void checkPath(String path) {
        File file = new File(path);
        System.out.println(path + " is exists ? " + file.exists());
    }

    private void makeDir(String path) {
        File file = new File(path);
        System.out.println("Make " + path + " result = " + file.mkdir());
    }

    private void checkFileMethod(String path) {
        File file = new File(path);
        System.out.println(path + " is directory = " + file.isDirectory());
        System.out.println(path + " is file = " + file.isFile());
        System.out.println(path + " is hidden = " + file.isHidden());
    }

    private void canFileMethod(String path) {
        File file = new File(path);
        System.out.println(path + " can read ? = " + file.canRead());
        System.out.println(path + " can write ? = " + file.canWrite());
        System.out.println(path + " can excute ? = " + file.canExecute());
    }

    private void lastModified(String path) {
        File file = new File(path);
        System.out.println(path + " last modified = " + file.lastModified());
    }

    private void delete(String path) {
        File file = new File(path);
        file.delete();
    }
}
