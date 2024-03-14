package util;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLsR {

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void listFiles(String directory) {
        submitTask(new File(directory));
        executor.shutdown();
    }

    private void submitTask(File directory) {
        executor.submit(() -> {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        submitTask(file);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new ConcurrentLsR().listFiles("/path/to/directory");
    }
}