package hw3;

import java.util.Scanner;

public class HomeWork_3_3 {
    /** Wallpapers */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Stripes: ");
        int stripes = input.nextInt();
        System.out.print("Height: ");
        int height = input.nextInt();
        System.out.print("Width: ");
        int width = input.nextInt();

        for (int i = 0; i < stripes; i++) {
            for (int j = 0; j < height; j++) {
                for (int a = 0; a < width; a++) {
                    System.out.print('+');
                }
                for (int b = 0; b < width; b++) {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }
}
