package generics;

public class LengthInMeter extends Length{


    public LengthInMeter(double length) {
        super(length);

    }

    public double getLength() {
        return length;
    }

    @Override
    double getInMeter() {
        return 0;
    }
}
