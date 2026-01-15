import GenericAVL.GenericAVL;

void main() {
    GenericAVL<Integer> bst = new GenericAVL<Integer>();

    bst.insert(2);
    bst.insert(1);
    bst.insert(3);

    bst.insert(8);
    bst.insert(3);
    bst.insert(6);
    bst.insert(8);
    bst.insert(1);
    bst.insert(4);
    bst.insert(7);
    bst.insert(10);
    bst.insert(54);
    bst.insert(2);
    bst.insert(42);
    bst.insert(124);
    bst.insert(1245);
    bst.insert(98);
    bst.insert(24);
    bst.insert(3);

    bst.insert(1);
    bst.insert(2);
    bst.insert(3);
    bst.insert(4);
    bst.insert(5);
    bst.insert(6);

    IO.print("Pre-Order: ");
    bst.printPreOrderInListFormat(); // 8, 3, 1, 6, 4, 7, 10, 14, 13

    IO.print("In-Order: ");
    bst.printInOrderInListFormat();

    IO.print("Post-Order: ");
    bst.printPostOrderInListFormat();

    bst.printRotated();

    IO.println("Per Level: ");
    bst.printPerLevel();

    IO.println("Contains[1245]: " + bst.contains(1245));
    IO.println("Contains[25]: " + bst.contains(25));

    bst.remove(8);
    bst.remove(8);
    bst.remove(54);
    bst.remove(6);
    bst.remove(98);
    bst.printRotated();


//     Testing rotate right
    bst.insert(6);
    bst.insert(5);
    bst.insert(4);

    // Testing rotate left
    bst.insert(2);
    bst.insert(9);
    bst.insert(962);
    bst.insert(3);
    bst.insert(4);
    bst.insert(5);
    bst.insert(6);
    bst.insert(2);
    bst.insert(1);
    bst.insert(24);
    bst.insert(51);
    bst.insert(78);
    bst.insert(181);
    bst.insert(781);
    bst.insert(881);
    bst.insert(152);
    bst.insert(123);
    bst.insert(249);
    bst.insert(511);
    bst.insert(728);
    bst.insert(481);
    bst.insert(681);
    bst.insert(181);


    // Testing rotate right left
    bst.insert(3);
    bst.insert(5);
    bst.insert(4);

    // Testing rotate left right
    bst.insert(5);
    bst.insert(3);
    bst.insert(4);

    bst.printRotated();
    bst.remove(1);
    bst.remove(2);
    bst.remove(2);
    bst.remove(3);
    bst.remove(181);
    bst.remove(181);
    bst.printRotated();
}