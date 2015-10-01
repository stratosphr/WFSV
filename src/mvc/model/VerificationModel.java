package mvc.model;

import mvc.model.events.IVerificationListener;
import mvc.model.files.SpecificationFile;
import mvc.model.files.VerificationFolder;
import mvc.model.heuristics.AbstractHeuristic;
import mvc.model.implementations.EImplementation;
import mvc.model.parameters.Parameters;
import mvc.model.verifiers.EApproximation;
import mvc.model.verifiers.EVerifier;
import mvc.model.verifiers.IVerificationHandler;
import mvc.model.verifiers.Verifier;

import javax.swing.event.EventListenerList;
import java.util.ArrayList;
import java.util.List;

public class VerificationModel extends AbstractModel implements IVerificationHandler {

    private final EventListenerList listeners;
    private VerificationFolder verificationFolder;
    private SpecificationFile specificationFile;
    private EVerifier verifier;
    private List<AbstractHeuristic> heuristics;
    private EImplementation implementation;
    private Parameters parameters;

    public VerificationModel(VerificationFolder verificationFolder, SpecificationFile specificationFile, EVerifier verifier, ArrayList<AbstractHeuristic> heuristics, EImplementation implementation, Parameters parameters) {
        this.verificationFolder = verificationFolder;
        this.specificationFile = specificationFile;
        this.verifier = verifier;
        this.heuristics = heuristics;
        this.implementation = implementation;
        this.parameters = parameters;
        listeners = new EventListenerList();
    }

    @Override
    public void update() {
        fireVerificationFolderChanged();
        fireSpecificationFileChanged();
        fireVerifierChanged();
        fireHeuristicsChanged();
        fireImplementationChanged();
        fireParametersChanged();
    }

    public void addVerificationListener(IVerificationListener verificationListener) {
        listeners.add(IVerificationListener.class, verificationListener);
    }

    public VerificationFolder getVerificationFolder() {
        return verificationFolder;
    }

    public void setVerificationFolder(VerificationFolder verificationFolder) {
        this.verificationFolder = verificationFolder;
        fireVerificationFolderChanged();
    }

    private void fireVerificationFolderChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.verificationFolderChanged(verificationFolder);
        }
    }

    public SpecificationFile getSpecificationFile() {
        return specificationFile;
    }

    public void setSpecificationFile(SpecificationFile specificationFile) {
        this.specificationFile = specificationFile;
        fireSpecificationFileChanged();
    }

    private void fireSpecificationFileChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.specificationFileChanged(specificationFile);
        }
    }

    public EVerifier getVerifier() {
        return verifier;
    }

    public void setVerifier(EVerifier verifier) {
        this.verifier = verifier;
        fireVerifierChanged();
    }

    private void fireVerifierChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.verifierChanged(verifier);
        }
    }

    public List<AbstractHeuristic> getHeuristics() {
        return heuristics;
    }

    public void setHeuristics(List<AbstractHeuristic> heuristics) {
        this.heuristics = heuristics;
        fireHeuristicsChanged();
    }

    private void fireHeuristicsChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.heuristicsChanged(heuristics);
        }
    }

    public EImplementation getImplementation() {
        return implementation;
    }

    public void setImplementation(EImplementation implementation) {
        this.implementation = implementation;
        fireImplementationChanged();
    }

    private void fireImplementationChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.implementationChanged(implementation);
        }
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
        fireParametersChanged();
    }

    private void fireParametersChanged() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.parametersChanged(parameters);
        }
    }

    public void startVerification() {
        Verifier verifier = new Verifier(this);
        fireVerificationStarted();
        verifier.startVerification(this);
        fireVerificationEnded();
    }

    private void fireVerificationStarted() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.verificationStarted();
        }
    }

    private void fireVerificationEnded() {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.verificationEnded();
        }
    }

    @Override
    public void fireWritingApproximationStarted(EApproximation approximation) {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.writingApproximationStarted(approximation);
        }
    }

    @Override
    public void fireWritingApproximationEnded(EApproximation approximation) {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.writingApproximationEnded(approximation);
        }
    }

    @Override
    public void fireCheckingApproximationStarted(EApproximation approximation) {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.checkingApproximationStarted(approximation);
        }
    }

    @Override
    public void fireCheckingApproximationEnded(EApproximation approximation) {
        IVerificationListener[] listeners = this.listeners.getListeners(IVerificationListener.class);
        for (IVerificationListener listener : listeners) {
            listener.checkingApproximationEnded(approximation);
        }
    }
}
