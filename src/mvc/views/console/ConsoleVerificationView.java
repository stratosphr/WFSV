package mvc.views.console;

import mvc.controller.Controller;
import mvc.model.files.SpecificationFile;
import mvc.model.files.VerificationFolder;
import mvc.model.heuristics.AbstractHeuristic;
import mvc.model.implementations.EImplementation;
import mvc.model.parameters.Parameters;
import mvc.model.verifiers.EApproximation;
import mvc.model.verifiers.EVerifier;
import mvc.views.AbstractVerificationView;

import java.util.List;

public class ConsoleVerificationView extends AbstractVerificationView {

    public ConsoleVerificationView(Controller controller) {
        super(controller);
    }

    @Override
    public void display() {
    }

    @Override
    public void close() {

    }

    @Override
    public void verificationFolderChanged(VerificationFolder verificationFolder) {
        System.out.println("Verification folder : " + verificationFolder);
    }

    @Override
    public void specificationFileChanged(SpecificationFile specificationFile) {
        System.out.println("Specification file : " + specificationFile);
    }

    @Override
    public void verifierChanged(EVerifier verifier) {
        System.out.println("Verifier : " + verifier);
    }

    @Override
    public void heuristicsChanged(List<AbstractHeuristic> heuristics) {
        System.out.println("Heuristics : ");
        for(AbstractHeuristic heuristic : heuristics){
            System.out.println("\t" + heuristic);
        }
    }

    @Override
    public void implementationChanged(EImplementation implementation) {
        System.out.println("Implementation : " + implementation);
    }

    @Override
    public void parametersChanged(Parameters parameters) {
        System.out.println("Parameters : ");
        System.out.println("\t" + parameters.getMaxNodesValuation());
        System.out.println("\t" + parameters.getMinNumberOfSegments());
        System.out.println("\t" + parameters.getMaxNumberOfSegments());
        System.out.println("\t" + parameters.isCheckApproximation1());
        System.out.println("\t" + parameters.isCheckApproximation2());
        System.out.println("\t" + parameters.isCheckApproximation3());
        System.out.println("\t" + parameters.isCheckApproximation4());
    }

    @Override
    public void writingApproximationStarted(EApproximation approximation) {
        System.out.println("Writing " + approximation + "...");
    }

    @Override
    public void writingApproximationEnded(EApproximation approximation) {
        System.out.println("Done.");
    }

    @Override
    public void checkingApproximationStarted(EApproximation approximation) {
        System.out.println("Checking " + approximation + "...");
    }

    @Override
    public void checkingApproximationEnded(EApproximation approximation) {
        System.out.println("Done.");
    }

    @Override
    public void verificationStarted() {
        System.out.println("Starting verification...");
    }

    @Override
    public void verificationEnded() {
        System.out.println("Verification done.");
    }

}
