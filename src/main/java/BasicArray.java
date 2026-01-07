void main(String[] args) {
    final Random random = new Random();
    int[] numbers = new int[5];

//    for (int i = 0; i < numbers.length; i++) {
//        numbers[i] = random.nextInt(0, 100);
//    }

    numbers[0] = 10;
    numbers[1] = 20;
    numbers[2] = 30;

    IO.println(Arrays.toString(numbers));

    IO.println("Greater: " + getGreater(numbers));

    IO.println("Smaller: " + getSmaller(numbers));

    IO.println("Sum: " + sum(numbers));

    IO.println("Filled: " + countHowMuchAreFilled(numbers));
}

public int getGreater(int[] array) {
    int greater = array[0];
    for (int i : array) {
        if (i > greater) greater = i;
    }
    return greater;
}

public int getSmaller(int[] array) {
    int smaller = array[0];
    for (int i : array) {
        if (i < smaller) smaller = i;
    }
    return smaller;
}

public int sum(int[] array) {
    int sum = 0;
    for (int i : array) {
        sum += i;
    }
    return sum;
}

public int countHowMuchAreFilled(int[] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] != 0) {
            count++;
        }
    }
    return count;
}
