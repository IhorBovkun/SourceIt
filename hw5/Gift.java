package hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gift {

    List<Candy> gift = new ArrayList<>();

    public void add(Candy o){
        gift.add(o);
    }

    public void print(){
        gift.stream().forEach(System.out::println);
        System.out.println();
    }

    public void getWeight() {
        int total = 0;
        for (Candy candy : gift) {
            total += candy.getWeight();
        }
        System.out.println("Total weight: " + total + "\n");
    }

    /** Sort */
    public void sortWeight() {
        Collections.sort(gift, (Candy a, Candy b) -> {
            if(a.getWeight() > b.getWeight()){
                return 1;
            } else if (a.getWeight() < b.getWeight()){
                return -1;
            } else {
                return 0;
            }
        });
    }

    public void sortSugar() {
        Collections.sort(gift, (Candy a, Candy b) -> {
            if(a.getSugar() > b.getSugar()){
                return 1;
            } else if (a.getSugar() < b.getSugar()){
                return -1;
            } else {
                return 0;
            }
        });
    }

    /** Sugar range */
    public void sugarRange(int left, int right) {
        System.out.println("Range " + left + " - " + right + ":");
        gift.stream().filter(x -> x.getSugar() >= left && x.getSugar() <= right).forEach(System.out::println);
        System.out.println();
    }
}
