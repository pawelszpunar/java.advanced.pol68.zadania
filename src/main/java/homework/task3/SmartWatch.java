package homework.task3;

public class SmartWatch extends Device {
    final String producer;
    final int batteryCapacity;
    final String strapColor;
    boolean isWiFi;

    public SmartWatch(String producer, int batteryCapacity, String strapColor) {
        this.producer = producer;
        this.batteryCapacity = batteryCapacity;
        this.strapColor = strapColor;
    }

    public int maxWorkTime(int consumptionPerHour){
        return batteryCapacity/consumptionPerHour;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getStrapColor() {
        return strapColor;
    }

    @Override
    public boolean isWiFi() {
        return isWiFi;
    }

    @Override
    public void setWiFi(boolean wiFi) {
        isWiFi = wiFi;
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
            return "Your smartwatch is Sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
