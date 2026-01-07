package GenericArrayList;

import java.util.ArrayList;

public class GenericArrayList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    private int getCapacity() {
        return array.length;
    }

    private boolean isFull() {
        return size == getCapacity();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void grow() {
        if (isFull()) {
            Object[] newArray = new Object[getCapacity() * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        return (T) array[index];
    }

    public void add(T value) {
        if (isFull()) {
            grow();
        }
        array[size++] = value;
    }

    public void insertAt(int index, T value) {
        if (index > size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");

        if (isFull()) {
            grow();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        size++;
    }

    public void removeAt(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public void updateAt(int index, T value) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        array[index] = value;
    }

    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                if (array[i].equals(value)) return i;
            }
        }
        return -1;
    }
}
