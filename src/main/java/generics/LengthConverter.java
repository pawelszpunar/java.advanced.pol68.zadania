package generics;

public class LengthConverter implements Converter<LengthInMeter, LengthInMile>{

    @Override
    public LengthInMile convert(LengthInMeter value) {
        return new LengthInMile(value.getLength() / 1.8);
    }
}
