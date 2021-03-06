package homework.task13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CityPaginator {
    Collection<City> cities;
    int pageSize;
    int page;


    public CityPaginator(Collection<City> cities, int pageSize) {
        this.cities = cities;
        this.pageSize = pageSize;
        this.page = 1;
        //int numberOfPages =
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    //drukuje podana kolekcje wg podanego numeru strony
    public void printPage(Collection<City> cities, int page) {
        if (page < 0 || page > numberOfPages(cities)) {
            System.out.println("Błędny numer strony, otwieram stronę nr 1.");
            page = 1;
        }
        int pageBeginFrom = ((page - 1) * pageSize) + 1;
        int pageEnd = page * pageSize;
        List<City> citiesList = new ArrayList<>(cities);
        System.out.println("Aktualny numer strony: " + page + "/" + numberOfPages(cities));
        for (int i = pageBeginFrom; i <= pageEnd; i++) {
            System.out.println(citiesList.get(i));
        }
    }




    public List<City> nextPage(Collection<City> cities) {
        if (this.page < 0 || this.page + 1 > numberOfPages(cities)) {
            System.out.println("Nie mogę wyświetlić kolejnej strony");
            //this.page = 1;
        } else {
            this.page++;
        }
        return showPage(cities, this.page);
    }

    public List<City> previousPage(Collection<City> cities) {
        if (this.page < 2) {
            System.out.println("Nie mogę wyświetlić poprzedniej strony");
            //this.page = 1;
        } else {
            this.page--;
        }
        return showPage(cities, this.page);
    }

    public List<City> currentPage(Collection<City> cities) {
        return showPage(cities, this.page);
    }

    public List<City> resetPage(Collection<City> cities) {
        this.page = 1;
        return showPage(cities, this.page);
    }

    public List<City> skipToPage(List<City> cities, int skipToPage) {
        if (skipToPage < 0 || skipToPage > numberOfPages(cities)) {
            this.page = 1;
        } else {
            this.page = skipToPage;
        }
        return showPage(cities, this.page);
    }





    //zwraca listę z podaną sroną z kolekcji cities
    public List<City> showPage(Collection<City> cities, int page) {
        if (page < 0 || page > numberOfPages(cities)) {
            System.out.println("Błędny numer strony, otwieram stronę nr 1.");
            page = 1;
        }
        int pageBeginFrom = ((page - 1) * pageSize) + 1;
        int pageEnd = page * pageSize;
        List<City> citiesList = new ArrayList<>(cities);
        List<City> citiesListReturn = new ArrayList<>(cities);

        for (int i = pageBeginFrom; i <= pageEnd; i++) {
            citiesListReturn.add(citiesList.get(i));
        }
        return citiesListReturn;
    }
//
//
//    public List<Cities> nextPage2(Collection<Cities>, int page)
//
//
//
//
//
//
//
//    public List<City> current(Collection<City> cities, int currentPage) {
//        if (currentPage < 0 || currentPage > numberOfPages(cities)) {
//            currentPage = 1;
//            System.out.println("Błędny numer strony, otwieram stronę nr 1.");
//        }
//        int pageBeginFrom = ((currentPage - 1) * pageSize) + 1;
//        int pageEnd = currentPage * pageSize;
//        List<City> citiesList = new ArrayList<>(cities);
//        List<City> citiesListReturn = new ArrayList<>(cities);
//
//
//        for (int i = pageBeginFrom; i <= pageEnd; i++) {
//            citiesListReturn.add(citiesList.get(i));
//        }
//        return citiesListReturn;
//    }
//
//    public void previousPage(Collection<City> cities, int currentPage) {
//        if (currentPage - 1 < 0 || currentPage - 1 > numberOfPages(cities)) {
//            currentPage = 1;
//            System.out.println("Błędny numer strony, otwieram stronę nr 1.");
//        }
//        currentPage = currentPage - 1;
//        int pageBeginFrom = ((currentPage - 1) * pageSize) + 1;
//        int pageEnd = currentPage * pageSize;
//        List<City> citiesList = new ArrayList<>(cities);
//
//        for (int i = pageBeginFrom; i <= pageEnd; i++) {
//            System.out.println(citiesList.get(i));
//        }
//    }
//
//    public void nextPage(Collection<City> cities, int currentPage) {
//        if (currentPage + 1 < 0 || currentPage + 1 > numberOfPages(cities)) {
//            currentPage = 1;
//            System.out.println("Błędny numer strony, otwieram stronę nr 1.");
//        }
//        currentPage = currentPage + 1;
//        int pageBeginFrom = ((currentPage - 1) * pageSize) + 1;
//        int pageEnd = currentPage * pageSize;
//        List<City> citiesList = new ArrayList<>(cities);
//
//        for (int i = pageBeginFrom; i <= pageEnd; i++) {
//            System.out.println(citiesList.get(i));
//        }
//    }


    public int numberOfPages(Collection<City> cities) {
        if (cities.size() % this.pageSize == 0) {
            return cities.size() / this.pageSize;
        }
        return cities.size() / this.pageSize + 1;
    }

    public int numberOfItemsOnTheLastPage(Collection<City> cities, int pageSize) {
        if (cities.size() % pageSize == 0) {
            return pageSize;
        }
        return cities.size() - ((numberOfPages(cities) - 1) * pageSize);
    }
}
