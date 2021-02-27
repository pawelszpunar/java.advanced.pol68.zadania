package homework.task11;

public class Pair<T, U> implements Parable{
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return this.first;
    }

    @Override
    public U getSecond() {
        return this.second;
    }
}
