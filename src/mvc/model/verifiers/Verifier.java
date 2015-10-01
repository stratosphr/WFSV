package mvc.model.verifiers;

import mvc.model.VerificationModel;

public class Verifier {

    private final VerificationModel model;

    public Verifier(VerificationModel model) {
        this.model = model;
    }

    public void checkApproximation(EApproximation approximation, IVerificationHandler verificationHandler) {
        verificationHandler.fireWritingApproximationStarted(approximation);
        verificationHandler.fireWritingApproximationEnded(approximation);
    }

    public void startVerification(IVerificationHandler verificationHandler) {
        if (model.getParameters().isCheckApproximation1()) {
            checkApproximation(EApproximation.APPROXIMATION_1, verificationHandler);
        }
        if (model.getParameters().isCheckApproximation2()) {
            checkApproximation(EApproximation.APPROXIMATION_2, verificationHandler);
        }
        if (model.getParameters().isCheckApproximation3()) {
            checkApproximation(EApproximation.APPROXIMATION_3, verificationHandler);
        }
        if (model.getParameters().isCheckApproximation4()) {
            checkApproximation(EApproximation.APPROXIMATION_4, verificationHandler);
        }
    }

}
