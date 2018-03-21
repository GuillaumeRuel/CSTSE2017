package navigation;

public enum NAVIGATION_DIRECTION {
    NORTH(1), SOUTH(2), EAST(3), WEST(4);

    private int numVal;
    NAVIGATION_DIRECTION(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
