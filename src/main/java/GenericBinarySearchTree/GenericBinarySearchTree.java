package GenericBinarySearchTree;

import GenericQueue.GenericQueue;

public class GenericBinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(T value) {
        if (isEmpty()) {
            Node<T> newNode = new Node<T>();
            newNode.value = value;
            root = newNode;
            newNode.count = 1;
            size++;
            return;
        }
        Node<T> current = root;
        while (true) {
            int compared = value.compareTo(current.value);
            if (compared < 0) { // Left
                if (current.left == null) {
                    Node<T> newNode = new Node<T>();
                    newNode.value = value;
                    current.left = newNode;
                    newNode.count = 1;
                    size++;
                    return;
                }
                current = current.left;
            } else if (compared > 0) { // Right
                if (current.right == null) {
                    Node<T> newNode = new Node<T>();
                    newNode.value = value;
                    current.right = newNode;
                    newNode.count = 1;
                    size++;
                    return;
                }
                current = current.right;
            } else {
                current.count++;
                size++;
                return;
            }
        }
    }

    public boolean contains(T value) {
        if (isEmpty()) return false;
        Node<T> current = root;
        while (current != null) {
            int compared = value.compareTo(current.value);
            if (compared < 0) { //
                current = current.left;
            } else if (compared > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public T getMin() {
        if (isEmpty()) throw new EmptyBinarySearchTreeException();
        Node<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public T getMax() {
        if (isEmpty()) throw new EmptyBinarySearchTreeException();
        Node<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public void remove(T value) {
        if (isEmpty()) throw new EmptyBinarySearchTreeException();
        Node<T> current = root;
        Node<T> parent = null;
        while (current != null) {
            int compared = value.compareTo(current.value);
            if (compared < 0) { // left
                parent = current;
                current = current.left;
            } else if (compared > 0) { //right
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) return;
        if (current.count > 1) {
            current.count--;
            return;
        }
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == current) { // Remove the left's children
                parent.left = null;
            } else { // Remove the right's children
                parent.right = null;
            }
        } else if (current.left != null && current.right == null) { // Children are in the left
            if (parent == null) {
                root = current.left;
            } else if (parent.left == current) { // Remove the left's children
                parent.left = current.left;
            } else { // Remove the right's children
                parent.right = current.left;
            }
        } else if (current.left == null && current.right != null) {
            if (parent == null) {
                root = current.right;
            } else if (parent.left == current) { // Remove the left's children
                parent.left = current.right;
            } else { // Remove the right's children
                parent.right = current.right;
            }
        } else { // The node have two children if arrives here
            Node<T> sucessor = current.right;
            Node<T> parentOfSucessor = current;
            while (sucessor.left != null) {
                parentOfSucessor = sucessor;
                sucessor = sucessor.left;
            }
            current.value = sucessor.value;
            current.count = sucessor.count;
            if (parentOfSucessor.left == sucessor) {
                if (sucessor.right != null) {
                    parentOfSucessor.left = sucessor.right;
                } else {
                    parentOfSucessor.left = null;
                }
            } else {
                parentOfSucessor.right = sucessor.right;
            }
        }
        size--;
    }

    public int height(){
        if (isEmpty()) return 0;
        return height(root);
    }

    private int height(Node<T> current){
        if (current == null) return 0;

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void printPreOrderInListFormat() {
        if (isEmpty()) {
            IO.println("[ ]");
            return;
        }
        Node<T> current = root;
        preOrder(current);
        IO.print("\n");
    }

    private void preOrder(Node<T> current) {
        if (current == null) return;
        print(current.value, current.count);
        preOrder(current.left);
        preOrder(current.right);
    }

    public void printInOrderInListFormat() {
        if (isEmpty()) {
            IO.println("[ ]");
            return;
        }
        Node<T> current = root;
        inOrder(current);
        IO.print("\n");

    }

    private void inOrder(Node<T> current) {
        if (current == null) return;
        inOrder(current.left);
        print(current.value, current.count);
        inOrder(current.right);
    }

    public void printPostOrderInListFormat() {
        if (isEmpty()) {
            IO.println("[ ]");
            return;
        }
        Node<T> current = root;
        postOrder(current);
        IO.print("\n");
    }

    private void postOrder(Node<T> current) {
        if (current == null) return;
        postOrder(current.left);
        postOrder(current.right);
        print(current.value, current.count);
    }

    private void print(T value, int count) {
        IO.print(value + "(" + count + ") ");
    }

    public void printRotated() {
        if (isEmpty()) {
            IO.println("[ ]");
            return;
        }
        Node<T> current = root;
        IO.println("--------------------------Rotated--------------------------");
        IO.println();
        rotated(current, 0);
        IO.println();
        IO.println("-----------------------------------------------------------");
    }

    private void rotated(Node<T> current, int level) {
        if (current == null) return;
        rotated(current.right, level + 1);
        for (int i = 0; i < level; i++) IO.print("    ");
        IO.println(current.value);
        rotated(current.left, level + 1);
    }

    public void printPerLevel() {
        if (isEmpty()) {
            IO.println("[ ]");
            return;
        }
        GenericQueue<Node<T>> queue = new GenericQueue<Node<T>>();
        queue.enqueue(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            IO.print("Level " + level + ": ");
            for (int i = 0; i < sizeOfQueue; i++) {
                Node<T> current = queue.dequeue();
                print(current.value, current.count);
                if (current.left != null) {
                    queue.enqueue(current.left);
                }
                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }
            IO.print("\n");
            level++;
        }
    }

    private static class EmptyBinarySearchTreeException extends RuntimeException {
        public EmptyBinarySearchTreeException() {
            super("BST is empty.");
        }
    }

}

