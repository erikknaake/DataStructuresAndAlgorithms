package nl.knaake.erik.datastructures.trees;

/**
 * Not encapsulated with getters and setters since that will cause too much overhead (in creating stackframes)
 * when creating large trees
 * @param <T> Type of objects to store inside the tree.
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> nextSibling;
    public  TreeNode<T> firstChild;

    public TreeNode(T value, TreeNode<T> nextSibling) {
        this.value = value;
        this.nextSibling = nextSibling;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public void addChild(T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        if(firstChild == null)
            firstChild = newNode;
        else {
            newNode.nextSibling = firstChild.nextSibling;
            firstChild.nextSibling = newNode;
        }
    }

    public void removeFirstChild() {
        if(firstChild != null)
            firstChild = firstChild.nextSibling;
    }

    public void removeAllChildren() {
        firstChild = null;
    }

    public void removeSiblings() {
        nextSibling = null;
    }

    public void removeFirstSibling() {
        if(nextSibling != null)
            nextSibling = nextSibling.nextSibling;
    }

    @Override
    public String toString() {
        return "TreeNode{nextSibling=" + nextSibling + ", firstChild=" + firstChild + "}";
    }
}
