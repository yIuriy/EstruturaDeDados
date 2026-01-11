import GenericStack.GenericStack;

void main() {
    GenericStack<Integer> stack = new GenericStack<Integer>();

    System.out.println("Stack vazia? " + stack.isEmpty());
    System.out.println("Tamanho: " + stack.size());

    System.out.println("\n--- PUSH ---");
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("Stack vazia? " + stack.isEmpty());
    System.out.println("Tamanho: " + stack.size());
    System.out.println("Topo (peek): " + stack.peek());

    System.out.println("\n--- ITERATOR (top -> base) ---");
    Iterator<Integer> it = stack.iterator();
    while (it.hasNext()) {
        System.out.println(it.next());
    }

    System.out.println("\n--- POP ---");
    System.out.println("Pop: " + stack.pop());
    System.out.println("Novo topo: " + stack.peek());
    System.out.println("Tamanho: " + stack.size());

    System.out.println("\n--- ESVAZIANDO STACK ---");
    while (!stack.isEmpty()) {
        System.out.println("Pop: " + stack.pop());
    }

    System.out.println("Stack vazia? " + stack.isEmpty());

    System.out.println("\n--- TESTE DE EXCEÇÃO ---");
    try {
        stack.pop();
    } catch (Exception e) {
        System.out.println("Exceção capturada: " + e);
    }
}
