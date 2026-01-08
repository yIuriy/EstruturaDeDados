import GenericLinkedList.GenericLinkedList;

void main() {
    GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();

    System.out.println("Lista vazia? " + list.isEmpty());
    System.out.println("Tamanho: " + list.size());
    System.out.println("------------");

    // add
    list.add(10);
    list.add(20);
    list.add(30);

    System.out.println("Após add:");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }
    System.out.println("Tamanho: " + list.size());
    System.out.println("------------");

    // insertAt
    list.insertAt(0, 5);   // início
    list.insertAt(2, 15);  // meio
    list.insertAt(list.size(), 40); // final

    System.out.println("Após insertAt:");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }
    System.out.println("Tamanho: " + list.size());
    System.out.println("------------");

    // updateAt
    list.updateAt(2, 17);
    System.out.println("Após updateAt (índice 2 -> 17):");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }
    System.out.println("------------");

    // contains
    System.out.println("Contém 20? " + list.contains(20));
    System.out.println("Contém 99? " + list.contains(99));
    System.out.println("------------");

    // removeAt
    list.removeAt(0); // remove início
    list.removeAt(list.size() - 1); // remove final

    System.out.println("Após removeAt:");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }
    System.out.println("Tamanho: " + list.size());
    System.out.println("------------");

    // remove por valor
    list.remove(20);

    System.out.println("Após remove(20):");
    for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " -> " + list.get(i));
    }
    System.out.println("Tamanho: " + list.size());
    System.out.println("------------");

    System.out.println("Lista vazia? " + list.isEmpty());
}