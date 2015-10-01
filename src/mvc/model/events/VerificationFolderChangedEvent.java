package mvc.model.events;

import mvc.model.files.VerificationFolder;

public class VerificationFolderChangedEvent extends AbstractEvent<VerificationFolder> {

    public VerificationFolderChangedEvent(Object source, VerificationFolder verificationFolder) {
        super(source, verificationFolder);
    }

}
