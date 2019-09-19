package nl.knaake.erik.datastructures.trees;

public class TreeLeaveCounter<T> implements IApplyTree<T, Integer> {

    @Override
    public Integer apply(Tree<T> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(TreeNode<T> node) {
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
