package nl.knaake.erik.datastructures.trees;

import nl.knaake.erik.datastructures.trees.binary.BinaryTree;
import nl.knaake.erik.datastructures.trees.binary.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class TreeTest {

    private Tree<String> tree;

    @Before
    public void before() {
        tree = new Tree<>();
    }

    @Test
    public void addChild() {
        tree.root.addChild("Hello");
        assertEquals("Hello", tree.root.firstChild.value);
    }

    @Test
    public void removeFirstChild() {
        tree.root.addChild("Hello");
        tree.root.removeFirstChild();
        assertNull(tree.root.firstChild);
    }

    @Test
    public void removeFirstChildOtherChildrenShouldBeKept() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.removeFirstChild();
        assertEquals("Hello2", tree.root.firstChild.value);
    }

    @Test
    public void removeAllChildren() {
        tree.root.addChild("Hello");
        tree.root.removeAllChildren();
        assertNull(tree.root.firstChild);
    }

    @Test
    public void removeAllChildMultipleChildren() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.removeAllChildren();
        assertNull(tree.root.firstChild);
    }

    @Test
    public void removeAllSiblings() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.removeSiblings();
        assertNull(tree.root.firstChild.nextSibling);
    }

    @Test
    public void removeAllSiblingsMultipleSiblings() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.addChild("Hello3");
        tree.root.firstChild.removeSiblings();
        assertNull(tree.root.firstChild.nextSibling);
    }

    @Test
    public void removeFirstSibling() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.removeFirstSibling();
        assertNull(tree.root.firstChild.nextSibling);
    }

    @Test
    public void removeFirstSiblingMultipleSiblings() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.addChild("Hello3");
        tree.root.firstChild.removeFirstChild();
        assertEquals("Hello3", tree.root.firstChild.nextSibling.value);
    }

    @Test
    public void initializeRootValue() {
        tree = new Tree<>("Hello");
        assertEquals("Hello", tree.root.value);
    }

    @Test
    public void initializeRootNode() {
        tree = new Tree<>(new TreeNode<>("Hello"));
        assertEquals("Hello", tree.root.value);
    }

    @Test
    public void initializeNode() {
        TreeNode<String> node = new TreeNode<>("Hello");
        assertEquals("Hello", node.value);
    }

    @Test
    public void initializeNodeWithSibling() {
        TreeNode<String> node = new TreeNode<>("Hello", new TreeNode<>("Hello2"));
        assertEquals("Hello", node.value);
        assertEquals("Hello2", node.nextSibling.value);
    }

    @Test
    public void toStringTest() {
        assertEquals("Tree{root=TreeNode{nextSibling=null, firstChild=null}}", tree.toString());
    }

    @Test
    public void treeNumberOfLeavesOneLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        assertEquals(2, tree.numberOfLeaves());
    }

    @Test
    public void treeNumberOfLeavesMultiLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.addChild("Hello3");
        tree.root.firstChild.addChild("Hello4");
        assertEquals(3, tree.numberOfLeaves());
    }

    @Test
    public void treeNumberOfNodesOneLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        assertEquals(3, tree.numberOfNodes()); // Count the root as well
    }

    @Test
    public void treeNumberOfNodesMultiLevelOfChild() {
        tree.root.addChild("Hello");
        tree.root.addChild("Hello2");
        tree.root.firstChild.addChild("Hello3");
        tree.root.firstChild.addChild("Hello4");
        assertEquals(5, tree.numberOfNodes()); // Count the root as well
    }

    @Test
    public void equalToSelf() {
        assertEquals(tree, tree);
    }

    @Test
    public void notEqualToOther() {
        Tree<String> tree1= new Tree<>("Hello");
        assertNotEquals(tree1, tree);
    }

    @Test
    public void notEqualType() {
        String str = "";
        assertNotEquals(str, tree);
    }

    @Test
    public void notEqualToNull() {
        assertNotEquals(null, tree);
    }

    @Test
    public void nodeEqualToSelf() {
        TreeNode<String> node = new TreeNode<>("hello");
        assertEquals(node, node);
    }

    @Test
    public void nodeNotEqualToOther() {
        TreeNode<String> node = new TreeNode<>("hello");
        TreeNode<String> node1 = new TreeNode<>("hello2");
        assertNotEquals(node, node1);
    }

    @Test
    public void nodeNotEqualType() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("hello");
        TreeNode<String> node1 = new TreeNode<>("hello");
        assertNotEquals(node, node1);
    }

    @Test
    public void nodeNotEqualToNull() {
        assertNotEquals(null, new TreeNode<>("hello"));
    }
}
