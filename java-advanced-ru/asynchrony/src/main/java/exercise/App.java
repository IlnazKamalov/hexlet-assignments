package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.*;

class App {


    // BEGIN

    /*public synchronized static CompletableFuture<Long> getDirectorySize(String pathDirectory) {

        return CompletableFuture.supplyAsync(() -> {

            Path path = Paths.get(pathDirectory);

            long size = 0;

            try {
                Thread.sleep(6000);
                size = walk(path)
                        .map(Path::toFile)
                        .filter(File::isFile)
                        .mapToLong(File::length)
                        .sum();
            } catch (InterruptedException error) {
                throw new RuntimeException();
            } catch (IOException e) {
                System.out.println("Directory not found");
            }

            return size;
        });
    }*/

    public synchronized static CompletableFuture<String> unionFiles
    (String file1, String file2, String result) {

        CompletableFuture<String> dest1 = getText(file1);
        CompletableFuture<String> dest2 = getText(file2);

        return dest1.thenCombine(dest2, (fileFuture1, fileFuture2) -> {

            Path path = Paths.get(result);

            try {
                write(path, (fileFuture1 + fileFuture2).getBytes(),
                        StandardOpenOption.CREATE);
            } catch (IOException error) {
                System.out.println("NoSuchFileException");
            }

            return "Success";
        });
    }

    private static CompletableFuture<String> getText(String file) {

        return CompletableFuture.supplyAsync(() -> {

            Path path = Paths.get(file);

            String text = "";

            try {
                text = readString(path);
            } catch (IOException error) {
                System.out.println("NoSuchFileException");
            }

            return text;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> stringCompletableFuture =
                App.unionFiles("file1.txt", "file2.txt", "result.txt");

        stringCompletableFuture.get();

       // CompletableFuture<Long> completableFuture =
       //         App.getDirectorySize("/dir/subdir");
//
       // completableFuture.get();
        // END
    }
}

