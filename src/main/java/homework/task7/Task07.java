package homework.task7;

/**
 * 1. Zdefiniuj klasy implementujące interfejs Ingredient, która opisuje wagę i kaloryczność składnika dania
 *    - Cheese
 *    - Tomato
 *    - Cake
 *    - Salt
 *    Przy definicji wzoruj się na klasie Egg, możesz też samodzielnie dodać dodakowe pole, jak np. smak, czy koloryczność jednostkową podawaną w konstruktorze
 * 2. Zdefiniuj klasę Dish też implementującą interfejs Ingredient,
 *    - z polem w postaci tablicy obiektów implementujących Ingredient
 *    - z konstruktorem przyjmujący tablicę takich obiektów np. Dish(new Ingredients[]{chees, cake}), gdzie cheese i cake są obiektami klas Cheese i Cake
 *    - z metodami interfejsowymi zwracającymi wagę i kaloryczność całego dania
 * 3. Stwórz kilka różnych obiektów klasy Dish, z różnymi składnikami i przetestuj czy poprawnie działają metody klasy
 * 4. Stwórz obiekt klasy Dish, w którym jednym ze składników jest inne danie.
 * Dla chętnych i ambitnych
 * 5. Zrób całe zadanie uwzględniając cenę składników i całego dania, przy czym nie każdy składnik musi mieć cenę (np. Salt), ale każde danie cenę posiada
 * Wskazówki
 * 1. Zdefiniuj osobno interfejs Valuable z metodą abstrakcyjną zwracająca cenę składnika, oraz interfejs ValuableIngredient łączący oba interfejsy
 * 2. Przy obliczaniu ceny dania należy operatorem instanceof wykryć, który składnik ma cenę
 */
public class Task07 {
    public static void main(String[] args) {

        Ingredient sernik = new Cake("Sernik", 50, 50);
        Ingredient serTopiony = new Cheese("Ser topiony", 50, 5);
        Ingredient jajkoNaMiekko = new Egg("Jajko na miękko", 25, 10);
        Ingredient pomidorKoktajlowy = new Tomato("Pomidor koktajlowy", 60, 7);
        Ingredient solMorska = new Salt("Sól morska", 0.01);
        Dish dish1 = new Dish(new Ingredient[]{sernik, serTopiony, jajkoNaMiekko});
        System.out.println("Danie nr1, waga: " + dish1.weight() + ", kaloryczność:" + dish1.calories() + ", cena całkowita dania: " + dish1.price());

        Ingredient jajko = new Egg("Jajko", 25, 2);
        Ingredient szczyptaSoli = new Salt("Szczypta soli", 0.02);
        Dish jajecznica = new Dish(new Ingredient[]{jajko, szczyptaSoli});
        Tomato pomidorPokrojony = new Tomato("Pomidor pokrojony", 50, 8);
        Dish jajecznicaZPomidorem = new Dish(new Ingredient[]{jajecznica, pomidorPokrojony});
        System.out.println("Danie nr2, waga: " + jajecznicaZPomidorem.weight() + ", kaloryczność: " + jajecznicaZPomidorem.calories() + ", cena całkowita dania: " + jajecznicaZPomidorem.price());
    }
}
