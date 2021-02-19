package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("ADAM");
        names.addAll(Arrays.asList("ALA","OLA", "ROBERT"));
        System.out.println(names);
        System.out.println("Metody interfejsu List");
        System.out.println("Pobranie elementu o indeksie");
        System.out.println(names.get(2));
        System.out.println("Wstawienie elementu na podanej pozycji");
        names.add(1,"BEATA");
        System.out.println(names);
        System.out.println("Usuwanie elementu z poanej pozycji");
        names.remove(0);
        System.out.println(names);
        System.out.println("Wstawienie elementów kolekcji począwszy od indeksu");
        names.addAll(2, Arrays.asList("EWA","TOMEK"));
        System.out.println(names);
        System.out.println("Podlista, któa jest widokiem listy głównej");
        //podlista - dostep do czesci listy, modyfikujac podpliste modyfikujemy cala liste
        List<String> subList = names.subList(2,4);
        System.out.println(subList);
        subList.add("XXX");
        System.out.println("Modyfikuje całą listę");
        System.out.println(names);
        System.out.println("Tworzenie kopii listy");
        List<String> copy = new ArrayList<>(subList);
        copy.add("YYYY");
        System.out.println(copy);
        System.out.println(subList);




    }
}
