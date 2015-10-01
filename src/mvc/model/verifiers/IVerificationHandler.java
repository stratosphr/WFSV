package mvc.model.verifiers;

public interface IVerificationHandler {

    void fireWritingApproximationStarted(EApproximation approximation);

    void fireWritingApproximationEnded(EApproximation approximation);

    void fireCheckingApproximationStarted(EApproximation approximation);

    void fireCheckingApproximationEnded(EApproximation approximation);

}
