import GenericArrayList.GenericArrayList;

void main() {
    GenericArrayList<Integer> list = new GenericArrayList<Integer>();

    System.out.println("Lista vazia? " + list.isEmpty());

    // Adicionando elementos
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);

    System.out.println("Tamanho após add: " + list.size());

    // Acessando elementos
    System.out.println("Elemento no índice 0: " + list.get(0));
    System.out.println("Elemento no índice 2: " + list.get(2));

    // Inserção em posição específica
    list.insertAt(2, 99); // [10, 20, 99, 30, 40]

    System.out.println("Após insertAt(2, 99):");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }

    // Atualização
    list.updateAt(1, 555); // [10, 555, 99, 30, 40]

    System.out.println("Após updateAt(1, 555):");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }

    // Busca linear
    int index = list.find(30);
    System.out.println("Índice do valor 30: " + index);

    // Remoção
    list.removeAt(3); // remove o 30

    System.out.println("Após removeAt(3):");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }

    System.out.println("Tamanho final: " + list.size());
    System.out.println("Lista vazia? " + list.isEmpty());
}