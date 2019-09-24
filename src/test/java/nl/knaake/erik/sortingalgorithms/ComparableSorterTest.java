package nl.knaake.erik.sortingalgorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ComparableSorterTest {

    private ISorter sorter;

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new InsertionSorter()},
                new Object[]{new QuickSorter()},
                new Object[]{new MergeSorter()}
        );
    }

    public ComparableSorterTest(ISorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void testRandomList() {
        // Integer implements the comparable interface
        Integer[] expected = {1, 2, 3, 4, 5, 7, 9, 10, 11};
        Integer[] list = {1, 3, 2, 7, 5, 9, 11, 10, 4};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void testRandomListWithExplicitSortOrder() {
        // Integer implements the comparable interface
        Integer[] expected = {1, 2, 3, 4, 5, 7, 9, 10, 11};
        Integer[] list = {1, 3, 2, 7, 5, 9, 11, 10, 4};
        sorter.sort(list, ESortOrder.LOW_TO_HIGH);

        assertArrayEquals(expected, list);
    }

    @Test
    public void emptyList() {
        Integer[] expected = {};
        Integer[] list = {};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void onlySameValues() {
        Integer[] expected = {2, 2, 2, 2, 2};
        Integer[] list = {2, 2, 2, 2, 2};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }

    @Test
    public void setsOfSameValues() {
        Integer[] expected = {2, 2, 2, 3, 3, 3, 5, 6, 6};
        Integer[] list = {2, 2, 3, 5, 6, 2, 3, 6, 3};
        sorter.sort(list);

        assertArrayEquals(expected, list);
    }
}
