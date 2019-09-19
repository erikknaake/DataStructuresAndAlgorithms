package nl.knaake.erik.datastructures.trees.binary;

import org.jetbrains.annotations.NotNull;

public class BinaryTreeNodeCounter<T> implements IApplyBinaryTree<T, Integer> {
    @Override
    public Integer apply(@NotNull BinaryTree<T> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(@NotNull BinaryTreeNode<T> node) {
        int currentNumber = 1;
        if(node.left != null)
            currentNumber += apply(node.left);
        if(node.right != null)
            currentNumber += apply(node.right);
        return currentNumber;
    }
}
