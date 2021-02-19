package homework.task12;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Dish implements Ingredient{
    List<Ingredient> ingredients;
    final String name;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.name = name;
    }

    public void addIngredient (Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> ingredients() {
        List<Ingredient> ingerdientsList = ingredients;
        return ingredients;
    }


    @Override
    public String name() {
        return null;
    }

    @Override
    public double weight() {
        Iterator<Ingredient> iterator = ingredients.iterator();
        double totalWeight = 0;
        while(iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            totalWeight += ingredient.weight();
        }
        return totalWeight;
    }

    @Override
    public double calories() {
        Iterator<Ingredient> iterator = ingredients.iterator();
        double totalCalories = 0;
        while(iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            totalCalories += ingredient.calories();
        }
        return totalCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(ingredients, dish.ingredients) && Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, name);
    }
}
