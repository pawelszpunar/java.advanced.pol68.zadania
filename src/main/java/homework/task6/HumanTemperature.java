package homework.task6;

public class HumanTemperature {
    final double temperature;

    private HumanTemperature(double temperature) {
        this.temperature = temperature;
    }

    public static HumanTemperature of(double temperature){
        if(temperature >= 20 && temperature <=43){
            return new HumanTemperature(temperature);
        }
        return null;
    }

    public double get() {
        return temperature;
    }

    public double getKelvin() {
        return temperature + 273.15;
    }

    public double getFahrenheit() {
        return (temperature * 1.8) + 32;
    }

    public boolean isNormal(){
        if(temperature >= 36 && temperature <= 37){
            return true;
        }
        return false;
    }

    public String format(){
        return String.format("%.2f°C",temperature);
    }




}
