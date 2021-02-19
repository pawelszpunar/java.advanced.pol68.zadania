package homework.task12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Pizza extends Dish implements Ingredient{
    private Set<Ingredient> ingredients;

    public Pizza(String name) {
        super(name);
        this.ingredients = new HashSet<>();
    }

    public boolean addCake(Cake cake){
        for(Ingredient ingredient: ingredients) {
            if(ingredient instanceof Cake) {
                return false;
            }
        }
        ingredients.add(cake);
        return true;
    }

    public boolean addTomato(Tomato tomato){
        for(Ingredient ingredient: ingredients) {
            if(ingredient instanceof Tomato) {
                return false;
            }
        }
        ingredients.add(tomato);
        return true;
    }

    public boolean addCheese(Cheese cheese){
        for(Ingredient ingredient: ingredients) {
            if(ingredient instanceof Cheese) {
                return false;
            }
        }
        ingredients.add(cheese);
        return true;
    }

    public Set<Ingredient> showIngredients() {
        Set<Ingredient> pizzaCopy = ingredients;
        return pizzaCopy;
    }

    //dodaj metody dodające pozostałe składniki
    public boolean isReady(){
        int readyCount = 0;
        for(Ingredient ingredient: ingredients) {
            if(ingredient instanceof Cake) {
                readyCount++;
            }
            if(ingredient instanceof Tomato) {
                readyCount++;
            }
            if(ingredient instanceof Cheese) {
                readyCount++;
            }
        }
        if(readyCount == 3) {
            return true;
        }
        return false;
    }
}
