package nl.knaake.erik.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeIncrementerTest {
    private Tree<Integer> tree;
    private IApplyTree<Integer, Void> applier;

    @Before
    public void before() {
        tree = new Tree<>();
        applier = new TreeIncrementer();
    }

    @Test
    public void incrementOneLevelOfChildren() {
        Tree<Integer> expected = new Tree<>();
        expected.root.addChild(2);
        expected.root.addChild(3);

        tree.root.addChild(1);
        tree.root.addChild(2);

        applier.apply(tree);
        assertEquals(expected, tree);
    }

    @Test
    public void incrementShouldIncrementRoot() {
        Tree<Integer> expected = new Tree<>();
        expected.root.value = 1;
        expected.root.addChild(2);
        expected.root.addChild(3);

        tree.root.value = 0;
        tree.root.addChild(1);
        tree.root.addChild(2);

        applier.apply(tree);
        assertEquals(expected, tree);
    }

    @Test
    public void incrementMultiLevelOfChild() {
        Tree<Integer> expected = new Tree<>();
        expected.root.addChild(3);
        expected.root.addChild(4);
        expected.root.firstChild.addChild(5);
        expected.root.firstChild.addChild(6);

        tree.root.addChild(2);
        tree.root.addChild(3);
        tree.root.firstChild.addChild(4);
        tree.root.firstChild.addChild(5);

        applier.apply(tree);
        assertEquals(expected, tree);
    }
}
