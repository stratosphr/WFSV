package mvc.model.parameters;

public class Parameters {

    private int maxNodesValuation;
    private int minNumberOfSegments;
    private int maxNumberOfSegments;
    private boolean checkApproximation1;
    private boolean checkApproximation2;
    private boolean checkApproximation3;
    private boolean checkApproximation4;

    public Parameters() {
        this(10, 1, 20, true, true, true, true);
    }

    public Parameters(int maxNodesValuation, int minNumberOfSegments, int maxNumberOfSegments, boolean checkApproximation1, boolean checkApproximation2, boolean checkApproximation3, boolean checkApproximation4) {
        this.maxNodesValuation = maxNodesValuation;
        this.minNumberOfSegments = minNumberOfSegments;
        this.maxNumberOfSegments = maxNumberOfSegments;
        this.checkApproximation1 = checkApproximation1;
        this.checkApproximation2 = checkApproximation2;
        this.checkApproximation3 = checkApproximation3;
        this.checkApproximation4 = checkApproximation4;
    }

    public int getMaxNodesValuation() {
        return maxNodesValuation;
    }

    public void setMaxNodesValuation(int maxNodesValuation) {
        this.maxNodesValuation = maxNodesValuation;
    }

    public int getMinNumberOfSegments() {
        return minNumberOfSegments;
    }

    public void setMinNumberOfSegments(int minNumberOfSegments) {
        this.minNumberOfSegments = minNumberOfSegments;
    }

    public int getMaxNumberOfSegments() {
        return maxNumberOfSegments;
    }

    public void setMaxNumberOfSegments(int maxNumberOfSegments) {
        this.maxNumberOfSegments = maxNumberOfSegments;
    }

    public boolean isCheckApproximation1() {
        return checkApproximation1;
    }

    public void setCheckApproximation1(boolean checkApproximation1) {
        this.checkApproximation1 = checkApproximation1;
    }

    public boolean isCheckApproximation2() {
        return checkApproximation2;
    }

    public void setCheckApproximation2(boolean checkApproximation2) {
        this.checkApproximation2 = checkApproximation2;
    }

    public boolean isCheckApproximation3() {
        return checkApproximation3;
    }

    public void setCheckApproximation3(boolean checkApproximation3) {
        this.checkApproximation3 = checkApproximation3;
    }

    public boolean isCheckApproximation4() {
        return checkApproximation4;
    }

    public void setCheckApproximation4(boolean checkApproximation4) {
        this.checkApproximation4 = checkApproximation4;
    }

}
