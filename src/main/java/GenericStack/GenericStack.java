package GenericStack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<T> { // FILO LIFO
    private Node<T> top;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T value) {
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("Not have next element.");
                Node<T> actualNode = current;
                current = current.next;
                return actualNode.value;
            }
        };
    }
}
