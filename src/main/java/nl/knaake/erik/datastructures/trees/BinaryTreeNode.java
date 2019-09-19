package nl.knaake.erik.datastructures.trees;

/**
 * Not encapsulated with getters and setters since that will cause too much overhead (in creating stackframes)
 * when creating large trees
 * @param <T> Type of objects to store inside the tree.
 */
public class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, T left, T right) {
        this.value = value;
        this.left = new BinaryTreeNode<>(left);
        this.right = new BinaryTreeNode<>(right);
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void setLeft(T left) {
        setLeft(new BinaryTreeNode<>(left));
    }

    public void setRight(T right) {
        setRight(new BinaryTreeNode<>(right));
    }

    public int numberOfLeaves() {
        int currentNumber = 0;
        if(left != null)
            currentNumber += left.numberOfLeaves();
        if(right != null)
            currentNumber += right.numberOfLeaves();
        if(left == null && right == null)
            currentNumber++;
        return currentNumber;
    }

    public int numberOfNodes() {
        int currentNumber = 1;
        if(left != null)
            currentNumber += left.numberOfNodes();
        if(right != null)
            currentNumber += right.numberOfNodes();
        return currentNumber;
    }
}
