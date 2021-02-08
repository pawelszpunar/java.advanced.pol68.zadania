package homework.task3;

public class Laptop extends Device {
    final int batteryCapacity;
    final String dvdDrive;
    final int powerSupply;
    final String producer;
    boolean isWiFi;

    public Laptop(int batteryCapacity, String dvdDrive, int powerSupply, String producer) {
        this.batteryCapacity = batteryCapacity;
        this.dvdDrive = dvdDrive;
        this.powerSupply = powerSupply;
        this.producer = producer;
    }

    public int maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getDvdDrive() {
        return dvdDrive;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    @Override
    public String getProducer() {
        return producer;
    }

//    public boolean isWiFi() {
//        return isWiFi;
//    }
//
//    public void setWiFi(boolean wiFi) {
//        isWiFi = wiFi;
//    }

    @Override
    public String sendSMS(String sms){
        if (isWiFi){
            return "Your laptop is sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }

    @Override
    public boolean isWiFi() {
        return isWiFi;
    }

    @Override
    public void setWiFi(boolean wiFi) {
        isWiFi = wiFi;
    }
}
