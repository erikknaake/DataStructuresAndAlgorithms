package nl.knaake.erik.datastructures.trees.binary.calculator;

import nl.knaake.erik.datastructures.trees.binary.BinaryTree;
import nl.knaake.erik.datastructures.trees.binary.BinaryTreeNode;
import nl.knaake.erik.datastructures.trees.binary.IApplyBinaryTree;
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
        }
        if(node.value.matches("-?\\d+")) {
            return Integer.valueOf(node.value);
        } else {
            throw new CalculatorException(node.value + " is not a valid string in this expression");
        }
    }
}
