package homework.task5;

public class SuperGasCarDemo {
    public static void main(String[] args) {
        SuperGasCar megaCar = new SuperGasCar(100);
        megaCar.refuel(150);
        System.out.println(megaCar.getFuelLevel());
        megaCar.refuel(-200);
        System.out.println(megaCar.getFuelLevel());
    }
}
