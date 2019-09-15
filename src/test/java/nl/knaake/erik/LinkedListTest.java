package nl.knaake.erik;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedListTest {
    private HANLinkedList<String> list;

    @Before
    public void before() {
        list = new HANLinkedList<>();
    }

    @Test
    public void addFirst() {
        list.addFirst("Hello");
        assertEquals("Hello", list.get(0));
    }

    @Test
    public void removeFirst() {
        list.addFirst("Hello");
        list.removeFirst();
        assertNull(list.get(0));
    }

    @Test
    public void insert() {
        list.addFirst("Hello");
        list.addFirst("Hello2");
        list.addFirst("Hello3");
        list.insert(1, "Hello4");
        assertEquals("Hello4", list.get(1));
    }

    @Test
    public void insertAtEnd() {
        list.addFirst("Hello");
        list.addFirst("Hello2");
        list.addFirst("Hello3");
        list.insert(2, "Hello4");
        assertEquals("Hello4", list.get(2));
    }

    @Test
    public void insertAtStart() {
        list.addFirst("Hello");
        list.addFirst("Hello2");
        list.addFirst("Hello3");
        list.insert(0, "Hello4");
        assertEquals("Hello4", list.get(0));
    }

    @Test
    public void size0() {
        assertEquals(0, list.size());
    }

    @Test
    public void size1() {
        list.addFirst("Hello");
        assertEquals(1, list.size());
    }


    @Test
    public void size() {
        list.addFirst("Hello");
        list.addFirst("Hello2");
        list.addFirst("Hello3");
        assertEquals(3, list.size());
    }

    @Test
    public void largerSize() {
        list.addFirst("Hello");
        list.addFirst("Hello2");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        list.addFirst("Hello3");
        assertEquals(9, list.size());
    }
}
