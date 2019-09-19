package nl.knaake.erik.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeLeafNodeCounterTest {

    private Tree<String> tree;
    private IApplyTree<String, Integer> applier;

    @Before
    public void before() {
        tree = new Tree<>();
        applier = new TreeLeaveCounter<>();
    }

    @Test
    public void treeNumberOfLeavesOneLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        assertEquals(Integer.valueOf(2), applier.apply(tree));
    }

    @Test
    public void treeNumberOfLeavesMultiLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.addChild("Hello3");
        tree.root.firstChild.addChild("Hello4");
        assertEquals(Integer.valueOf(3), applier.apply(tree));
    }
}
