package nl.knaake.erik.datastructures;

import java.util.Collection;

public class ErikArrayList<T> {
    private T[] array;
    private int size;
    private static int DEFAULT_INITIAL_CAPACITY = 16;

    public ErikArrayList() {
        clear(DEFAULT_INITIAL_CAPACITY);
    }

    public void clear() {
        clear(DEFAULT_INITIAL_CAPACITY);
    }

    public void clear(int newSize) {
        size = 0;
        array = createArray(newSize);
    }

    private T[] createArray(int size) {
        return (T []) new Object[size];
    }

    public void add(T item) {
        if(array.length == size)
        {
            T[] old = array;
            array = createArray(array.length * 2);
            System.arraycopy(old, 0, array, 0, old.length);
        }
        array[size++] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T item) {
        array[index] = item;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ArrayList:\n");
        if(size == 0) {
            result.append("Empty\n");
            return result.toString();
        }
        for(int i = 0; i < size; i++)
            result.append("\t").append(i).append(": ").append(array[i]).append("\n");
        return result.toString();
    }
}
