package nl.knaake.erik.datastructures.trees.binary;

public class BinaryTreeIncrementer implements IApplyBinaryTree<Integer, Void> {
    @Override
    public Void apply(BinaryTree<Integer> tree) {
        return apply(tree.root);
    }

    @Override
    public Void apply(BinaryTreeNode<Integer> node) {
        if(node.value != null)
            node.value++;
        if(node.left != null)
            apply(node.left);
        if(node.right != null)
            apply(node.right);
        return null;
    }
}
