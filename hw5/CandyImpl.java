package hw5;

public abstract class CandyImpl extends Object implements Candy {

    private final String name;
    private final int weight;
    private final int sugar;

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getSugar() { return sugar; }

    protected CandyImpl(String name, int weight, int sugar){
        this.name = name;
        this.weight = weight;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return name;
    }
}