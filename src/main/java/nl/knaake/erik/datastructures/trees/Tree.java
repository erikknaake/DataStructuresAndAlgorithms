package nl.knaake.erik.datastructures.trees;

import java.util.Objects;

/**
 * Not encapsulated with getters and setters since that will cause too much overhead (in creating stackframes)
 * when creating large trees
 * @param <T> Type of objects to store inside the tree.
 */
public class Tree<T> {
    public TreeNode<T> root;

    @Override
    public String toString() {
        return "Tree{root=" + root + "}";
    }

    public Tree() {
        root = new TreeNode<>(null);
    }

    public Tree(T rootValue) {
        root = new TreeNode<>(rootValue);
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public int numberOfLeaves() {
        return root.numberOfLeaves();
    }

    public int numberOfNodes() {
        return root.numberOfNodes();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(root, tree.root);
    }
}
