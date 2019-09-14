package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_3_5 {
    /** Matrix turn */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size: ");
        int size = input.nextInt();
        System.out.print("Direction (-1, 0, 1): ");
        int direction = input.nextInt();

        if (size < 0){
            return;
        }

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(arr[i], i);
        }

        print(arr);
        turn(arr, direction);
        print(arr);

    }

    /** Print array */
    static void print(int[][] arr) {
        int size = arr.length;

        for (int depth = 0; depth < size; depth++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[depth][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Turn array */
    static void turn(int[][] arr, int direction) {

        int size = arr.length;

        if (size <= 1)
            return;

        int z = (size - 1);  //	last absolute index
        int maxDepth = (int) Math.ceil(size / 2.0);

        for (int depth = 0; depth < maxDepth; depth++) {
            for (int rowElement = depth;
                 rowElement <= (z - depth - 1) /* last element in row doesn't turns*/;
                 rowElement++) {

                int j = depth, k = rowElement;
                int tmp;

                switch (direction) {
                    case 1:
                        /* 90 */
                        tmp = arr[j][k];
                        for (int swapStep = 3; swapStep > 0; swapStep--) {
                            arr[j][k] = arr[z - k][j];
                            int t = j;
                            j = z - k;
                            k = t;
                        }
                        arr[j][k] = tmp;
                        break;

                    case -1:
                        /* 270 */
                        tmp = arr[j][k];
                        for (int swapStep = 3; swapStep > 0; swapStep--) {
                            arr[j][k] = arr[k][z - j];
                            int t = k;
                            k = z - j;
                            j = t;
                        }
                        arr[j][k] = tmp;
                        break;

                    case 0:
                        /* 180 */
                        tmp = arr[j][k];
                        arr[j][k] = arr[z - j][z - k];
                        arr[z - j][z - k] = tmp;

                        tmp = arr[k][z - j];
                        arr[k][z - j] = arr[z - k][j];
                        arr[z - k][j] = tmp;
                        break;

                    default:
                        break;
                }
            }
        }
    }
}
