package nl.knaake.erik.sortingalgorithms;

public final class QuickSorter extends AbstractSorter {

    @Override
    public final void sort(int[] list, ESortOrder sortOrder) {
        quickSort(list, 0, list.length - 1, sortOrder);
    }

    private final void quickSort(int[] list, int low, int high, ESortOrder sortOrder) {
        if(low < high)
        {
            int partitionIndex = partition(list, low, high, sortOrder);

            quickSort(list, low, partitionIndex - 1, sortOrder);
            quickSort(list, partitionIndex + 1, high, sortOrder);
        }
    }

    private final int partition(int[] arr, int low, int high, ESortOrder sortOrder)
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (compare(arr[j], pivot, sortOrder))
            {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, high, i+1);

        return i+1;
    }

    private final void swap(int[] list, int from, int to)
    {
        int temp = list[to];
        list[to] = list[from];
        list[from] = temp;
    }

    @Override
    public final <T extends Comparable<? super T>> void sort(T[] list, ESortOrder sortOrder) {
        quickSort(list, 0, list.length - 1, sortOrder);
    }

    private final <T extends Comparable<? super T>> void quickSort(T[] list, int low, int high, ESortOrder sortOrder) {
        if(low < high)
        {
            int partitionIndex = partition(list, low, high, sortOrder);

            quickSort(list, low, partitionIndex - 1, sortOrder);
            quickSort(list, partitionIndex + 1, high, sortOrder);
        }
    }

    private final <T extends Comparable<? super T>> int partition(T[] arr, int low, int high, ESortOrder sortOrder)
    {
        T pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (compare(arr[j], pivot, sortOrder))
            {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, high, i+1);

        return i+1;
    }

    private final <T extends Comparable<? super T>> void swap(T[] list, int from, int to)
    {
        T temp = list[to];
        list[to] = list[from];
        list[from] = temp;
    }
}
