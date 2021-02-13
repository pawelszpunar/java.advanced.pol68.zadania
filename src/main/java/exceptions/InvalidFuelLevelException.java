package exceptions;

public class InvalidFuelLevelException extends Exception{
    private static final String DEFAULT_MESSAGE = "Komunikat staly";
    private final double fuelLevel;

    public InvalidFuelLevelException(double fuelLevel, String message) {
        super(message);
        //super(DEFAULT_MESSAGE);
        this.fuelLevel = fuelLevel;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public InvalidFuelLevelException() {
        super(DEFAULT_MESSAGE);
        this.fuelLevel = 0;
    }
}
