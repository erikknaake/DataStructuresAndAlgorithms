package nl.knaake.erik.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinaryTreeTest {
    private BinaryTree<String> tree;

    @Before
    public void before() {
        tree = new BinaryTree<>();
    }

    @Test
    public void treeInit() {
        assertNull(tree.root.value);
    }

    @Test
    public void treeInitWithValue() {
        assertEquals("Hello", new BinaryTree<>("Hello").root.value);
    }

    @Test
    public void nodeInit() {
        assertEquals("Hello", new BinaryTreeNode<>("Hello").value);
    }

    @Test
    public void nodeInitWithChildValues() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("Hello", "Left", "Right");
        assertEquals("Hello", node.value);
        assertEquals("Left", node.left.value);
        assertEquals("Right", node.right.value);
    }

    @Test
    public void treeInitWithChildValues() {
        BinaryTree<String> tree = new BinaryTree<>(new BinaryTreeNode<>("Hello", "Left", "Right"));
        assertEquals("Hello", tree.root.value);
        assertEquals("Left", tree.root.left.value);
        assertEquals("Right", tree.root.right.value);
    }

    @Test
    public void nodeInitWithChildNodes() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("Hello", new BinaryTreeNode<>("Left"), new BinaryTreeNode<>("Right"));
        assertEquals("Hello", node.value);
        assertEquals("Left", node.left.value);
        assertEquals("Right", node.right.value);
    }

    @Test
    public void nodeSetLeft() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("Hello");
        node.setLeft("Left");
        assertEquals("Left", node.left.value);
    }

    @Test
    public void nodeSetRight() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("Hello");
        node.setRight("Right");
        assertEquals("Right", node.right.value);
    }
}
