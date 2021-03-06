package nl.knaake.erik.sortingalgorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SorterTest {

    private ISorter sorter;

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new InsertionSorter()},
                new Object[]{new QuickSorter()},
                new Object[]{new MergeSorter()}
        );
    }

    public SorterTest(ISorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void testRandomList() {
        int[] expected = {1, 2, 3, 4, 5, 7, 9, 10, 11};
        int[] list = {1, 3, 2, 7, 5, 9, 11, 10, 4};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void emptyList() {
        int[] expected = {};
        int[] list = {};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void onlySameValues() {
        int[] expected = {2, 2, 2, 2, 2};
        int[] list = {2, 2, 2, 2, 2};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void setsOfSameValues() {
        int[] expected = {2, 2, 2, 3, 3, 3, 5, 6, 6};
        int[] list = {2, 2, 3, 5, 6, 2, 3, 6, 3};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }
}
