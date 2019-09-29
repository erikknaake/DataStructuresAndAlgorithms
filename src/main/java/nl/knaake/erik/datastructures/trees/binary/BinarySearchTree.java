package nl.knaake.erik.datastructures.trees.binary;

import nl.knaake.erik.sortingalgorithms.ISorter;
import nl.knaake.erik.sortingalgorithms.QuickSorter;

import java.util.Arrays;
import java.util.Objects;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinarySearchNode<T> root;

    public BinarySearchTree(T value) {
        root = new BinarySearchNode<>(value);
    }

    public BinarySearchTree() {
        root = new BinarySearchNode<>();
    }


    public void insert(T value) {
        root = BinarySearchNode.insert(value, root);
    }

    public void remove(T value) {
        root = BinarySearchNode.remove(value, root);
    }

    public T findMin() {
        if(root == null)
            return null;
        BinarySearchNode node = BinarySearchNode.findMin(root);
        return node == null ? null : (T)node.value;
    }

    public T findMax() {
        if(root == null)
            return null;
        BinarySearchNode node = BinarySearchNode.findMax(root);
        return node == null ? null : (T)node.value;
    }

    public void removeMin() {
        root = BinarySearchNode.removeMin(root);
    }

    public void removeMax() {
        root = BinarySearchNode.removeMax(root);
    }

    public static <T extends Comparable<? super T>> BinarySearchTree<T> fromArray(T[] input) {
        ISorter sorter = new QuickSorter();
        sorter.sort(input);
        return fromSortedArray(input);
    }

    public static <T extends Comparable<? super T>> BinarySearchTree<T> fromSortedArray(T[] input) {
        BinarySearchTree<T> newTree = new BinarySearchTree<>();
        setNodesFromSortedArray(input, newTree.root);
        return newTree;
    }

    private static <T extends Comparable<? super T>> BinarySearchNode<T> setNodesFromSortedArray(T[] input, BinarySearchNode<T> root) {
        if(root == null) {
            root = new BinarySearchNode<>();
        }
        if(input.length <= 1) {
            if(input.length == 1)
                root.value = input[0];
            return root;
        }
        root.value = input[input.length / 2];
        root.left = setNodesFromSortedArray(Arrays.copyOfRange(input, 0, input.length / 2), root.left);
        root.right = setNodesFromSortedArray(Arrays.copyOfRange(input, input.length / 2 + 1, input.length), root.right);
        return root;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree<?> that = (BinarySearchTree<?>) o;
        return Objects.equals(root, that.root);
    }

}
