package mvc.model.files;

public class VerificationFolder extends AbstractFile {

    public VerificationFolder(String pathname) {
        super(pathname);
    }

    public boolean isValid() {
        return isDirectory();
    }

}
