package nl.knaake.erik;

import java.util.List;

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

    private ListNode header = new ListNode(null);

    public void addFirst(T item) {
        header.next = new ListNode(item, header.next);
    }

    public void removeFirst() {
        if(header.next != null) {
            header.next = header.next.next;
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
    }

    public void delete(int index) {
        ListNode nodeBeforeDelete = findNode(index - 1);
        nodeBeforeDelete.next = nodeBeforeDelete.next.next;
    }

    public void clear() {
        header.next = null; // GC does the rest
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public int size() {
        int i = 0;
        ListNode node = header;
        while(node.next != null) {
            node = node.next;
            i++;
        }
        return i;
    }
}
