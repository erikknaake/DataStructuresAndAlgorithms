package nl.knaake.erik.datastructures.trees;

import org.jetbrains.annotations.NotNull;

public class TreeLeaveCounter<T> implements IApplyTree<T, Integer> {

    @Override
    public Integer apply(@NotNull Tree<T> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(@NotNull TreeNode<T> node) {
        int currentNumber = 0;
        if(node.firstChild != null)
            currentNumber += apply(node.firstChild);
        else
            currentNumber++;
        if(node.nextSibling != null)
            currentNumber += apply(node.nextSibling);
        return currentNumber;
    }
}
