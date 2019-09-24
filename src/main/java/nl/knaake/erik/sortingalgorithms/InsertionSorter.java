package nl.knaake.erik.sortingalgorithms;

public final class InsertionSorter extends AbstractSorter {
    @Override
    public final <T extends Comparable<? super T>> void sort(T[] list, ESortOrder sortOrder) {
        for (int i = 1; i < list.length; i++) {
            T toBeInserted = list[i];
            int j = i;
            while (j > 0 && compare(toBeInserted, list[j - 1], sortOrder)) {
                list[j] = list[j - 1];
                j--;
            }

            list[j] = toBeInserted;
        }
    }

    @Override
    public final void sort(int[] list, ESortOrder sortOrder) {
        // Could perhaps use the other sort in the future when casting int[] to Integer[] is more efficient
        for (int i = 1; i < list.length; i++) {
            int toBeInserted = list[i];

            int j = i;
            while (j > 0 && compare(toBeInserted, list[j - 1], sortOrder)) {
                list[j] = list[j - 1];
                j--;
            }

            list[j] = toBeInserted;
        }
    }
}
