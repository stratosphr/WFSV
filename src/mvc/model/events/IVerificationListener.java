package mvc.model.events;

import mvc.model.files.SpecificationFile;
import mvc.model.files.VerificationFolder;
import mvc.model.heuristics.AbstractHeuristic;
import mvc.model.implementations.EImplementation;
import mvc.model.parameters.Parameters;
import mvc.model.verifiers.EApproximation;
import mvc.model.verifiers.EVerifier;

import java.util.EventListener;
import java.util.List;

public interface IVerificationListener extends EventListener {

    void verificationFolderChanged(VerificationFolder verificationFolder);

    void specificationFileChanged(SpecificationFile specificationFile);

    void verifierChanged(EVerifier verifier);

    void heuristicsChanged(List<AbstractHeuristic> heuristics);

    void implementationChanged(EImplementation implementation);

    void parametersChanged(Parameters parameters);

    void writingApproximationStarted(EApproximation approximation);

    void writingApproximationEnded(EApproximation approximation);

    void checkingApproximationStarted(EApproximation approximation);

    void checkingApproximationEnded(EApproximation approximation);

    void verificationStarted();

    void verificationEnded();
}
