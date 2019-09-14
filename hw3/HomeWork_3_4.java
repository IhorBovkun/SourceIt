package hw3;

import java.util.Date;
import java.util.Random;

public class HomeWork_3_4 {
    /** Arrays for 10 & 20 elements */

    public static void main(String[] args) {
        int SIZE_1 = 10;
        int SIZE_2 = 20;
        int[] arr1 = new int [SIZE_1];
        int[] arr2 = new int [SIZE_2];
        Date dt = new Date();
        Random rnd = new Random(dt.getTime());

        for (int i = 0; i < SIZE_1; i++) {
            arr1[i] = rnd.nextInt(99);

            arr2[i] = arr1[i];
            arr2[i + SIZE_1] = arr1[i] * 2;
        }

        printArr(arr1, SIZE_1);
        printArr(arr2, SIZE_2);

    }

    /** Print array */
    public static void printArr(int[] arr, int size){
        for (int i = 0; i < size; i++) {
            if(((i % 10) == 0)  &&  (i != 0)){
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println( );
    }
}