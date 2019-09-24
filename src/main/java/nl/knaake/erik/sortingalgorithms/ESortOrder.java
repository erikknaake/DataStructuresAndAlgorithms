package nl.knaake.erik.sortingalgorithms;

public enum ESortOrder {
    LOW_TO_HIGH(-1),
    HIGH_TO_LOW(1);

    public final int value;

    private ESortOrder(int value) {
        this.value = value;
    }
}
