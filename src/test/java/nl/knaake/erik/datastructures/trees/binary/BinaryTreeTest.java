package nl.knaake.erik.datastructures.trees.binary;

import nl.knaake.erik.datastructures.trees.Tree;
import nl.knaake.erik.datastructures.trees.TreeNode;
import nl.knaake.erik.datastructures.trees.binary.BinaryTree;
import nl.knaake.erik.datastructures.trees.binary.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void treeNumberOfLeavesOneLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        assertEquals(2, tree.numberOfLeaves());
    }

    @Test
    public void treeNumberOfLeavesMultiLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        tree.root.left.setLeft("Hello3");
        tree.root.left.setRight("Hello4");
        assertEquals(3, tree.numberOfLeaves());
    }


    @Test
    public void treeNumberOfNodesOneLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        assertEquals(3, tree.numberOfNodes()); // Count the root as well
    }

    @Test
    public void treeNumberOfNodesMultiLevelOfChild() {
        tree.root.setLeft("Hello");
        tree.root.setRight("Hello2");
        tree.root.left.setLeft("Hello3");
        tree.root.left.setRight("Hello4");
        assertEquals(5, tree.numberOfNodes()); // Count the root as well
    }

    @Test
    public void toStringTest() {
        assertEquals("BinaryTree{root=BinaryTreeNode{value=null, left=null, right=null}}", tree.toString());
    }

    @Test
    public void equalToSelf() {
        assertEquals(tree, tree);
    }

    @Test
    public void notEqualToOther() {
        BinaryTree<String> tree1= new BinaryTree<>("Hello");
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
        BinaryTreeNode<String> node = new BinaryTreeNode<>("hello");
        assertEquals(node, node);
    }

    @Test
    public void nodeNotEqualToOther() {
        BinaryTreeNode<String> node = new BinaryTreeNode<>("hello");
        BinaryTreeNode<String> node1 = new BinaryTreeNode<>("hello2");
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
        assertNotEquals(null, new BinaryTreeNode<>("hello"));
    }
}
