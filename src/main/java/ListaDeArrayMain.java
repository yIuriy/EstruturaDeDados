import ArrayList.ListaDeArray;

void main() {
    ListaDeArray lista = new ListaDeArray();

    System.out.println("Lista vazia? " + lista.isEmpty());

    // add
    lista.add(10);
    lista.add(20);
    lista.add(30);
    lista.add(40);

    System.out.println("\nApós adds:");
    for (int i = 0; i < lista.getSize(); i++) {
        System.out.println(i + " -> " + lista.get(i));
    }

    // insertAt
    lista.insertAt(2, 99);
    System.out.println("\nApós insertAt(2, 99):");
    for (int i = 0; i < lista.getSize(); i++) {
        System.out.println(i + " -> " + lista.get(i));
    }

    // updateAt
    lista.updateAt(1, 777);
    System.out.println("\nApós updateAt(1, 777):");
    for (int i = 0; i < lista.getSize(); i++) {
        System.out.println(i + " -> " + lista.get(i));
    }

    // find
    int index = lista.find(30);
    System.out.println("\nfind(30) -> índice: " + index);

    // removeAt
    lista.removeAt(3);
    System.out.println("\nApós removeAt(3):");
    for (int i = 0; i < lista.getSize(); i++) {
        System.out.println(i + " -> " + lista.get(i));
    }

    System.out.println("\nLista vazia? " + lista.isEmpty());
}