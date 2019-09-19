package nl.knaake.erik.datastructures;

import java.util.Arrays;

public class HANQueue<T> {
    private T[] queue;
    private int size;
    private int front;
    private int back;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public HANQueue() {
        queue = makeNewArray(DEFAULT_INITIAL_CAPACITY);
        makeEmpty();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        front = 0;
        back = -1;
        size = 0;
    }

    public T dequeue() {
        if(isEmpty())
            return null;
        size--;
        T result = queue[front];
        front = increment(front);
        return result;
    }

    public T getFront() {
        if(isEmpty())
            return null;
        return queue[front];
    }

    public void enqueue(T item) {
        if(size == queue.length)
            doubleQueue();
        back = increment(back);
        queue[back] = item;
        size++;
    }

    private T[] makeNewArray(int size) {
        return (T[])new Object[size];
    }

    private void doubleQueue() {
        T[] newQueue = makeNewArray(queue.length * 2);
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        for(int i = 0; i < size; i++)
            front = increment(front);
        queue = newQueue;
        front = 0;
        back = size - 1;
    }

    private int increment(int x) {
        if(++x == queue.length)
            x = 0;
        return x;
    }

    @Override
    public String toString() {
        return "HANQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", size=" + size +
                ", front=" + front +
                ", back=" + back +
                '}';
    }
}
