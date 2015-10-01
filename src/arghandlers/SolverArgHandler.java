package arghandlers;

import mvc.model.verifiers.EVerifier;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.Messages;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class SolverArgHandler extends AbstractArgHandler<EVerifier> {

    public SolverArgHandler(CmdLineParser parser, OptionDef option, Setter<? super EVerifier> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        String solver = params.getParameter(0).toLowerCase();
        switch (solver) {
            case "sicstus":
                setter.addValue(EVerifier.SICSTUS);
                break;
            case "z3":
                setter.addValue(EVerifier.Z3);
                break;
            default:
                throw new CmdLineException(owner, Messages.ILLEGAL_FIELD_SIGNATURE);
        }
        return 1;
    }

    @Override
    public String getDefaultMetaVariable() {
        return null;
    }

}
