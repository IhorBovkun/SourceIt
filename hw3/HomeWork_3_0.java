package hw3;

import java.util.Arrays;

public class HomeWork_3_0 {
    /**
     * String sort
     */

    public static void main(String[] args) {

        String[] array = ("Learn Regular Expressions with simple, interactive exercises.").split(" ");
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, (a, b) -> {
            if (a.length() == b.length()) {
                return 0;
            } else {
                return a.length() < b.length() ? -1 : 1;
            }
        });
        System.out.println(Arrays.toString(array));
    }
}