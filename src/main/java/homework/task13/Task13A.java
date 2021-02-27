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
        int counter1 = 0;
        for (Map.Entry<Integer, Set<String>> entry : latitudeCitiesTest.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            counter1++;
            if(counter1 == 5) {
                break;
            }
        }


        System.out.println("================");
        //System.out.println(bigPopulation(cities));

        System.out.println(citiesInPolandWithAddedStaraToNowa(cities));


//        for(City c: cities){
//            if (c.getName().equals("Berlin")) {
//                System.out.println(c.getName() + " -> " + c.getCountryCode());
//            }
//
//        }





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


    //usuń z kolekcji cities miasta o populacji mniejszej od 10_000 (*)
    public static Collection<City> onlyBigPopulation(Collection<City> cities) {
        Collection<City> citiesWithBigPopulation = cities;

        for(City c: cities) {
            if(c.getPopulation() < 10_000) {
                citiesWithBigPopulation.remove(c);
            }
        }
        return citiesWithBigPopulation;
    }

    //w kolekcji miast o populacji powyżej 1_000_000 usuń miasta niemieckie (*)
    public static Collection<City> withoutGerCitiesAndBigPopulation(Collection<City> cities) {
        Collection<City> citiesCopy = cities;
        Collection<City> output = new ArrayList<>();
        Iterator<City> iterator = citiesCopy.iterator();
        while(iterator.hasNext()) {
            City a = iterator.next();
            if(!a.getCountryCode().equals("DE")){
                output.add(a);
            }
        }
        return output;

    }

    //kolekcja miast w Polsce

    public static Collection<City> citiesInPolandCollection(Collection<City> cities) {
        Collection<City> citiesInPolandCollection = new ArrayList<>();
        //List<City> citiesInPolandList = List.copyOf(cities);
        Iterator<City> iterator = cities.iterator();
        while(iterator.hasNext()){
            City actualCity = iterator.next();
            if(actualCity.getCountryCode().equals("PL")) {
                citiesInPolandCollection.add(actualCity);
            }
        }
        return citiesInPolandCollection;
    }






    //w kolekcji miast polskich, za każdym miastem, które w nazwie zawiera słowo Nowa .. dodaj miasto Stara .. np.
    public static List<City> citiesInPolandWithAddedStaraToNowa(Collection<City> cities) {
        Collection<City> citiesCopy = cities;
        //List<City> citiesInPolandList = List.copyOf(citiesInPolandCollection(cities));
        List<City> citiesInPolandList = new ArrayList<>(citiesInPolandCollection(cities));
        ListIterator<City> iterator = citiesInPolandList.listIterator();
        while(iterator.hasNext()){
            City currentCity = iterator.next();
            if(currentCity.getName().contains("Nowa")) {
                City cityStaraToAdd = new City(currentCity.getId(), currentCity.getName().replace("Nowa", "Stara"), currentCity.getLongitude(), currentCity.getLatitude(), currentCity.getCountryCode(), currentCity.getPopulation());
                iterator.next();
                iterator.add(cityStaraToAdd);
            }
        }
        return citiesInPolandList;
    }

    //Nowa Sól -> Stara Sól, pozostałe dane skopiuj z pasującego miasta (**)
    public static List<City> citiesInPolandWithRelacedNowaToStara(Collection<City> cities) {

        List<City> citiesCopy = new ArrayList<>(cities);

        //Collection<City> citiesCopy = new ArrayList<>(cities);
        List<City> citiesInPolandList = List.copyOf(citiesInPolandCollection(cities));
        //ListIterator<City> iterator = citiesInPolandList.listIterator();
        ListIterator<City> iterator = citiesCopy.listIterator();
        while(iterator.hasNext()){
            City currentCity = iterator.next();
            if(currentCity.getName().contains("Nowa")) {
                City replacer = new City(currentCity.getId(), currentCity.getName().replace("Nowa", "Stara"), currentCity.getLongitude(), currentCity.getLatitude(), currentCity.getCountryCode(), currentCity.getPopulation());
                iterator.remove();
                iterator.add(replacer);
            }
        }
        return citiesInPolandList;
    }



}
