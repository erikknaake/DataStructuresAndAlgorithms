package nl.knaake.erik.datastructures.trees.binary;

/**
 * Not encapsulated with getters and setters since that will cause too much overhead (in creating stackframes)
 * when creating large trees
 * @param <T> Type of objects to store inside the tree.
 */
public class BinaryTree<T> {
    public BinaryTreeNode<T> root;

    public BinaryTree() {
        root = new BinaryTreeNode<>(null);
    }

    public BinaryTree(T rootValue) {
        root = new BinaryTreeNode<>(rootValue);
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public int numberOfLeaves() {
        return root.numberOfLeaves();
    }

    public int numberOfNodes() {
        return root.numberOfNodes();
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
