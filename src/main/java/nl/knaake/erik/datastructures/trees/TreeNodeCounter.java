package nl.knaake.erik.datastructures.trees;

public class TreeNodeCounter<T> implements IApplyTree<T, Integer> {
    @Override
    public Integer apply(Tree<T> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(TreeNode<T> node) {
        int currentNumber = 1;
        if(node.firstChild != null)
            currentNumber += apply(node.firstChild);
        if(node.nextSibling != null)
            currentNumber += apply(node.nextSibling);
        return currentNumber;
    }
}
