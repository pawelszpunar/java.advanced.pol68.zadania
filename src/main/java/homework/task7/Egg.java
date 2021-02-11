package homework.task7;

public class Egg implements ValuableIngredient{
    private static final double CALORIES_PER_GRAM = 1.5;
    private final double weight;
    private final String name;
    private final double price;

    public Egg(String name, double weight, double price) {
        this.weight = weight;
        this.name = name;
        this.price = price;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return weight * CALORIES_PER_GRAM;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public double price() {
        return price;
    }
}
