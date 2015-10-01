package mvc.model.events;

import mvc.model.heuristics.AbstractHeuristic;

import java.util.List;

public class HeuristicsChangedEvent extends AbstractEvent<List<AbstractHeuristic>> {

    public HeuristicsChangedEvent(Object source, List<AbstractHeuristic> heuristics) {
        super(source, heuristics);
    }

}
