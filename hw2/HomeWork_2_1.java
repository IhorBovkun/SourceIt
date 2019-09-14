package hw2;

import java.util.Scanner;

public class HomeWork_2_1 {
    /** Singly output */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int CAPACITY = 10;
        int num;
        int digits = 0;
        boolean negative = false;
        int[] output = new int[CAPACITY];

        num = input.nextInt();
        if (num == 0){
            System.out.println(0);
        } else if (num < 0){
            negative = true;
            num = Math.abs(num);
        }

        for (int i = (output.length - 1); num > 0; i--){
            output[i] = num % 10;
            num = num / 10;
            digits++;
        }

        if(negative){
            System.out.println('-');
        }
        for (int i = output.length - digits; i < output.length; i++){
            System.out.println(output[i]);
        }
    }
}
