package nl.knaake.erik.sortingalgorithms;

public abstract class AbstractSorter implements ISorter {
    protected final <T extends Comparable<? super T>> boolean compare(T a, T b, ESortOrder sortOrder) {
        return a.compareTo(b) == sortOrder.value;
    }

    protected final boolean compare(int a, int b, ESortOrder sortOrder) {
        return (sortOrder.value == -1) ? (a < b) : (a > b);
    }

    @Override
    public final void sort(int[] list) {
        sort(list, ESortOrder.LOW_TO_HIGH);
    }

    public final <T extends Comparable<? super T>>  void sort(T[] list) {
        sort(list, ESortOrder.LOW_TO_HIGH);
    }
}
