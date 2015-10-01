package mvc.model.events;

import mvc.model.verifiers.EVerifier;

public class VerifierChangedEvent extends AbstractEvent<EVerifier> {

    public VerifierChangedEvent(Object source, EVerifier verifier) {
        super(source, verifier);
    }

}
