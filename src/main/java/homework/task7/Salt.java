package homework.task7;

public class Salt implements Ingredient{
    private static final double CALORIES_PER_GRAM = 0;
    private final double weight;
    private final String name;

    public Salt(String name, double weight) {
        this.weight = weight;
        this.name = name;
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
        return "Salt{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
