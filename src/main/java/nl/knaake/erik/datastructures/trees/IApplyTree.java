package nl.knaake.erik.datastructures.trees;

public interface IApplyTree<T, U> {
    U apply(Tree<T> tree);
    U apply(TreeNode<T>node );
}
