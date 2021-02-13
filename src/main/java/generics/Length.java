package generics;

abstract public class Length {
    final double length;

    protected Length(double length) {
        this.length = length;
    }

    abstract double getInMeter();
}
