package nl.knaake.erik.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HANQueueTest {
    private HANQueue<String> queue;

    @Before
    public void before() {
        queue = new HANQueue<>();
    }

    @Test
    public void enqueueTest() {
        queue.enqueue("Hello");
        assertEquals("Hello", queue.getFront());
    }

    @Test
    public void dequeueTest() {
        queue.enqueue("Hello");
        assertEquals("Hello", queue.dequeue());
    }

    @Test
    public void dequeueShouldReturnNullOnEmptyQueue() {
        assertNull(queue.dequeue());
    }

    @Test
    public void getFrontShouldReturnNullOnEmptyQueue() {
        assertNull(queue.getFront());
    }

    @Test
    public void emptySize() {
        assertEquals(0, queue.size());
    }

    @Test
    public void size() {
        queue.enqueue("Hello");
        assertEquals(1, queue.size());
    }

    @Test
    public void sizeAfterDequeue() {
        queue.enqueue("Hello");
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueLargerThenArrayTest() {
        for(int i = 0; i < 18; i++)
            queue.enqueue("Hello" + i);
        assertEquals(18, queue.size());
    }

    @Test
    public void makeEmptyShouldResetSize() {
        queue.enqueue("hello");
        queue.makeEmpty();
        assertEquals(0, queue.size());
    }

    @Test
    public void makeEmptyShouldPreventReadsToPreAllocated() {
        queue.enqueue("hello");
        queue.makeEmpty();
        assertNull(queue.getFront());
    }

    @Test
    public void overflow() {
        for(int i = 0; i < 16; i++)
            queue.enqueue("Hello" + i);
        queue.enqueue("HelloEn1");
        queue.enqueue("HelloEn2");
        for(int i = 0; i < 16; i++)
            assertEquals("Hello" + i, queue.dequeue());
        assertEquals("HelloEn1", queue.dequeue());
        assertEquals("HelloEn2", queue.dequeue());
    }

    @Test
    public void overflowAfterDequeue() {
        for(int i = 0; i < 15; i++)
            queue.enqueue("Hello" + i);
        queue.dequeue();
        queue.enqueue("HelloEn1");
        queue.enqueue("HelloEn2");
        for(int i = 1; i < 15; i++)
            assertEquals("Hello" + i, queue.dequeue());
        assertEquals("HelloEn1", queue.dequeue());
        assertEquals("HelloEn2", queue.dequeue());
    }
}
