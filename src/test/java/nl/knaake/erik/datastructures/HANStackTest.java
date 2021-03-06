package nl.knaake.erik.datastructures;

import nl.knaake.erik.datastructures.HANStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HANStackTest {

    private HANStack<String> stack;

    @Before
    public void before() {
        stack = new HANStack<>();
    }

    @Test
    public void push() {
        stack.push("Hello");
        assertEquals("Hello", stack.top());
    }

    @Test
    public void size() {
        assertEquals(0, stack.getSize());
        stack.push("hello");
        assertEquals(1, stack.getSize());
        stack.push("hello2");
        assertEquals(2, stack.getSize());
    }

    @Test
    public void topShouldNotAffectSize() {
        stack.push("Hello");
        assertEquals(1, stack.getSize());
        stack.top();
        assertEquals(1, stack.getSize());
    }

    @Test
    public void popShouldAffectSize() {
        stack.push("Hello");
        assertEquals(1, stack.getSize());
        stack.pop();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void pushShouldReturnProperItem() {
        stack.push("hello");
        assertEquals("hello", stack.pop());
    }

    @Test
    public void pushShouldReturnProperItemMulti() {
        stack.push("hello");
        stack.push("hello2");
        assertEquals("hello2", stack.pop());
        assertEquals("hello", stack.pop());
    }

    @Test
    public void popEmptyStackShouldReturnNull() {
        assertNull(stack.pop());
    }

    @Test
    public void toStringTest() {
        stack.push("c");
        stack.push("b");
        stack.push("a");
        assertEquals("Stack:\n\tLinkedList:\n\t0: a\n\t1: b\n\t2: c\n", stack.toString());
    }

    @Test
    public void toStringTestEmpty() {
        assertEquals("Stack:\n\tLinkedList:\nEmpty\n", stack.toString());
    }
}
