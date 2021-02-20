package homework.task13;

import java.util.*;

/**
 * CZESC 1
 * Na podstawie otrzymanej kolekcji miast (obiekty klasy City) stwórz kolejne kolekcje (elementy z kolekcji kopiujemy do nowej):
 * - zbiór kodów państw, w których znajdują się miasta (kod zawarty jest w polu countryCode) (*)
 * - listę miast leżących w Polsce                                                           (*)
 * - listę miast o populacji powyżej 1_000_000                                               (*)
 * - mapę, w której kluczem jest nazwa miasta a wartością obiekt City                        (**)
 * - mapę, w której kluczem jest zaokrąglona do liczby całkowitej szerokość geograficza a wartością lista miast o takiej szerokości (***)
 * Każdy z punktów nalezy zdefiniować w osobnych metodach w postaci
 *      typ_kolekcji nazwa_metody(Collection<City> cities);
 * np.:
 *      public static Set<City> countryCodes(Collection<City> cities){
 *
 *      }
 * W funkcji main wywołaj każdą z metod i wyświetl cześć każdej otrzymanej kolekcji np. pierwszych 100 elementów
 * CZESC 2
 * Zmodyfikuj otrzymane kolekcje z punktu 1 zgodnie z poniższymi punktami:
 *  - usuń z kolekcji cities miasta o populacji mniejszej od 10_000 (*)
 *  - w kolekcji miast o populacji powyżej 1_000_000 usuń miasta niemieckie (*)
 *  - w kolekcji miast polskich, za każdym miastem, które w nazwie zawiera słowo Nowa .. dodaj miasto Stara .. np.
 *    Nowa Sól -> Stara Sól, pozostałe dane skopiuj z pasującego miasta (**)
 * W każdym zadaniu wykorzystaj iterator, także każdy z punktów umieść w osobnej metodzie, podobnie jak w części 1
 * Gwiazdkami oznaczony jest stopień trudności.
 */
public class Task13A {
    public static void main(String[] args) {
        Collection<City> cities = Cities.loadCities(Task13A.class.getResourceAsStream("../../cities500.txt"));
        for(City c: cities){
            if (c.getCountryCode().equals("PL") && c.getName().equals("Stara Sól")) {
                System.out.println(c);
            }
        }

        Map<Integer, Set<String>> latitudeCitiesTest = latitudeCities(cities);
        System.out.println(latitudeCitiesTest);

        //do poprawy
//        Iterator<Integer, Set<String>> iterator = latitudeCitiesTest.iterator();
//        for (int i = 0; i < n && iterator.hasNext(); i++)
//            out[i] = iterator.next();
        //System.out.println(latitudeCitiesTest.get(0));


    }

    public static Set<String> codes(Collection<City> cities) {
        Set<String> codes = new TreeSet<>();
        for(City c: cities){
            codes.add(c.getCountryCode());
        }
        return codes;
    }

    public static Set<String> citiesInPoland(Collection<City> cities) {
        Set<String> citiesInPoland = new TreeSet<>();
        for(City c: cities) {
            if(c.getCountryCode().equals("PL")) {
                citiesInPoland.add(c.getName());
            }
        }
        return citiesInPoland;
    }

    public static Set<String> bigPopulation(Collection<City> cities) {
        Set<String> bigPopulation = new TreeSet<>();
        for(City c: cities) {
            if(c.getPopulation() >= 1_000_000) {
                bigPopulation.add(c.getName());
            }
        }
        return bigPopulation;
    }

    public static Map<String, City> countriesAndCity (Collection<City> cities) {
        Map<String, City> countriesAndCities = new HashMap<>();
        for(City c: cities) {
            countriesAndCities.put(c.getName(),c);
        }
        return countriesAndCities;
    }

    //mapę, w której kluczem jest zaokrąglona do liczby całkowitej szerokość geograficza a wartością lista miast o takiej szerokości (***)
    public static Map<Integer, Set<String>> latitudeCities(Collection<City> cities) {
        Map<Integer, Set<String>> latitudeCities = new HashMap<>();
        //kopia kolekcji
        Collection<City> citiesCopy = new ArrayList<>(cities);
        //tymczasowa kolekcja Set do weryfikacji niepowtarzalnosci latitude
        Set<Integer> setTemp = new TreeSet<>();
        for(City c: cities) {
            if(setTemp.add((int) c.getLatitude())) {
                Set<String> citiesWithTheSameLatitude = new TreeSet<>();
                for(City d: citiesCopy) {
                    if(((int) c.getLatitude()) == ((int) d.getLatitude())) {
                        citiesWithTheSameLatitude.add(d.getName());
                    }
                }
                latitudeCities.put((int) c.getLatitude(), citiesWithTheSameLatitude);
            }
        }
        return latitudeCities;
    }
}