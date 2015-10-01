package mvc.model.events;

import mvc.model.files.SpecificationFile;

public class SpecificationFileChangedEvent extends AbstractEvent<SpecificationFile>{

    public SpecificationFileChangedEvent(Object source, SpecificationFile specificationFile) {
        super(source, specificationFile);
    }

}
