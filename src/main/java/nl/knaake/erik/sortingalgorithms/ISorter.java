package nl.knaake.erik.sortingalgorithms;

/**
 * Sorts an array of items in a given order
 */
public interface ISorter {
    /**
     * Sorts the list in the given order
     * @param list - List to sort, will be mutated
     * @param sortOrder, The order in which to sort the list
     * @param <T> - Any object that implements Comparable
     */
    <T extends Comparable<? super T>>  void sort(T[] list, ESortOrder sortOrder);

    /**
     * Sorts the list from low to high (by T.compareTo(T) == -1)
     * @param list - List to sort, will be mutated
     * @param <T> - Any object that implements Comparable
     */
    <T extends Comparable<? super T>>  void sort(T[] list);

    /**
     * Sorts the list in the given order
     * @param list - List to sort, will be mutated
     * @param sortOrder, The order in which to sort the list
     */
    void sort(int[] list, ESortOrder sortOrder);

    /**
     * Sorts the list from low to high (by a < b)
     * @param list - List to sort, will be mutated
     */
    void sort(int[] list);
}
