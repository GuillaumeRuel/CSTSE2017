package navigation;

public enum ENTITY_TYPE{
    WALL(1), CUSTOMER(2), ESPRESSO_MACHINE(3), EMPTY(4);

    private int numVal;
    ENTITY_TYPE(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}

