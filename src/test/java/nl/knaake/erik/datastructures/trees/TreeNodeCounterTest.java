package nl.knaake.erik.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeNodeCounterTest {

    private Tree<String> tree;
    private IApplyTree<String, Integer> applier;

    @Before
    public void before() {
        tree = new Tree<>();
        applier = new TreeNodeCounter<>();
    }

    @Test
    public void treeNumberOfNodesOneLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        assertEquals(Integer.valueOf(3), applier.apply(tree)); // Count the root as well
    }

    @Test
    public void treeNumberOfNodesMultiLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.addChild("Hello3");
        tree.root.firstChild.addChild("Hello4");
        assertEquals(Integer.valueOf(5), applier.apply(tree)); // Count the root as well
    }

}
