package arghandlers;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class SpecificationNameArgHandler extends OptionHandler {

    public SpecificationNameArgHandler(CmdLineParser parser, OptionDef option, Setter setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        return 0;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }
}
