package com.l8mdv.sample;

import java.util.Scanner;

public class ScannerTest {

    public static void main2(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).isEmpty()) {
            System.out.println("Got line:["+line+"]");
        }
        System.out.println("Finished");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();

        int largest = Math.max(numberOne, numberTwo);
        int smallest = Math.min(numberOne, numberTwo);

        for (int index = smallest; index <= largest; index++) {
            if ((index % 2) != 0)
                System.out.println(index);
        }
    }
}
