package nl.knaake.erik.datastructures.trees.binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @Before
    public void before() {
        tree = new BinarySearchTree<>(4);
    }

    @Test
    public void insert() {
        assertEquals(Integer.valueOf(4), tree.findMin());
    }

    @Test
    public void findMin() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(10);
        assertEquals(Integer.valueOf(2), tree.findMin());
    }

    @Test
    public void findMax() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(15);
        tree.insert(10);
        assertEquals(Integer.valueOf(15), tree.findMax());
    }

    @Test
    public void insertDuplicate() {
        tree.insert(1);
        tree.insert(5);
        tree.insert(4); // Duplicate
        assertEquals(Integer.valueOf(1), tree.findMin());
        assertEquals(Integer.valueOf(5), tree.findMax());
    }

    @Test
    public void findMinOnEmptyTree() {
        tree.remove(4);
        assertNull(tree.findMin());
    }

    @Test
    public void findMaxOnEmptyTree() {
        tree.remove(4);
        assertNull(tree.findMax());
    }

    @Test
    public void removeToNonEmptyTree() {
        tree.insert(3);
        tree.remove(4);
        assertEquals(Integer.valueOf(3), tree.findMax());
        assertEquals(Integer.valueOf(3), tree.findMin());
    }

    @Test
    public void removeMin() {
        tree.insert(3);
        tree.insert(5);
        tree.removeMin();
        assertEquals(Integer.valueOf(4), tree.findMin());
    }

    @Test
    public void removeMax() {
        tree.insert(3);
        tree.insert(5);
        tree.removeMax();
        assertEquals(Integer.valueOf(4), tree.findMax());
    }

    @Test
    public void removeLeftMost() {
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(1);
        assertEquals(Integer.valueOf(2), tree.findMin());
    }

    @Test
    public void removeRightMost() {
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(7);
        assertEquals(Integer.valueOf(6), tree.findMax());
    }

    @Test
    public void removeLeftRight() {
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(3);
        assertEquals(Integer.valueOf(7), tree.findMax());
        assertEquals(Integer.valueOf(1), tree.findMin());
    }

    @Test
    public void removeRightLeft() {
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(5);
        assertEquals(Integer.valueOf(7), tree.findMax());
        assertEquals(Integer.valueOf(1), tree.findMin());
    }

    @Test
    public void removeRootValue() {
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.remove(4);
        assertEquals(Integer.valueOf(1), tree.findMin());
        assertEquals(Integer.valueOf(7), tree.findMax());
    }

    @Test
    public void toStringTest() {
        assertEquals("BinarySearchTree{root=BinarySearchNode{left=null, right=null, value=4}}", tree.toString());
    }
}