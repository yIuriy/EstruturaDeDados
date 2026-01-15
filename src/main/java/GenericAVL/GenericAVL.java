package GenericAVL;

import GenericQueue.GenericQueue;
import GenericStack.GenericStack;

public class GenericAVL<T extends Comparable<T>> {
    private Node<T> root;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node<T>();
            root.value = value;
            root.count = 1;
            root.height = 0;
            size++;
            return;
        }

        Node<T> parent = null;
        Node<T> current = root;
        GenericQueue<PathNode<T>> path = new GenericQueue<PathNode<T>>();

        while (current != null) {
            path.enqueue(new PathNode<T>(parent, current));
            parent = current;

            int cmp = value.compareTo(current.value);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.count++;
                size++;
                return;
            }
        }
        Node<T> newNode = new Node<T>();
        newNode.value = value;
        newNode.count = 1;
        newNode.height = 0;

        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        path.enqueue(new PathNode<T>(parent, newNode));
        balance(path);

        size++;
    }

    private void balance(GenericQueue<PathNode<T>> path) {
        GenericStack<PathNode<T>> stack = new GenericStack<PathNode<T>>();
        path.forEach(stack::push);

        while (!stack.isEmpty()) {
            PathNode<T> p = stack.pop();
            Node<T> node = p.current;

            updateHeight(node);
            int bf = getBalanceFactor(node);

            if (bf > 1) { // direita pesada
                Node<T> newRoot =
                        (getBalanceFactor(node.right) < 0)
                                ? rotateRightLeft(node)
                                : rotateLeft(node);

                if (p.parent == null) {
                    root = newRoot;
                } else if (p.parent.left == node) {
                    p.parent.left = newRoot;
                } else {
                    p.parent.right = newRoot;
                }
            } else if (bf < -1) { // esquerda pesada
                Node<T> newRoot =
                        (getBalanceFactor(node.left) > 0)
                                ? rotateLeftRight(node)
                                : rotateRight(node);

                if (p.parent == null) {
                    root = newRoot;
                } else if (p.parent.left == node) {
                    p.parent.left = newRoot;
                } else {
                    p.parent.right = newRoot;
                }
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

        GenericQueue<PathNode<T>> path = new GenericQueue<PathNode<T>>();
        Node<T> current = root;
        Node<T> parent = null;

        while (current != null) {
            path.enqueue(new PathNode<T>(parent, current));

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
        removeNode(current, parent, path);
        size--;
        balance(path);
    }

    private void removeNode(Node<T> node, Node<T> parent, GenericQueue<PathNode<T>> path) {

        if (node.left == null && node.right == null) {
            replaceChild(parent, node, null);
        } else if (node.left == null) {
            replaceChild(parent, node, node.right);
        } else if (node.right == null) {
            replaceChild(parent, node, node.left);
        } else {
            Node<T> successorParent = node;
            Node<T> successor = node.right;

            while (successor.left != null) {
                path.enqueue(new PathNode<T>(successorParent, successor));
                successorParent = successor;
                successor = successorParent.left;
            }

            node.value = successor.value;
            node.count = successor.count;

            replaceChild(successorParent, successor, successor.right);
        }
    }

    private void replaceChild(Node<T> parent, Node<T> node, Node<T> newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == node) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }
    }

    private void updateHeight(Node<T> node) {
        node.height = heightFromChildren(node);
    }


    private int heightFromChildren(Node<T> current) {
        int leftHeight = (current.left != null ? current.left.height : -1);
        int rightHeight = (current.right != null ? current.right.height : -1);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int getBalanceFactor(Node<T> node) {
        int leftHeight = (node.left != null ? node.left.height : -1);
        int rightHeight = (node.right != null ? node.right.height : -1);
        return rightHeight - leftHeight;
    }

    private Node<T> rotateRight(Node<T> node1) {
        Node<T> node2 = node1.left;
        Node<T> node3 = node2.right;

        node2.right = node1;
        node1.left = node3;

        updateHeight(node1);
        updateHeight(node2);

        return node2;
    }

    private Node<T> rotateLeft(Node<T> node1) {
        Node<T> node2 = node1.right;
        Node<T> node3 = node2.left;

        node2.left = node1;
        node1.right = node3;

        updateHeight(node1);
        updateHeight(node2);

        return node2;
    }

    private Node<T> rotateLeftRight(Node<T> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node<T> rotateRightLeft(Node<T> node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
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

    private static class PathNode<T> {
        Node<T> parent;
        Node<T> current;

        PathNode(Node<T> parent, Node<T> current) {
            this.parent = parent;
            this.current = current;
        }
    }
}