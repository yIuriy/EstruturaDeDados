package GenericDeque;

import GenericDoubleLinkedList.GenericDoubleLinkedList;

import java.util.Iterator;

public class GenericDeque<T> implements Iterable<T>{
    private final GenericDoubleLinkedList<T> linkedList = new GenericDoubleLinkedList<T>();

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    public void addFirst(T value) {
        linkedList.addFirst(value);
    }

    public void addLast(T value) {
        linkedList.add(value);
    }

    public void removeFirst() {
        linkedList.removeFirst();
    }

    public void removeLast() {
        linkedList.removeLast();
    }

    public T peekFirst() {
        return linkedList.getFirst();
    }

    public T peekLast() {
        return linkedList.getLast();
    }

    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
