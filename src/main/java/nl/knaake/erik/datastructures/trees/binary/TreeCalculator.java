package nl.knaake.erik.datastructures.trees.binary;

import org.jetbrains.annotations.NotNull;

public class TreeCalculator implements IApplyBinaryTree<String, Integer> {
    @Override
    public Integer apply(@NotNull BinaryTree<String> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(@NotNull BinaryTreeNode<String> node) {
        switch (node.value) {
            case "*":
                return apply(node.left) * apply(node.right);
            case "/":
                return apply(node.left) / apply(node.right);
            case "%":
                return apply(node.left) % apply(node.right);
            case "-":
                return apply(node.left) - apply(node.right);
            case "+":
                return apply(node.left) + apply(node.right);
            default:
                return Integer.valueOf(node.value);
        }
    }
}
