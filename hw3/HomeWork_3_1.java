package hw3;

import java.util.Scanner;

public class HomeWork_3_1 {
    /** Some figure */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();

        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for (int i = height - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
