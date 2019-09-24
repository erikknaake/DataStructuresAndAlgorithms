package nl.knaake.erik.datastructures.trees.binary;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private class BinarySearchNode {
        BinarySearchNode(T value) {
            this.value = value;
        }

        BinarySearchNode left;
        BinarySearchNode right;
        T value;

        BinarySearchNode insert(T value, BinarySearchNode node) {
            if(node == null)
                node = new BinarySearchNode(value);
            else if(value.compareTo(node.value) < 0)
                node.left = insert(value, node.left);
            else if(value.compareTo(node.value) > 0)
                node.right = insert(value, node.right);
            return node;
        }

        BinarySearchNode findMin(BinarySearchNode node) {
            if(node.left != null)
                return findMin(node.left);
            else
                return node;
        }

        BinarySearchNode findMax(BinarySearchNode node) {
            if(node.right != null)
                return findMax(node.right);
            else
                return node;
        }

        BinarySearchNode removeMin(BinarySearchNode node) {
            if(node.left != null) {
                node.left = removeMin(node.left);
                return node;
            }
            return node.right;
        }

        BinarySearchNode removeMax(BinarySearchNode node) {
            if(node.right != null) {
                node.right = removeMax(node.right);
                return node;
            }
            return node.left;
        }

        BinarySearchNode remove(T value, BinarySearchNode node) {
            if(value.compareTo(node.value) < 0)
                node.left = remove(value, node.left);
            else if(value.compareTo(node.value) > 0)
                node.right = remove(value, node.right);
            else if(node.left != null && node.right != null) {
                node.value = findMin(node.right).value;
                node.right = removeMin(node.right);
            } else
                node = (node.left != null) ? node.left : node.right;
            return node;
        }

        @Override
        public String toString() {
            return "BinarySearchNode{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }

    private BinarySearchNode root;

    public BinarySearchTree(T value) {
        root = new BinarySearchNode(value);
    }

    public void insert(T value) {
        root = root.insert(value, root);
    }

    public void remove(T value) {
        root = root.remove(value, root);
    }

    public T findMin() {
        if(root == null)
            return null;
        BinarySearchNode node = root.findMin(root);
        return node == null ? null : node.value;
    }

    public T findMax() {
        if(root == null)
            return null;
        BinarySearchNode node = root.findMax(root);
        return node == null ? null : node.value;
    }

    public void removeMin() {
        root = root.removeMin(root);
    }

    public void removeMax() {
        root = root.removeMax(root);
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
