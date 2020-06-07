package hw6_MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        MyList<String> myList = new DefaultMyList<>();

        String strFalse = "Bingo";
        String str = "Hello";
        String str2 = "World";
        String number = "777";
        String e = String.valueOf(Math.E);

        myList.add(str);
        myList.add(str2);
        myList.add(number);
        myList.add(e);
        // myList.clear();

        System.out.print("Add to list: {");
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("[%s],", myList.get(i));
        }
        System.out.print("}" + "\n" + "\n");

        Boolean bool = myList.remove(number);
        System.out.print("Result after use method remove(): {");
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("[%s],", myList.get(i));
        }
        System.out.print("}" + "\n" + "\n");

        bool = myList.remove(strFalse);
        bool = myList.contains(e);

        System.out.println("Test of method contains(): " + bool + "\n");

        Object[] arr = myList.toArray();
        System.out.println("Test of method toArray(): " + Arrays.toString(arr) + "\n");

        DefaultMyList<String> anotherList = new DefaultMyList<>();

        anotherList.add(str);
        anotherList.add(strFalse);

        bool = myList.containsAll(anotherList);
        System.out.println("Test of method containsAll: " + bool);
    }
}
