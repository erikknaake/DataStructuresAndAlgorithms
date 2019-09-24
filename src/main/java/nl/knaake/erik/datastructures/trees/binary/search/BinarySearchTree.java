package nl.knaake.erik.datastructures.trees.binary.search;

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
            if(node != null) {
                if(node.left != null)
                    findMin(node.left);
                else
                    return node;
            }
            return null;
        }

        BinarySearchNode findMax(BinarySearchNode node) {
            if(node != null) {
                if(node.right != null)
                    findMin(node.right);
                else
                    return node;
            }
            return null;
        }

//        BinarySearchNode find(T value, BinarySearchNode node) {
//            if(node == null)
//                return null;
//            int compareResult = value.compareTo(node.value);
//            if(compareResult == 0)
//                return node;
//            else if(compareResult < 0)
//                return find(value, node.left);
//            else
//                return find(value, node.right);
//        }

        BinarySearchNode removeMin(BinarySearchNode node) {
            if(node.left != null) {
                node.left = removeMin(node.left);
                return node;
            }
            return node.right;
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
    }

    private BinarySearchNode root;

    public void insert(T value) {
        root = root.insert(value, root);
    }

    public void remove(T value) {
        root = root.remove(value, root);
    }

    public T findMin() {
        return root.findMin(root).value;
    }

    public T findMax() {
        return root.findMax(root).value;
    }
}
