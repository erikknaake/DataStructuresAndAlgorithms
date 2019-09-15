package nl.knaake.erik.datastructures;

import java.util.Collection;

public class ErikArrayList<T> {
    private T[] array;
    private int size;
    private static int DEFAULT_INITIAL_CAPACITY = 16;

    public ErikArrayList() {
        clear(DEFAULT_INITIAL_CAPACITY);
    }

    public ErikArrayList(int initialSize) {
        clear(initialSize);
    }

    public ErikArrayList(Collection<? extends T> other) {
        clear(DEFAULT_INITIAL_CAPACITY);
        for(T obj: other)
            add(obj);
    }

    public ErikArrayList(Collection<? extends T> other, int initialSize) {
        clear(initialSize);
        for(T obj: other)
            add(obj);
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
            for(int i = 0; i < old.length; i++)
                array[i] = old[i];
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
}
