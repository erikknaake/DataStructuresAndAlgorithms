package nl.knaake.erik.datastructures.trees.binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeIncrementerTest {
    private BinaryTree<Integer> tree;
    private IApplyBinaryTree<Integer, Void> applier;

    @Before
    public void before() {
        tree = new BinaryTree<>();
        applier = new BinaryTreeIncrementer();
    }

    @Test
    public void incrementOneLevelOfChildren() {
        BinaryTree<Integer> expected = new BinaryTree<>();
        expected.root.setLeft(2);
        expected.root.setRight(3);

        tree.root.setLeft(1);
        tree.root.setRight(2);

        applier.apply(tree);
        assertEquals(expected, tree);
    }

    @Test
    public void incrementShouldIncrementRoot() {
        BinaryTree<Integer> expected = new BinaryTree<>();
        expected.root.value = 1;
        expected.root.setLeft(2);
        expected.root.setRight(3);

        tree.root.value = 0;
        tree.root.setLeft(1);
        tree.root.setRight(2);

        applier.apply(tree);
        assertEquals(expected, tree);
    }

    @Test
    public void incrementMultiLevelOfChild() {
        BinaryTree<Integer> expected = new BinaryTree<>();
        expected.root.setLeft(3);
        expected.root.setRight(4);
        expected.root.left.setLeft(5);
        expected.root.left.setRight(6);

        tree.root.setLeft(2);
        tree.root.setRight(3);
        tree.root.left.setLeft(4);
        tree.root.left.setRight(5);

        applier.apply(tree);
        assertEquals(expected, tree);
    }
}
