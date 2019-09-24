package nl.knaake.erik.sortingalgorithms;

public final class MergeSorter extends AbstractSorter {
    private final void merge(int[] arr, int l, int m, int r, ESortOrder sortOrder)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int [n1];
        int[] R = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (compare(L[i], R[j], sortOrder))
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private final void mergeSort(int[] arr, int l, int r, ESortOrder sortOrder)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m, sortOrder);
            mergeSort(arr , m+1, r, sortOrder);

            // Merge the sorted halves
            merge(arr, l, m, r, sortOrder);
        }
    }

    @Override
    public final void sort(int[] list, ESortOrder sortOrder) {
        mergeSort(list, 0, list.length - 1, sortOrder);
    }

    @Override
    public final <T extends Comparable<? super T>> void sort(T[] list, ESortOrder sortOrder) {
        mergeSort(list, 0, list.length - 1, sortOrder);
    }

    private final <T extends Comparable<? super T>> void merge(T[] arr, int l, int m, int r, ESortOrder sortOrder)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Comparable[] L = new Comparable[n1]; // TODO find a way to do this generic
        Comparable[] R = new Comparable[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (compare(L[i], R[j], sortOrder))
            {
                arr[k] = (T) L[i];
                i++;
            }
            else
            {
                arr[k] = (T) R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = (T) L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = (T) R[j];
            j++;
            k++;
        }
    }

    private final <T extends Comparable<? super T>> void mergeSort(T[] arr, int l, int r, ESortOrder sortOrder)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m, sortOrder);
            mergeSort(arr , m+1, r, sortOrder);

            // Merge the sorted halves
            merge(arr, l, m, r, sortOrder);
        }
    }

}
