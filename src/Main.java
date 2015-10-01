import arghandlers.SolverArgHandler;
import arghandlers.VerificationFolderArgHandler;
import mvc.controller.Controller;
import mvc.model.VerificationModel;
import mvc.model.files.SpecificationFile;
import mvc.model.files.VerificationFolder;
import mvc.model.heuristics.AbstractHeuristic;
import mvc.model.implementations.EImplementation;
import mvc.model.parameters.Parameters;
import mvc.model.verifiers.EVerifier;
import org.kohsuke.args4j.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @Option(name = "-gui", usage = "use graphical user interface")
    private boolean gui;

    @Option(name = "-f", metaVar = "[path/to/verification/folder]", usage = "verification folder path", handler = VerificationFolderArgHandler.class)
    private VerificationFolder verificationFolder;

    @Option(name = "-s", metaVar = "specificationName", usage = "specification name")
    private String specificationName;

    @Option(name = "-v", metaVar = "[sicstus|z3]", usage = "solver", handler = SolverArgHandler.class)
    private EVerifier verifier;

    @Argument
    private List<String> arguments = new ArrayList<>();

    public static void main(String[] args) {
        new Main().parseArgs(args);
    }

    public void parseArgs(String[] args) {
        CmdLineParser cmdLineParser = new CmdLineParser(this);
        try {
            cmdLineParser.parseArgument(args);
            if (!gui) {
                if (verificationFolder == null) {
                    throw new CmdLineException(cmdLineParser, "Missing verification folder parameter", new Throwable("The verification folder command line argument is required."));
                } else if (specificationName == null) {
                    throw new CmdLineException(cmdLineParser, "Missing specification name parameter", new Throwable("The specification name command line argument is required."));
                } else if (verifier == null) {
                    throw new CmdLineException(cmdLineParser, "Missing verifier name parameter", new Throwable("The verifier name command line argument is required."));
                }
            }
            SpecificationFile specificationFile = new SpecificationFile(verificationFolder.getAbsolutePath() + "/specifications/" + specificationName);
            VerificationModel verificationModel = new VerificationModel(verificationFolder, specificationFile, verifier, new ArrayList<AbstractHeuristic>(), EImplementation.DEFAULT, new Parameters());
            Controller controller = new Controller(verificationModel);
            controller.displayVerificationViews();
            controller.notifyVerificationRequested();
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            cmdLineParser.printUsage(System.err);
            System.err.println("Example : " + cmdLineParser.printExample(OptionHandlerFilter.ALL));
        }
    }

}
