import GenericDoubleLinkedList.GenericDoubleLinkedList;

void main() {
    GenericDoubleLinkedList<Integer> list = new GenericDoubleLinkedList<Integer>();

    System.out.println("Lista vazia:");
    System.out.println(list.getString());
    System.out.println("size = " + list.size());

    System.out.println("\nAdicionando no final:");
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.getString());

    System.out.println("\nAdicionando no início:");
    list.addFirst(5);
    list.addFirst(1);
    System.out.println(list.getString());

    System.out.println("\nLista invertida:");
    System.out.println(list.getStringReversed());

    System.out.println("\nRemove primeiro:");
    list.removeFirst();
    System.out.println(list.getString());

    System.out.println("\nRemove último:");
    list.removeLast();
    System.out.println(list.getString());

    System.out.println("\nInserindo em posições específicas:");
    list.insertAt(99, 1);
    list.insertAt(77, list.size());
    System.out.println(list.getString());

    System.out.println("\nRemovendo por índice:");
    list.removeAt(1);
    System.out.println(list.getString());

    System.out.println("\nRemovendo por valor (30):");
    list.remove(30);
    System.out.println(list.getString());

    System.out.println("\nGet por índice:");
    System.out.println("Index 1 = " + list.get(1));

    System.out.println("\nUpdate por índice:");
    list.updateAt(555, 1);
    System.out.println(list.getString());

    System.out.println("\nContains:");
    System.out.println("Contém 555? " + list.contains(555));
    System.out.println("Contém 30? " + list.contains(30));

    System.out.println("\nIndexOf:");
    System.out.println("Index de 555 = " + list.indexOf(555));
    System.out.println("Index de 999 = " + list.indexOf(999));

    System.out.println("\nClear:");
    list.clear();
    System.out.println(list.getString());
    System.out.println("size = " + list.size());

    list.add(142);
    list.add(2124);
    list.add(341);
    list.add(87);
    list.add(214);
    list.add(71);
    list.add(122);
    list.add(424);
    list.add(921);
    System.out.println("Iterator:" );

    for (int x : list) {
        System.out.println(x);
    }
}


