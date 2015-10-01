package arghandlers;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Setter;

public abstract class AbstractArgHandler<T> extends OptionHandler<T> {

    protected AbstractArgHandler(CmdLineParser parser, OptionDef option, Setter<? super T> setter) {
        super(parser, option, setter);
    }

}
