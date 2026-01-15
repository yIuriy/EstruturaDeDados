package GenericAVL;

class Node<T> {
    T value;
    int count = 0;
    int height = 0;
    Node<T> left;
    Node<T> right;
}
