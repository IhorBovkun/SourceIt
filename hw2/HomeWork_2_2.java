package hw2;

import java.util.Scanner;

public class HomeWork_2_2 {
    /** Triangle Area */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        if(a < 0 || b < 0 || c < 0) {
            System.out.println("Invalid input");
        }

        double p = (a + b + c) / 2;
        System.out.println("Area: " + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
