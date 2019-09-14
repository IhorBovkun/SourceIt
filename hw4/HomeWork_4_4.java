package hw4;

public class HomeWork_4_4 {
    /** Amount of words in string */

    public static void main(String[] args) {
        String s = "A sequence of elements supporting sequential and parallel aggregate operations.";
        System.out.println(getAmountOfWords(s));
    }

    private static int getAmountOfWords(String s) {
        String[] split = s.split("\\s");
        return split.length;
    }
}
