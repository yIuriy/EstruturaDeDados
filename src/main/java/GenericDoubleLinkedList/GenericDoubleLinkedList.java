package GenericDoubleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericDoubleLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        newNode.previous = null;
        newNode.next = null;
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        newNode.previous = null;
        newNode.next = null;
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void removeAt(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        if (isEmpty()) return;
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return;
        }
        int middle = size / 2;
        Node<T> temporaryNode = head;
        if (index < middle) {
            for (int i = 1; i <= index; i++) {
                temporaryNode = temporaryNode.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                temporaryNode = temporaryNode.previous;
            }
        }
        temporaryNode.previous.next = temporaryNode.next;
        temporaryNode.next.previous = temporaryNode.previous;
        size--;
    }

    public void remove(T value) {
        if (isEmpty()) return;
        if (head.value.equals(value)) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            size--;
            return;
        }
        Node<T> nodeToRemove = head.next;
        while (nodeToRemove != null) {
            if (nodeToRemove.value.equals(value)) {
                nodeToRemove.previous.next = nodeToRemove.next;
                nodeToRemove.next.previous = nodeToRemove.previous;
                if (nodeToRemove == tail) {
                    tail = tail.previous;
                    tail.next = null;
                }
                size--;
                return;
            }
            nodeToRemove = nodeToRemove.next;
        }
    }

    public T getFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        return head.value;
    }

    public T getLast(){
        if (isEmpty()) throw new NoSuchElementException();
        return tail.value;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        Node<T> actualNode;
        int middle = size / 2;
        if (index < middle) {
            actualNode = head;
            for (int i = 1; i <= index; i++) {
                actualNode = actualNode.next;
            }
        } else {
            actualNode = tail;
            for (int i = size - 1; i > index; i--) {
                actualNode = actualNode.previous;
            }
        }
        return actualNode.value;
    }

    public void insertAt(T value, int index) {
        if (index > size) throw new IndexOutOfBoundsException("The index cannot be greater than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        newNode.previous = null;
        newNode.next = null;
        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                size++;
                return;
            }
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        if (size == index) {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
        int middle = size / 2;
        Node<T> temporaryNode;
        if (index < middle) {
            temporaryNode = head;
            for (int i = 1; i <= index; i++) {
                temporaryNode = temporaryNode.next;
            }
        } else {
            temporaryNode = tail;
            for (int i = size - 1; i > index; i--) {
                temporaryNode = temporaryNode.previous;
            }
        }
        temporaryNode.previous.next = newNode;
        newNode.previous = temporaryNode.previous;
        newNode.next = temporaryNode;
        temporaryNode.previous = newNode;
        size++;
    }

    public void updateAt(T value, int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size " +
                "of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        int middle = size / 2;
        Node<T> actualNode;
        if (index < middle) {
            actualNode = head;
            for (int i = 0; i < index; i++) {
                actualNode = actualNode.next;
            }
        } else {
            actualNode = tail;
            for (int i = size - 1; i > index; i--) {
                actualNode = actualNode.previous;
            }
        }
        actualNode.value = value;
    }

    public boolean contains(T value) {
        if (isEmpty()) return false;
        Node<T> targetNode = head;
        while (targetNode != null) {
            if (targetNode.value.equals(value)) return true;
            targetNode = targetNode.next;
        }
        return false;
    }

    public int indexOf(T value) {
        if (isEmpty()) return -1;
        Node<T> targetNode = head;
        int index = 0;
        while (targetNode != null) {
            if (targetNode.value.equals(value)) {
                return index;
            }
            index++;
            targetNode = targetNode.next;
        }
        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String getString() {
        if (isEmpty()) {
            return "[]";
        }
        Node<T> actualNode = head;
        StringBuilder text = new StringBuilder("[ ");
        while (actualNode != null) {
            text.append(actualNode.value.toString());
            text.append(", ");
            actualNode = actualNode.next;
        }
        text.append("]");
        text.deleteCharAt(text.length() - 3);
        return text.toString();
    }

    public String getStringReversed() {
        if (isEmpty()) {
            return "[]";
        }
        Node<T> actualNode = tail;
        StringBuilder text = new StringBuilder("[ ");
        while (actualNode != null) {
            text.append(actualNode.value.toString());
            text.append(", ");
            actualNode = actualNode.previous;
        }
        text.append("]");
        text.deleteCharAt(text.length() - 3);
        return text.toString();
    }

    @Override
    public Iterator<T> iterator() {
       return new GenericDoubleLinkedIterator();
    }

    private class GenericDoubleLinkedIterator implements Iterator<T> {
        Node<T> current = head;

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
    }
}
