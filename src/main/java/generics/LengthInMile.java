package generics;

public class LengthInMile extends Length{


    public LengthInMile(double length) {
        super(length);
    }

    @Override
    double getInMeter() {
        return 0;
    }

    public LengthInMile(LengthInMeter meters){
        super(meters.getLength() / 0.000621371192);
    }

    public double getLength() {
        return length * 0.000621371192;
    }
}
