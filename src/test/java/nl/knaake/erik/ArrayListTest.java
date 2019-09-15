package nl.knaake.erik;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayListTest {
    private ErikArrayList<String> list;

    @Before
    public void before() {
        list = new ErikArrayList<>();
    }

    @Test
    public void addShouldIncreaseSize() {
        list.add("a");
        assertEquals(1, list.size());
    }

    @Test
    public void shouldAddAndGetItem() {
        list.add("a");
        assertEquals("a", list.get(0));
    }

    @Test
    public void shouldSetItem() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.set(1, "d");
        assertEquals("d", list.get(1));
    }

    @Test
    public void shouldClearArray() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.clear();
        assertEquals(0, list.size());
        assertNull(list.get(0));
    }

    @Test
    public void getShouldReturnNullWhenEmpty() {
        assertNull(list.get(0));
    }
}
