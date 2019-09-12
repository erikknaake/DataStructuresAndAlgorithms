package nl.knaake.erik;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void addShouldIncreaseSize() {
        ErikArrayList<String> list = new ErikArrayList<>();
        list.add("a");
        assertEquals(list.size(), 1);
    }

    @Test
    public void shouldAddAndGetItem() {
        ErikArrayList<String> list = new ErikArrayList<>(12);
        list.add("a");
        assertEquals(list.get(0), "a");
    }

    @Test
    public void shouldSetItem() {
        ErikArrayList<String> list = new ErikArrayList<>(12);
        list.add("a");
        list.add("b");
        list.add("c");
        list.set("d", 1);
        assertEquals(list.get(1), "d");
    }

    @Test
    public void shouldClearArray() {
        ErikArrayList<String> list = new ErikArrayList<>(12);
        list.add("a");
        list.add("b");
        list.add("c");
        list.clear();
        assertEquals(list.size(), 0);
        assertEquals(list.get(0), null);
    }
}
