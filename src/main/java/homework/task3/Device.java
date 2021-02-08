package homework.task3;

abstract public class Device {
    int batteryCapacity;
    String producer;
    boolean isWiFi;

    protected Device(int batteryCapacity, String producer) {
        this.batteryCapacity = batteryCapacity;
        this.producer = producer;
    }

    public boolean isWiFi() {
        return isWiFi;
    }

    public void setWiFi(boolean wiFi) {
        isWiFi = wiFi;
    }

    public String getProducer() {
        return producer;
    }

    public abstract String sendSMS(String sms);

    public int maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
}
