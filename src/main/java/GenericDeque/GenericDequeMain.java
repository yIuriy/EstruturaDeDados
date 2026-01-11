import GenericDeque.GenericDeque;

void main() {
    GenericDeque<Integer> deque = new GenericDeque<Integer>();

    System.out.println("Deque vazio? " + deque.isEmpty());
    System.out.println("Tamanho: " + deque.size());

    // addFirst / addLast
    deque.addFirst(10);   // [10]
    deque.addLast(20);    // [10, 20]
    deque.addFirst(5);    // [5, 10, 20]
    deque.addLast(30);    // [5, 10, 20, 30]

    System.out.println("\nApós inserções:");
    for (Integer value : deque) {
        System.out.print(value + " ");
    }

    System.out.println("\nPrimeiro: " + deque.peekFirst()); // 5
    System.out.println("Último: " + deque.peekLast());     // 30
    System.out.println("Tamanho: " + deque.size());

    // removeFirst / removeLast
    deque.removeFirst();  // remove 5
    deque.removeLast();   // remove 30

    System.out.println("\nApós remoções:");
    for (Integer value : deque) {
        System.out.print(value + " ");
    }

    System.out.println("\nPrimeiro: " + deque.peekFirst()); // 10
    System.out.println("Último: " + deque.peekLast());     // 20
    System.out.println("Tamanho: " + deque.size());

    // esvaziando
    deque.removeFirst();
    deque.removeLast();

    System.out.println("\n\nApós esvaziar:");
    System.out.println("Deque vazio? " + deque.isEmpty());
    System.out.println("Tamanho: " + deque.size());
}