package hw4;

import java.util.Scanner;

public class HomeWork_4_3 {
    /** Rectangle   */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();

        for (int i = 0; i < width; i++) {
            System.out.print('+');
        }
        System.out.println();

        for (int i = 0; i < height - 2; i++) {
            System.out.print('+');
            for (int j = 0; j < width - 2; j++) {
                System.out.print(' ');
            }
            System.out.println('+');
        }

        for (int i = 0; i < width; i++) {
            System.out.print('+');
        }

    }

}
