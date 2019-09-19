package nl.knaake.erik.datastructures;

// Note when making this in a final version the listnode should be an inner class and an iterator should be exposed.
public class HANLinkedList<T> {
    private int size;
    private ListNode<T> header = new ListNode(null);

    public void addFirst(T item) {
        header.next = new ListNode(item, header.next);
        size++;
    }

    public void removeFirst() {
        if(header.next != null) {
            header.next = header.next.next;
            size--;
        }
    }

    public ListNode<T> findNode(int index) {
        ListNode foundNode = header;
        for (int i = 0; i <= index; i++) {
            if(foundNode.next != null)
                foundNode = foundNode.next;
        }
        return foundNode;
    }


    public T get(int index) {
        ListNode result = findNode(index);
        return result == null ? null : (T)result.value;
    }

    public void insert(int index, T item) {
        ListNode foundNode = findNode(index - 1);
        foundNode.next = new ListNode(item, foundNode.next);
        size++;
    }

    public void delete(int index) {
        ListNode nodeBeforeDelete = findNode(index - 1);
        nodeBeforeDelete.next = nodeBeforeDelete.next.next;
        size--;
    }

    public void clear() {
        header.next = null; // GC does the rest
        size = 0;
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("LinkedList:\n");
        if(size() == 0) {
            result.append("Empty\n");
            return result.toString();
        }
        ListNode node = header;
        int i = 0;
        while(node.next != null) {
            node = node.next;
            result.append("\t").append(i).append(": ").append(node.value).append("\n");
            i++;
        }
        return result.toString();
    }
}
