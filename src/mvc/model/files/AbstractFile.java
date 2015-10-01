package mvc.model.files;

import java.io.File;

public abstract class AbstractFile extends File {

    public AbstractFile(String pathname) {
        super(pathname);
    }

    public abstract boolean isValid();

}
