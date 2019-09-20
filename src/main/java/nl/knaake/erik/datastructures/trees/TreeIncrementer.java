package nl.knaake.erik.datastructures.trees;

public class TreeIncrementer implements IApplyTree<Integer, Void> {
    @Override
    public Void apply(Tree<Integer> tree) {
        return apply(tree.root);
    }

    @Override
    public Void apply(TreeNode<Integer> node) {
        if(node.value != null)
            node.value++;
        if(node.nextSibling != null)
            apply(node.nextSibling);
        if(node.firstChild != null)
            apply(node.firstChild);
        return null;
    }
}
