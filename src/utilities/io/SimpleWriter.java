package utilities.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SimpleWriter {

    private final File file;

    public SimpleWriter(File file) {
        this.file = file;
        file.getParentFile().mkdirs();
        empty();
    }

    public void writeLine(Object line) {
        writeLines(new Object[]{line});
    }

    public void writeLines(Object[] data) {
        try {
            for (Object object : data) {
                Files.write(Paths.get(file.getAbsolutePath()), object.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                newLine();
            }
            newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newLine() {
        try {
            Files.write(Paths.get(file.getAbsolutePath()), "\n".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void empty() {
        try {
            Files.write(Paths.get(file.getAbsolutePath()), "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
