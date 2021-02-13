package generics;

/**
 * Dokończymy klasę po omówieniu interfejsów funkcyjnych
 * @param <T> - klasa długości w jednostce źrółowej
 * @param <R> - klasa długości w jednostce docelowej
 */
public class UniversalLengthConverter<T extends Length, R extends Length> implements Converter<T, R>{


    @Override
    public R convert(T value) {
        //Niestety nie możemy wywołać konstruktora dla typu parametrycznego
        //return new R(new LengthInMeter(value.getInMeter()));
        return null;
    }
}
