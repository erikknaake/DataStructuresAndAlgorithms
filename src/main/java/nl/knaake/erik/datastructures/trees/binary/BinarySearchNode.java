package nl.knaake.erik.datastructures.trees.binary;

import java.util.Objects;

public class BinarySearchNode<T extends Comparable<? super T>> {
    BinarySearchNode(T value) {
        this.value = value;
    }

    BinarySearchNode() {
    }

    BinarySearchNode<T> left;
    BinarySearchNode<T> right;
    public T value;

    public static <T extends Comparable<? super T>> BinarySearchNode insert(T value, BinarySearchNode node) {
        if(node == null)
            node = new BinarySearchNode<T>(value);
        else if(value.compareTo((T)node.value) < 0)
            node.left = insert(value, node.left);
        else if(value.compareTo((T)node.value) > 0)
            node.right = insert(value, node.right);
        return node;
    }

    public static <T extends Comparable<? super T>>  BinarySearchNode findMin(BinarySearchNode node) {
        if(node.left != null)
            return findMin(node.left);
        else
            return node;
    }

    public static <T extends Comparable<? super T>> BinarySearchNode findMax(BinarySearchNode node) {
        if(node.right != null)
            return findMax(node.right);
        else
            return node;
    }

    public static <T extends Comparable<? super T>> BinarySearchNode removeMin(BinarySearchNode node) {
        if(node.left != null) {
            node.left = removeMin(node.left);
            return node;
        }
        return node.right;
    }

    public static <T extends Comparable<? super T>> BinarySearchNode removeMax(BinarySearchNode node) {
        if(node.right != null) {
            node.right = removeMax(node.right);
            return node;
        }
        return node.left;
    }

    public static <T extends Comparable<? super T>> BinarySearchNode remove(T value, BinarySearchNode node) {
        if(value.compareTo((T)node.value) < 0)
            node.left = remove(value, node.left);
        else if(value.compareTo((T)node.value) > 0)
            node.right = remove(value, node.right);
        else if(node.left != null && node.right != null) {
            node.value = findMin(node.right).value;
            node.right = removeMin(node.right);
        } else
            node = (node.left != null) ? node.left : node.right;
        return node;
    }

    @Override
    public String toString() {
        return "BinarySearchNode{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchNode<?> that = (BinarySearchNode<?>) o;
        return Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(value, that.value);
    }

}