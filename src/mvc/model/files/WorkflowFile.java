package mvc.model.files;

public class WorkflowFile extends AbstractFile {

    public WorkflowFile(String pathname) {
        super(pathname);
    }

    @Override
    public boolean isValid() {
        return isFile();
    }

}
