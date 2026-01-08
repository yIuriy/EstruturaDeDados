package GenericLinkedList;

import java.util.HexFormat;
import java.util.LinkedList;

public class GenericLinkedList<T> {
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
        if (isEmpty()) {
            Node<T> temporaryNode = new Node<T>();
            temporaryNode.value = value;
            temporaryNode.next = null;

            head = temporaryNode;
            tail = temporaryNode;
        } else {
            Node<T> temporaryNode = new Node<T>();
            temporaryNode.value = value;
            tail.next = temporaryNode;
            tail = temporaryNode;
        }
        size++;
    }

    public void insertAt(int index, T value) {
        if (index > size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        if (index == 0) {
            Node<T> nodeToInsert = new Node<T>();
            nodeToInsert.value = value;
            if (isEmpty()) {
                nodeToInsert.next = null;
                head = nodeToInsert;
                tail = nodeToInsert;
                size++;
                return;
            }
            nodeToInsert.next = head;
            head = nodeToInsert;
            size++;
            return;
        }
        Node<T> previousNode = head;
        for (int i = 0; i < index - 1; i++) {
            previousNode = previousNode.next;
        }
        Node<T> nodeToInsert = new Node<T>();
        nodeToInsert.value = value;
        nodeToInsert.next = previousNode.next;
        previousNode.next = nodeToInsert;
        if (size == index) {
            tail = nodeToInsert;
        }
        size++;
    }

    public void updateAt(int index, T newValue) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        Node<T> actualNode = head;
        for (int i = 1; i <= index; i++) {
            actualNode = actualNode.next;
        }
        actualNode.value = newValue;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");
        Node<T> actualNode = head;
        for (int i = 1; i <= index; i++) {
            actualNode = actualNode.next;
        }
        return actualNode.value;
    }

    public void removeAt(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("The index cannot be greater or equal than the size of" +
                " list.");
        if (index < 0) throw new IndexOutOfBoundsException("The index cannot be negative.");

        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node<T> previousNode = head;
            for (int i = 1; i <= index - 1; i++) {
                previousNode = previousNode.next;
            }
            Node<T> targetNode = previousNode.next;
            previousNode.next = targetNode.next;
            if (targetNode == tail) {
                tail = previousNode;
            }
        }
        size--;
    }

    public void remove(T value) {
        if (isEmpty()) return;
        if (head.value.equals(value)) { // If the value is in the first index
            head = head.next; // If the list have only 1 element, automatically the head will changed to null
            size--;
            if (size == 1) {
                tail = null;
            }
            return;
        }

        Node<T> previousNode = head;
        while (previousNode.next != null) {
            if (previousNode.next.value.equals(value)) {
                Node<T> nodeToRemove = previousNode.next;

                previousNode.next = nodeToRemove.next;

                if (nodeToRemove == tail) {
                    tail = previousNode;
                }
                size--;
                return;
            }
            previousNode = previousNode.next;
        }
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
}
