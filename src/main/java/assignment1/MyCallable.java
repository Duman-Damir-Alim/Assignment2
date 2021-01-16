package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class MyCallable implements Callable<ArrayList<File>> {
    private final File file;
    public MyCallable(File file) {
        this.file = file;
    }

    @Override
    public ArrayList<File> call() throws Exception {
        ArrayList<File> files = new ArrayList<>();
        for (File file: Objects.requireNonNull(file.listFiles())){
            String fileName = file.getName();
            if (Pattern.matches("\\b[0-9]*$\\b", fileName.split("\\.")[0]) ||
                    Pattern.matches("\\bfile_[0-9]*$\\b", fileName.split("\\.")[0])){
                files.add(file);
            }
        }
        return files;
    }
}
