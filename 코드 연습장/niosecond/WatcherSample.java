package niosecond;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatcherSample extends Thread {
    String dirName;

    public WatcherSample(String dirName) {
        this.dirName = dirName;
    }

    public static void main(String[] args) throws Exception {
        String dirName =  File.separator + "Users/dongjoonlee/Desktop" + File.separator;
        String fileName = "a.txt";

        WatcherSample sample = new WatcherSample(dirName);
        //sample.setDaemon(true);
        sample.start();
        Thread.sleep(1000);
        for(int loop = 0; loop< 10; loop++) {
            sample.fileWriteDelete(dirName, fileName + loop);
        }
    }
    public void run() {
        System.out.println("## Watcher thread is started ##");
        System.out.format("DIR=%s\n", dirName);
        addWatcher();
    }

    public void addWatcher() {
        try {
            Path dir = Paths.get(dirName);

            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            while(true) {
                key = watcher.take();
                List<WatchEvent<?>> eventList = key.pollEvents();
                for(WatchEvent<?> event : eventList) {
                    Path name = (Path) event.context();
                    if(event.kind() == ENTRY_CREATE) {
                        System.out.format("%s created%n", name);
                    } else if(event.kind() == ENTRY_DELETE) {
                        System.out.format("%s deleted%n", name);
                    } else if(event.kind() == ENTRY_MODIFY) {
                        System.out.format("%s modified%n", name);
                    }
                }
                key.reset();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void fileWriteDelete(String dirName, String fileName) {
        Path path = Paths.get(dirName, fileName);
        String contents = "Watcher sample";
        StandardOpenOption openOption = StandardOpenOption.CREATE;

        try {
            System.out.println("Write " +fileName);
            Files.write(path, contents.getBytes(), openOption);
            Files.delete(path);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
수행결과

.DS_Store modified
.DS_Store modified
a.txt created
a.txt modified
a.txt modified
a.txt modified
a.txt modified
a.txt deleted
.DS_Store deleted


 */