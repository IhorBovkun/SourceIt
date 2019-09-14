package hw5;

public class Demo {

    public static void main(String[] args) {

        Gift gift = new Gift();

        gift.add(new Caramel());
        gift.add(new Choco());
        gift.add(new Lollipop());
        gift.add(new Choco());
        gift.add(new Lollipop());

        gift.print();
        gift.getWeight();
        gift.sortWeight();
        gift.print();
        gift.sortSugar();
        gift.print();
        gift.sugarRange(8,12);
    }
}
