package hw3;

public class HomeWork_3_2 {
    /** Prime numbers */

    public static void main(String[] args) {

        final int SIZE = 100;
        int[] arr = new int[SIZE];
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i < SIZE; i++)
        {
            arr[i] = 1;
        }

        for (int i = 2; i < SIZE; i++)
        {
            if (arr[i] == 1)
            {
                for (int j = i + i; j < SIZE; j += i)
                    arr[j] = 0;
            }
        }

        /** Print */
        for (int i = 0; i < SIZE; i++)
        {
            if (arr[i] == 1){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
