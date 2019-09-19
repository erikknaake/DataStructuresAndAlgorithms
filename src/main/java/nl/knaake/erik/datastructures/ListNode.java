package nl.knaake.erik.datastructures;

public class ListNode<T> {
    ListNode next;
    T value;

    ListNode(T value) {
        this.value = value;
    }
    ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}