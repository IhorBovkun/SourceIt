package hw4;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class HomeWork_4_2 {
    /** MaxInteger */

    public static void main(String[] args) {
        final int SIZE = 10;
        int[] array = new int[SIZE];
        Random rnd = new Random(new Date().getTime());
        fillArray(array);
        print(array);
        System.out.println(getMax(array));
    }

    /** Get Max */
    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    /** Fill Array */
    static void fillArray(int[] arr) {
        Random rnd = new Random(new Date().getTime());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(99);
        }
    }

    /** Print */
    static void print(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
