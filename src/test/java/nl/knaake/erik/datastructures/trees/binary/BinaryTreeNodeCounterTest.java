package nl.knaake.erik.datastructures.trees.binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeNodeCounterTest {

    private BinaryTree<String> tree;
    private IApplyBinaryTree<String, Integer> applier;

    @Before
    public void before() {
        tree = new BinaryTree<>();
        applier = new BinaryTreeNodeCounter<>();
    }

    @Test
    public void treeNumberOfNodesOneLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        assertEquals(Integer.valueOf(3), applier.apply(tree)); // Count the root as well
    }

    @Test
    public void treeNumberOfNodesMultiLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        tree.root.left.setLeft("Hello3");
        tree.root.left.setRight("Hello4");
        assertEquals(Integer.valueOf(5), applier.apply(tree)); // Count the root as well
    }
}
