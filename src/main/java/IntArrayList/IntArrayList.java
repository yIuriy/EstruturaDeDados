package IntArrayList;

public class IntArrayList {
    private int size = 0;
    private int[] array = new int[10];

    private int getCapacity() {
        return array.length;
    }

    private boolean isFull() {
        return size == getCapacity();
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void grow() {
        if (isFull()) {
            int[] newArray = new int[getCapacity() * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public int get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        return array[index];
    }

    public void add(int value) {
        if (isFull()) {
            grow();
        }
        array[size] = value;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index > size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        if (size == getCapacity()) {
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
        size--;
    }

    public void updateAt(int index, int value) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of array.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        array[index] = value;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
