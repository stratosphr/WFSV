package mvc.model.files;

public class SpecificationFile extends AbstractFile {

    public SpecificationFile(String pathname) {
        super(pathname);
    }

    @Override
    public boolean isValid() {
        return false;
    }

}
