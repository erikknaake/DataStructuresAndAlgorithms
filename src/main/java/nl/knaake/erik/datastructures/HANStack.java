package nl.knaake.erik.datastructures;

public class HANStack<T> {

    private HANLinkedList<T> stack;

    public HANStack() {
        stack = new HANLinkedList<>();
    }

    public int getSize() {
        return stack.size();
    }

    public T pop() {
        T result = stack.get(0);
        stack.removeFirst();
        return result;
    }

    public T top() {
        return stack.get(0);
    }

    public void push(T item) {
        stack.addFirst(item);
    }

    @Override
    public String toString() {
        String result = "Stack:\n\t";
        result += stack.toString();
        return result;
    }
}
