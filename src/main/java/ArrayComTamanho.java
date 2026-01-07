void main(String[] args) {
    int[] data = new int[5];
    int size = 0;

    data[size++] = 12; // 0
    data[size++] = 512; // 1
    data[size++] = 1123; // 2
    data[size++] = 742; // 3
    data[size++] = 963; // 4

//    removeAt(data, 2, size);
//    size--;
//
//    print(data, size);
//
//    print(data, size);
//
//    IO.println(find(data, size, 963));
//
//    updateAt(data, size, 4, 999);
//
//    print(data, size);

    data = grow(data, size);

    insertAt(data, 0, 890, size);
    size++;

    insertAt(data, 5, 921, size);
    size++;

    print(data, size);

}

void print(int[] array, int size) {
    for (int i = 0; i < size; i++) {
        System.out.println(i + " - " + array[i] + " ");
    }
    System.out.println("________");
}

void removeAt(int[] array, int index, int size) {
    if (index >= size || index < 0) throw new IndexOutOfBoundsException("Invalid index.");
    for (int i = index; i < size - 1; i++) {
        array[i] = array[i + 1];
    }
}

void insertAt(int[] array, int index, int value, int size) {
    if (index > size || index < 0) throw new IndexOutOfBoundsException("Invalid index.");
    for (int i = size - 1; i >= index; i--) {
        array[i + 1] = array[i];
    }
    array[index] = value;
}

int find(int[] array, int size, int value) {
    for (int i = 0; i < size; i++) {
        if (array[i] == value) return i;
    }
    return -1;
}

void updateAt(int[] array, int size, int index, int value) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
    array[index] = value;
}

int[] grow(int[] array, int size) {
    if (array.length == size) {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    return array;
}