package GenericQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException();
        T value = front.value;
        front = front.next;
        size--;

        if (front == null) rear = null;

        return value;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyQueueException();
        return front.value;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("Not have next element");
                Node<T> actualNode = current;
                current = current.next;
                return actualNode.value;
            }
        };
    }

    private static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
            super("Queue is empty");
        }
    }
}
