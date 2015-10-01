package mvc.controller;

import mvc.model.VerificationModel;
import mvc.model.events.IVerificationListener;
import mvc.model.files.SpecificationFile;
import mvc.model.files.VerificationFolder;
import mvc.model.heuristics.AbstractHeuristic;
import mvc.model.implementations.EImplementation;
import mvc.model.parameters.Parameters;
import mvc.model.verifiers.EVerifier;
import mvc.views.AbstractVerificationView;
import mvc.views.console.ConsoleVerificationView;

import java.util.ArrayList;
import java.util.List;

public class Controller extends AbstractController {

    private final VerificationModel model;
    private final List<AbstractVerificationView> verificationViews;

    public Controller(VerificationModel model) {
        this.model = model;
        verificationViews = new ArrayList<>();
        verificationViews.add(new ConsoleVerificationView(this));
        addListenersToModel();
        model.update();
    }

    private void addListenersToModel() {
        for (IVerificationListener verificationListener : verificationViews) {
            model.addVerificationListener(verificationListener);
        }
    }

    public void displayVerificationViews() {
        for (AbstractVerificationView verificationView : verificationViews) {
            verificationView.display();
        }
    }

    public void closeVerificationViews() {
        for (AbstractVerificationView verificationView : verificationViews) {
            verificationView.close();
        }
    }

    public void notifyVerificationFolderChanged(VerificationFolder verificationFolder) {
        model.setVerificationFolder(verificationFolder);
    }

    public void notifySpecificationFileChanged(SpecificationFile specificationFile) {
        model.setSpecificationFile(specificationFile);
    }

    public void notifyVerifierChanged(EVerifier verifier) {
        model.setVerifier(verifier);
    }

    public void notifyHeuristicsChanged(List<AbstractHeuristic> heuristics) {
        model.setHeuristics(heuristics);
    }

    public void notifyImplementationChanged(EImplementation implementation) {
        model.setImplementation(implementation);
    }

    public void notifyParametersChanged(Parameters parameters) {
        model.setParameters(parameters);
    }

    public void notifyVerificationRequested() {
        model.startVerification();
    }

}
