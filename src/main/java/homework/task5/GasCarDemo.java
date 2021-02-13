package homework.task5;

public class GasCarDemo {
    public static void main(String[] args) {
        GasCar myCar = new GasCar(100);
        System.out.println(myCar.getFuelLevel());
        myCar.refuel(50);
        System.out.println(myCar.getFuelLevel());
        myCar.refuel(70);
        System.out.println(myCar.getFuelLevel());
        myCar.refuel(-200);
        System.out.println(myCar.getFuelLevel());


        System.out.println("====refuel=====");
        GasCar mySecondCar = new GasCar(30);
        mySecondCar.refuel(10);

        System.out.println(mySecondCar.getFuelLevel() + "<-");
        mySecondCar.consume(30);
        System.out.println(mySecondCar.getFuelLevel());
        mySecondCar.refuel(10);
        mySecondCar.consume(2);
        System.out.println(mySecondCar.getFuelLevel());
        mySecondCar.consume(-10);
        System.out.println(mySecondCar.getFuelLevel());

        System.out.println("====consume=====");
        GasCar myCar2 = new GasCar(100);
        myCar2.refuel(50);
        System.out.println(myCar2.getFuelLevel());
        System.out.println(myCar2.consume(70));
        System.out.println(myCar2.getFuelLevel());

        System.out.println("====refuel2=====");
        myCar2.refuel(40);
        System.out.println(myCar2.getFuelLevel());
        System.out.println(myCar2.refuel(80));
        System.out.println(myCar2.getFuelLevel());





    }
}
