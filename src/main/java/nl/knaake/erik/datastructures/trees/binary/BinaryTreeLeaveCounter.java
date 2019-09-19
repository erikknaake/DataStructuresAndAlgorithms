package nl.knaake.erik.datastructures.trees.binary;

public class BinaryTreeLeaveCounter<T> implements IApplyBinaryTree<T, Integer> {
    @Override
    public Integer apply(BinaryTree<T> tree) {
        return apply(tree.root);
    }

    @Override
    public Integer apply(BinaryTreeNode<T> node) {
        int currentNumber = 0;
        if(node.left != null)
            currentNumber += apply(node.left);
        if(node.right != null)
            currentNumber += apply(node.right);
        if(node.left == null && node.right == null)
            currentNumber++;
        return currentNumber;
    }
}
