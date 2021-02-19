package collections;

import java.time.LocalDate;
import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> emailStats = new HashMap<>();
        int number = 10;
        System.out.println("Dodawanie do mapy");
        //automatyczne zapakowanie wartości typu int do typu Integer
        emailStats.put("adam@op.pl", number);
        emailStats.put("ola@sda.pl", 567);
        emailStats.put("karolek@karolkowo.edu.pl", 12456);
        System.out.println("Niestety możemy także dodać parę null, null");
        emailStats.put(null, null);
        System.out.println(emailStats);
        System.out.println("Pobieranie wartości na podstawie klucza");
        System.out.println(emailStats.get("adam@op.pl"));
        //null check
        if(null != emailStats.get("ada@op.pl")){
            //automatyczne rozpakowanie z typu Integer do typu prostego int
            int result = emailStats.get("ada@op.pl");
            System.out.println(result);
        } else {
            System.out.println("Brak takiego klucza!");
        }
        System.out.println("Zbiór kluczy");
        System.out.println(emailStats.keySet());
        System.out.println("Iterowanie po mapie przy pomocy Entry i entrySet");
        for(Map.Entry<String, Integer> entry: emailStats.entrySet()) {
            System.out.println("Klucz: " + entry.getKey() + " Wartość: " + entry.getValue());
        }
        System.out.println("Czy istnieje klucz?");
        System.out.println(emailStats.containsKey("ola@sda.pl"));
        System.out.println("Czy istnieje wartość 10");
        System.out.println(emailStats.containsValue(10));

        System.out.println("Usuwamy klucz z null");
        emailStats.remove(null);
        //w TreeMap nie może być kluczy null!!!
        Map<String, Integer> copy = new TreeMap<>(emailStats);
        System.out.println(copy);


        //kilka obiektow pod jednynm kluczem
        //mapa osob dostepnych pod kluczem imię
        Map<String, List<Person>> personsMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        //zanim dodamy konkretną osobę i imieniu, musimy utworzyć kolekcje na obiekty pod tym kluczem
        personsMap.put("Marek", new ArrayList<>());
        //pobieramy kolekcję z pod klucza
        List<Person> list = personsMap.get("MAREK");
        //dodajemy osobę do kolekcji pod kluczem
        list.add(new Person("MAREK", LocalDate.now(), 169));
        personsMap.get("MAREEK").add(new Person("MAREK", LocalDate.of(2000,10,10), 178));
        System.out.println(personsMap);
        //dodaj następne osoby o innym imieniu - ćwiczenie

        //zadanie
        //tree map z mapą person





    }
}
