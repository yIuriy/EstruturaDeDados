import GenericQueue.GenericQueue;

void main() {
    GenericQueue<Integer> queue = new GenericQueue<Integer>();

    // Teste fila vazia
    System.out.println("Fila vazia? " + queue.isEmpty()); // true

    // Enqueue
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    System.out.println("Tamanho da fila: " + queue.size()); // 3
    System.out.println("Primeiro elemento (peek): " + queue.peek()); // 10

    // Iteração
    System.out.print("Fila (iterator): ");
    Iterator<Integer> it = queue.iterator();
    while (it.hasNext()) {
        System.out.print(it.next() + " ");
    }
    System.out.println();

    // Dequeue
    System.out.println("Removido: " + queue.dequeue()); // 10
    System.out.println("Removido: " + queue.dequeue()); // 20

    System.out.println("Novo peek: " + queue.peek()); // 30
    System.out.println("Tamanho atual: " + queue.size()); // 1

    // Removendo último elemento
    System.out.println("Removido: " + queue.dequeue()); // 30
    System.out.println("Fila vazia? " + queue.isEmpty()); // true

    // Teste de exceção (opcional)
    try {
        queue.dequeue();
    } catch (RuntimeException e) {
        System.out.println("Exceção capturada: " + e.getMessage());
    }
}