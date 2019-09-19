package nl.knaake.erik.datastructures.trees.binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeLeaveCounterTest {

    private BinaryTree<String> tree;
    private IApplyBinaryTree<String, Integer> applier;

    @Before
    public void before() {
        tree = new BinaryTree<>();
        applier = new BinaryTreeLeaveCounter<>();
    }

    @Test
    public void treeNumberOfLeavesOneLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        assertEquals(Integer.valueOf(2), applier.apply(tree));
    }

    @Test
    public void treeNumberOfLeavesMultiLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        tree.root.left.setLeft("Hello3");
        tree.root.left.setRight("Hello4");
        assertEquals(Integer.valueOf(3), applier.apply(tree));
    }
}
