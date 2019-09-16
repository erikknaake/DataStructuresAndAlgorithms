package nl.knaake.erik.datastructures;

public class HANLinkedList<T> {
    class ListNode {
        ListNode next;
        T value;

        ListNode(T value) {
            this.value = value;
        }
        ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private ListNode header = new ListNode(null);

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

    private ListNode findNode(int index) {
        ListNode foundNode = header;
        for (int i = 0; i <= index; i++) {
            if(foundNode.next != null)
                foundNode = foundNode.next;
        }
        return foundNode;
    }

    public T get(int index) {
        ListNode result = findNode(index);
        return result == null ? null : result.value;
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
