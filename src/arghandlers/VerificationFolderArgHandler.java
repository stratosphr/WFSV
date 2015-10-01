package arghandlers;

import mvc.model.files.VerificationFolder;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.Messages;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class VerificationFolderArgHandler extends AbstractArgHandler<VerificationFolder> {

    public VerificationFolderArgHandler(CmdLineParser parser, OptionDef option, Setter setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        String verificationFolderPath = params.getParameter(0);
        VerificationFolder verificationFolder = new VerificationFolder(verificationFolderPath);
        if (verificationFolder.isValid()) {
            setter.addValue(verificationFolder);
        } else {
            throw new CmdLineException(owner, Messages.ILLEGAL_PATH);
        }
        return 0;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }

}
