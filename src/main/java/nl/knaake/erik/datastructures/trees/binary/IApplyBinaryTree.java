package nl.knaake.erik.datastructures.trees.binary;

import org.jetbrains.annotations.NotNull;

public interface IApplyBinaryTree<T, U> {
    U apply(@NotNull BinaryTree<T> tree);
    U apply(@NotNull BinaryTreeNode<T>node );
}
