package homework.task5;

public class SuperGasCar extends GasCar{

    public SuperGasCar(double fuelCapacity) {
        super(fuelCapacity);
    }

    @Override
    public double refuel(double fuel) {
        //return super.refuel(fuel) + fuel;
        return super.refuel(fuel) + fuel;
    }
}
